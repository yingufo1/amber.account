package cn.com.amber.mapper;import cn.com.amber.BaseContainerTest;import cn.com.amber.entity.Account;import com.alibaba.fastjson2.JSONObject;import org.junit.Test;import org.springframework.util.Assert;import javax.annotation.Resource;/** * TODO:class description * * @author yangying * @version 1.0 * @since 2022/9/6 **/public class AccountMapperTest extends BaseContainerTest {    @Resource    AccountMapper accountMapper;    @Test    public void test() {        String accountNo = String.valueOf(201);        /*Account account = new Account();        account.setAccountNo(accountNo);        account.setAccountName("haha" + accountNo);        account.setLevel(1);        account.setParentId(null);        account.setStatus(AccountStatusEnum.IN_USE.getCode());        account.setDirection("C");        account.setForbiddenFlag(11);        account.setBalance(new BigDecimal(100));        account.setAvailableBalance(new BigDecimal(100));        account.setGmtModified(new Date());        int insertCount = accountMapper.insert(account);        Assert.isTrue(insertCount == 1, "插入数据条数错误:" + insertCount);*/        Account account = accountMapper.selectByAccountNo("11",accountNo);        //Account account = accountMapper.selectByAccountNo("2");        System.out.println(JSONObject.toJSONString(account));        Assert.notNull(account, "could not be null");    }}