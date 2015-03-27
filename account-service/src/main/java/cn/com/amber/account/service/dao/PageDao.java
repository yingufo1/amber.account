package cn.com.amber.account.service.dao;

import java.util.List;

public interface PageDao<T> extends BaseDao<T> {
	public List<T> findByPageCondition(T t,int page,int pageSize,String order,String sortPropertyName);
	public long countByPageCondition(T t);
}
