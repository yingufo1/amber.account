package cn.com.amber.account.service.impl.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import cn.com.amber.account.service.impl.bean.pojo.PojoAccountCategory;
import cn.com.amber.account.service.impl.dao.AccountCategoryDao;

@Repository
class AccountCategoryDaoImpl extends BasoDaoImpl<PojoAccountCategory> implements
		AccountCategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<PojoAccountCategory> queryByExample(PojoAccountCategory queryExample) {
		
		Criteria criteria = getSession().createCriteria(PojoAccountCategory.class);
		Example example = Example.create(queryExample);
		adjustExample(example);
		criteria.add(example);
		return criteria.list();
	}

	@Override
	public long countByExample(PojoAccountCategory queryExample) {
		Criteria criteria = getSession().createCriteria(PojoAccountCategory.class);
		Example example = Example.create(queryExample);
		adjustExample(example);
		return (Long)criteria.setProjection(Projections.rowCount()).add(example).uniqueResult();
	}
	
	private void adjustExample(Example example){
		example.excludeNone();
		example.excludeProperty("id");
	}
	
	public PojoAccountCategory getById(long accountCategoryId){
		return (PojoAccountCategory)getSession().get(PojoAccountCategory.class, accountCategoryId);
	}
}
