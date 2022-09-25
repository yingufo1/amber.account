package cn.com.amber.service;import cn.com.amber.api.dto.req.OpenAccountReq;import cn.com.amber.commons.untils.RandomUtil;import cn.com.amber.entity.Account;import cn.com.amber.entity.Subject;import cn.com.amber.entity.enums.AccountStatusEnum;import cn.com.amber.entity.enums.LegalPersonType;import cn.com.amber.infrastructure.api.enums.ResponseCode;import cn.com.amber.infrastructure.exception.BusinessException;import cn.com.amber.mapper.AccountMapper;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import org.springframework.util.CollectionUtils;import javax.annotation.PostConstruct;import javax.annotation.Resource;import java.math.BigDecimal;import java.util.*;import java.util.stream.Collectors;/** * 账户服务 * * @author yangying * @version 1.0 * @since 2022/9/21 **/@Servicepublic class AccountService {    @Resource    private AccountMapper accountMapper;    @Resource    private SubjectService subjectService;    private Map<LegalPersonType, List<Account>> openAccountRuleMap = new HashMap<>();    @PostConstruct    public void configRules() {        List<Account> ancestorAccounts = accountMapper.selectByLegalPersonId("0");        Map<String, Account> accountMap = ancestorAccounts.stream()                .collect(Collectors.toMap(Account::getAccountName, account -> account, (k1, k2) -> k1));        List<Account> individualRules = new ArrayList<>();        individualRules.add(accountMap.get("应收款"));        individualRules.add(accountMap.get("应付款"));        openAccountRuleMap.put(LegalPersonType.INDIVIDUAL, individualRules);        List<Account> businessAssertRules = new ArrayList<>();        businessAssertRules.add(accountMap.get("应收款"));        businessAssertRules.add(accountMap.get("应付款"));        openAccountRuleMap.put(LegalPersonType.BUSINESS_ASSETS, businessAssertRules);        List<Account> businessFundsRules = new ArrayList<>();        businessFundsRules.add(accountMap.get("应收款"));        businessFundsRules.add(accountMap.get("应付款"));        openAccountRuleMap.put(LegalPersonType.BUSINESS_FUNDS, businessFundsRules);        List<Account> selfRules = new ArrayList<>();        selfRules.add(accountMap.get("银行存款"));        selfRules.add(accountMap.get("主营业务收入"));        openAccountRuleMap.put(LegalPersonType.SELF, selfRules);    }    public Map<LegalPersonType, List<Account>> getConfigRules() {        return Collections.unmodifiableMap(openAccountRuleMap);    }    /**     * 开户     *     * @param openAccountReq 开户请求     * @return 账户号     */    @Transactional    public void open(OpenAccountReq openAccountReq) {        LegalPersonType legalPersonType = LegalPersonType.getValue(openAccountReq.getType());        if (legalPersonType == LegalPersonType.UN_KONW) {            throw BusinessException.create(ResponseCode.OPEN_ACCOUNT_FAIL_UN_KNOW_TYPE);        }        String openUserId = legalPersonType == LegalPersonType.INDIVIDUAL ? openAccountReq.getUserId() :                openAccountReq.getLegalPersonId();        List<Account> accounts = accountMapper.selectByLegalPersonId(openUserId);        if (!CollectionUtils.isEmpty(accounts)) {            throw BusinessException.create(ResponseCode.OPEN_ACCOUNT_FAIL_REPEAT_ID,openUserId);        }        accounts = buildOpenAccounts(openUserId, legalPersonType, openAccountReq.getName());        if (CollectionUtils.isEmpty(accounts)) {            throw BusinessException.create(ResponseCode.OPEN_ACCOUNT_FAIL_NO_RULES);        }        accountMapper.saveBatch(accounts);    }    /**     * 只作为工具类，祖先账户只需要开通一次     *     * @param subjectNos 一级科目号     */    public void openAncestorAccount(List<String> subjectNos) {        List<Subject> subjects = subjectService.querySubjects(subjectNos);        String seq = RandomUtil.getRandomNum(6, 100000);        for (Subject subject : subjects) {            Account account = new Account();            account.setAccountNo(subject.getSubjectNo() + subject.getLevel() + seq);            account.setDirection(subject.getDirection());            account.setLevel(subject.getLevel());            account.setAccountName(subject.getSubjectName());            account.setStatus(AccountStatusEnum.IN_USE.getCode());            account.setLegalPersonId("0");            account.setBalance(BigDecimal.ZERO);            account.setAvailableBalance(BigDecimal.ZERO);            accountMapper.insert(account);            seq = String.format("%06d", Integer.parseInt(seq) + 1);        }        configRules();        OpenAccountReq openAccountReq = new OpenAccountReq(UUID.randomUUID().toString());        openAccountReq.setLegalPersonId("100000000");        openAccountReq.setName("amber-self");        openAccountReq.setType(LegalPersonType.SELF.getCode());        open(openAccountReq);    }    private List<Account> buildOpenAccounts(String openUserId, LegalPersonType legalPersonType,                                            String legalPersonName) {        List<Account> newAccounts = new ArrayList<>();        for (Account parent : getConfigRules().get(legalPersonType)) {            Account account = new Account();            account.setAccountNo(parent.getAccountNo() + legalPersonType.getCode() + openUserId);            account.setAccountName(legalPersonName + "-" + parent.getAccountName());            account.setLegalPersonType(legalPersonType.getCode());            account.setLegalPersonId(openUserId);            account.setDirection(parent.getDirection());            account.setBalance(BigDecimal.ZERO);            account.setAvailableBalance(BigDecimal.ZERO);            account.setLevel(parent.getLevel() + 1);            account.setParentId(parent.getId());            newAccounts.add(account);        }        return newAccounts;    }    /**     * 销户     *     * @param account     * @return     */    public void close(Account account) {    }    /**     * 冻结     *     * @param account     * @return     */    public void froze(Account account) {    }}