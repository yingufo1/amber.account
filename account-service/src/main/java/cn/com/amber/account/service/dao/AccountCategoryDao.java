package cn.com.amber.account.service.dao;

import cn.com.amber.account.service.bean.pojo.PojoAccountCategory;

public interface AccountCategoryDao extends PageDao<PojoAccountCategory> {

	public PojoAccountCategory getById(long accountCategoryId);
}
