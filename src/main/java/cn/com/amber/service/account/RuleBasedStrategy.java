package cn.com.amber.service.account;import cn.com.amber.commons.untils.RandomUtil;import cn.com.amber.entity.Account;import cn.com.amber.entity.enums.AccountStatusEnum;import cn.com.amber.entity.enums.LegalPersonType;import cn.com.amber.infrastructure.api.enums.ResponseCode;import cn.com.amber.infrastructure.exception.BusinessException;import cn.com.amber.mapper.AccountMapper;import lombok.extern.slf4j.Slf4j;import org.springframework.stereotype.Component;import org.springframework.util.CollectionUtils;import javax.annotation.PostConstruct;import javax.annotation.Resource;import java.math.BigDecimal;import java.util.*;import java.util.stream.Collectors;/** * 基于规则的开户策略 * * @author yangying * @version 1.0 * @since 2022/9/29 **/@Slf4j@Componentpublic class RuleBasedStrategy implements OpenAccountStrategy {    @Resource    private AccountMapper accountMapper;    private final Map<LegalPersonType, List<Account>> openAccountRuleMap = new HashMap<>();    @PostConstruct    public void configRules() {        log.info("load open account rules begin");        List<Account> totalAccounts = accountMapper.selectByLegalPersonId("0");        Map<String, Account> accountMap = totalAccounts.stream()                .collect(Collectors.toMap(Account::getAccountName, account -> account, (k1, k2) -> k1));        List<Account> individualRules = new ArrayList<>();        individualRules.add(accountMap.get("应收款-个人"));        individualRules.add(accountMap.get("应付款-个人"));        openAccountRuleMap.put(LegalPersonType.INDIVIDUAL, individualRules);        List<Account> businessAssertRules = new ArrayList<>();        businessAssertRules.add(accountMap.get("应收款-企业"));        businessAssertRules.add(accountMap.get("应付款-企业"));        openAccountRuleMap.put(LegalPersonType.BUSINESS_ASSETS, businessAssertRules);        List<Account> businessFundsRules = new ArrayList<>();        businessFundsRules.add(accountMap.get("应收款-企业"));        businessFundsRules.add(accountMap.get("应付款-企业"));        openAccountRuleMap.put(LegalPersonType.BUSINESS_FUNDS, businessFundsRules);        List<Account> selfRules = new ArrayList<>();        selfRules.add(accountMap.get("银行存款"));        selfRules.add(accountMap.get("主营业务收入"));        openAccountRuleMap.put(LegalPersonType.SELF, selfRules);        log.info("load open account rules finish.{}", openAccountRuleMap.keySet());    }    public Map<LegalPersonType, List<Account>> getConfigRules() {        return Collections.unmodifiableMap(openAccountRuleMap);    }    @Override    public List<Account> openAccount(OpenAccountContext context) {        LegalPersonType legalPersonType = LegalPersonType.getValue(context.getLegalPersonType());        if (legalPersonType == LegalPersonType.UN_KNOW) {            throw BusinessException.create(ResponseCode.OPEN_ACCOUNT_FAIL_UN_KNOW_TYPE);        }        String openUserId = resolveOpenUserId(legalPersonType,context);        checkIfRepeat(openUserId);        return doOpenAccount(openUserId, legalPersonType, context.getName(), context.getAccountType());    }    private String resolveOpenUserId(LegalPersonType legalPersonType,OpenAccountContext context){        return legalPersonType == LegalPersonType.INDIVIDUAL ? context.getUserId() :                context.getLegalPersonId();    }    private void checkIfRepeat(String openUserId) {        List<Account> accounts = accountMapper.selectByLegalPersonId(openUserId);        if (!CollectionUtils.isEmpty(accounts)) {            throw BusinessException.create(ResponseCode.OPEN_ACCOUNT_FAIL_REPEAT_ID, openUserId);        }    }    private List<Account> doOpenAccount(String openUserId, LegalPersonType legalPersonType, String accountName,int type) {        List<Account> accounts = buildOpenAccounts(openUserId, legalPersonType, accountName,type);        if (CollectionUtils.isEmpty(accounts)) {            throw BusinessException.create(ResponseCode.OPEN_ACCOUNT_FAIL_NO_RULES);        }        accountMapper.saveBatch(accounts);        return accounts;    }    private List<Account> buildOpenAccounts(String openUserId, LegalPersonType legalPersonType,                                            String legalPersonName,int type) {        List<Account> newAccounts = new ArrayList<>();        String seq = RandomUtil.getRandomNum(4,10000);        for (Account parent : getConfigRules().get(legalPersonType)) {            Account account = new Account();            account.setAccountNo(parent.getAccountNo() + legalPersonType.getCode() +type+ seq);            account.setAccountName(legalPersonName + "-" + parent.getAccountName());            account.setLegalPersonType(legalPersonType.getCode());            account.setLegalPersonId(openUserId);            account.setDirection(parent.getDirection());            account.setBalance(BigDecimal.ZERO);            account.setAvailableBalance(BigDecimal.ZERO);            account.setLevel(parent.getLevel() + 1);            account.setParentId(parent.getId());            account.setType(type);            account.setStatus(AccountStatusEnum.IN_USE.getCode());            newAccounts.add(account);            seq = String.format("%04d",Integer.parseInt(seq)+1);        }        return newAccounts;    }}