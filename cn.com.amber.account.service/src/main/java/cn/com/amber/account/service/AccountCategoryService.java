package cn.com.amber.account.service;

import cn.com.amber.account.service.bean.Pageable;
import cn.com.amber.account.service.bean.vo.AccountCategory;
import cn.com.amber.account.service.exception.AccountCategoryException;
import cn.com.amber.account.service.exception.IllegalParameterException;

public interface AccountCategoryService extends Pageable<AccountCategory>{
	/**
	 * add a AccountCategory.
	 * @param accountDefinition
	 * @return  
	 */
	public AccountCategory add(AccountCategory accountCategory) throws AccountCategoryException;
	
	/**
	 * get a AccountDefinition by id.return null,if not exist.
	 * @param accountDefinitionId
	 * @return
	 */
	public AccountCategory getById(long accountCategoryId);
	
	 
	public void adjustSuplusRegion(long accountCategoryId,long minSurplus,long maxSurplus)throws AccountCategoryException,IllegalParameterException;
	 
	public void adjustName(long accountCategoryId,String name)throws AccountCategoryException;

}
