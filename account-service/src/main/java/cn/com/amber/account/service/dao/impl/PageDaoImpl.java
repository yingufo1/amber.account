package cn.com.amber.account.service.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import cn.com.amber.account.service.PageCondition;
import cn.com.amber.account.service.bean.pojo.PojoAccountCategory;
import cn.com.amber.account.service.dao.PageDao;

public class PageDaoImpl<T> extends BaseDaoImpl<T> implements PageDao<T>{
	@SuppressWarnings("unchecked")
	public List<T> findByPageCondition(T t,int page,int pageSize,String order,String sortPropertyName){
		Criteria criteria = getSession().createCriteria(PojoAccountCategory.class);
		Example example = Example.create(t);
		adjustExample(example);
		criteria = criteria.add(example);
		Order hinernateOrder = null;
		if(order.equals(PageCondition.Order.ASC.getCode())){
			 hinernateOrder = Order.asc(sortPropertyName);
		}else if(order.equals(PageCondition.Order.DESC.getCode())){
			 hinernateOrder = Order.asc(sortPropertyName);
		}
		criteria = criteria.addOrder(hinernateOrder); 
		criteria.setFirstResult((page-1)*pageSize);
		criteria.setMaxResults(pageSize);
		return criteria.list(); 
	}
	
	public long countByPageCondition(T t){
		Criteria criteria = getSession().createCriteria(PojoAccountCategory.class);
		Example example = Example.create(t);
		adjustExample(example);
		criteria = criteria.add(example);
		criteria.setProjection(Projections.rowCount());
		return (Long)criteria.list().get(0);
	}
	
	private void adjustExample(Example example){
		example.excludeNone();
		example.excludeProperty("id");
	}
}
