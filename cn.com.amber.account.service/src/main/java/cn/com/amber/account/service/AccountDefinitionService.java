package cn.com.amber.account.service;

import cn.com.amber.account.service.bean.Pageable;
import cn.com.amber.account.service.bean.vo.AccountDefinition;

public interface AccountDefinitionService extends Pageable<AccountDefinition>{
	/**
	 * add a AccountDefinition.return null,if failed;
	 * @param accountDefinition
	 * @return  
	 */
	public AccountDefinition add(AccountDefinition accountDefinition);
	
	/**
	 * get a AccountDefinition by id.return null,if not exist.
	 * @param accountDefinitionId
	 * @return
	 */
	public AccountDefinition getById(long accountDefinitionId);
	
	public AccountDefinition update(AccountDefinition accountDefinition);
}
