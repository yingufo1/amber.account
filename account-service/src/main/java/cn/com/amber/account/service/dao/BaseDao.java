package cn.com.amber.account.service.dao;

import java.util.List;

public interface BaseDao<T> {
	List<T> getAll();
	T persist(T t);
	T update(T t);
}
