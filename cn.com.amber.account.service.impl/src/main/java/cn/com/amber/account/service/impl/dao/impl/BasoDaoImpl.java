package cn.com.amber.account.service.impl.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.amber.account.service.impl.dao.BaseDao;

public class BasoDaoImpl<T> implements BaseDao<T>{
	
	@Autowired
	private SessionFactory sessionFactory = null;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return getSession().createCriteria(
				(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]
				).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T persist(T t) {
		t = (T)getSession().merge(t.getClass().getSimpleName().replaceFirst("Pojo", ""), t);
		return t;
	}
	
	@Override
	public T update(T t) {
		getSession().update(t);
		return t;
	}
}
