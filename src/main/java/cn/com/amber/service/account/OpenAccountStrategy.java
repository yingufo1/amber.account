package cn.com.amber.service.account;import cn.com.amber.entity.Account;import java.util.List;/** * 开户策略 * * @author yangying * @version 1.0 * @since 2022/9/29 **/public interface OpenAccountStrategy {    /**     * 开户     * @param context     */    public List<Account> openAccount(OpenAccountContext context);}