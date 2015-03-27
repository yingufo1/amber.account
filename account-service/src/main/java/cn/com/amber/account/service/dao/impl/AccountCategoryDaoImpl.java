package cn.com.amber.account.service.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.amber.account.service.bean.pojo.PojoAccountCategory;
import cn.com.amber.account.service.dao.AccountCategoryDao;

@Repository
class AccountCategoryDaoImpl extends PageDaoImpl<PojoAccountCategory> implements
		AccountCategoryDao {
	public PojoAccountCategory getById(long accountCategoryId){
		return (PojoAccountCategory)getSession().get(PojoAccountCategory.class, accountCategoryId);
	}
}
