package cn.com.amber.examples;import cn.com.amber.SpringContextBaseTest;import javax.annotation.Resource;/** * 账户集成测试，包括查询科目、开通账户、账务登记、实收登记等 * * @author yangying * @version 1.0 * @since 2022/9/28 **/public class AccountingTest extends SpringContextBaseTest {    @Resource    private void testCreateAccount(){    }    @Resource    private void testAccounting(){    }    @Resource    private void realReceiptRegistration(){    }}