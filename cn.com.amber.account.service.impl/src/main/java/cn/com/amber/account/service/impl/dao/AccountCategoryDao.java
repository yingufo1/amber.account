package cn.com.amber.account.service.impl.dao;

import java.util.List;

import cn.com.amber.account.service.impl.bean.pojo.PojoAccountCategory;

public interface AccountCategoryDao extends BaseDao<PojoAccountCategory>{
	
	public List<PojoAccountCategory> queryByExample(PojoAccountCategory queryExample);
	public long countByExample(PojoAccountCategory queryExample);
	public PojoAccountCategory getById(long accountCategoryId);
}
