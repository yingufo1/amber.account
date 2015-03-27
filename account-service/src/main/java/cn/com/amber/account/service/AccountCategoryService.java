package cn.com.amber.account.service;

import cn.com.amber.account.service.bean.vo.AccountCategory;
import cn.com.amber.account.service.exception.AccountCategoryException;
import cn.com.amber.account.service.exception.AccountCategoryNotFoundException;
import cn.com.amber.account.service.exception.ImproperModifyPropertyException;

public interface AccountCategoryService extends PageService<AccountCategory>{
	/**
	 * add a AccountCategory.
	 * @param accountDefinition
	 * @return  
	 */
	public AccountCategory add(AccountCategory accountCategory) throws AccountCategoryException;
	
	/**
	 * get a AccountCategory by id.return null,if not exist.
	 * @param accountDefinitionId
	 * @return
	 */
	public AccountCategory getById(long accountCategoryId);
	 /**
	  * <p>
	  * Modify a accountCategory and persistence it.</p></br>
	  * <p>Note:There are only three property of AccountCategory can be modified:name,minSurplus,maxSurplus.
	  * And only leaf node ({@code isLeafNode==true}) can modify minSurplus,maxSurplus.
	  * The change of other property will not be effect</p>
	  * @param accountCategory
	  * @throws AccountCategoryNotFoundException if accountCategory not found by id
	  * @throws ImproperModifyPropertyException if minSurplus and maxSurplus of given accountCategory have changed but it not leaf node
	  */
	public void modiy(AccountCategory accountCategory)throws AccountCategoryNotFoundException,ImproperModifyPropertyException;
}
