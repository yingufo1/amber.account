package cn.com.amber.service;import cn.com.amber.SpringContextBaseTest;import cn.com.amber.api.dto.req.OpenAccountReq;import cn.com.amber.entity.Subject;import cn.com.amber.entity.enums.LegalPersonType;import cn.com.amber.mapper.SubjectMapper;import cn.com.amber.service.account.OpenAccountContext;import org.junit.Test;import javax.annotation.Resource;import java.util.ArrayList;import java.util.List;import java.util.UUID;/** * AccountServiceTest * * @author yangying * @version 1.0 * @since 2022/9/23 **/public class AccountServiceTest extends SpringContextBaseTest {    @Resource    private AccountService accountService;    @Resource    private SubjectMapper subjectMapper;    @Test    public void testOpenSummaryAccount(){        List<Subject> subjects = subjectMapper.selectAll();        List<String> subjectNos = new ArrayList<>();        for(Subject subject:subjects){            subjectNos.add(subject.getSubjectNo());        }        accountService.initSummaryAccount(subjectNos);    }    @Test    public void testOpen(){        OpenAccountReq openAccountReq = new OpenAccountReq(UUID.randomUUID().toString());        openAccountReq.setUserId("3428781231");        openAccountReq.setName("张三");        openAccountReq.setType(LegalPersonType.INDIVIDUAL.getCode());        openAccountReq.setOpenAccountStrategy(OpenAccountContext.STRATEGY_RULE_BASED);        accountService.open(openAccountReq);        openAccountReq = new OpenAccountReq(UUID.randomUUID().toString());        openAccountReq.setLegalPersonId("231287192391");        openAccountReq.setName("李四-资产");        openAccountReq.setType(LegalPersonType.BUSINESS_ASSETS.getCode());        openAccountReq.setOpenAccountStrategy(OpenAccountContext.STRATEGY_RULE_BASED);        accountService.open(openAccountReq);        openAccountReq = new OpenAccountReq(UUID.randomUUID().toString());        openAccountReq.setLegalPersonId("987654251");        openAccountReq.setName("王五-资金");        openAccountReq.setType(LegalPersonType.BUSINESS_FUNDS.getCode());        openAccountReq.setOpenAccountStrategy(OpenAccountContext.STRATEGY_RULE_BASED);        accountService.open(openAccountReq);    }    @Test    public void testInitAndOpen(){        testOpenSummaryAccount();        testOpen();    }}