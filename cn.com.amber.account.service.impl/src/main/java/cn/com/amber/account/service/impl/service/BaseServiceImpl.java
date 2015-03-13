package cn.com.amber.account.service.impl.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import cn.com.amber.commons.untils.BeanCopier;
import cn.com.amber.commons.untils.BeanCopierCreator;

public class BaseServiceImpl {
	static Map<Class<?>,Map<Class<?>,BeanCopier>> classMap = new HashMap<Class<?>,Map<Class<?>,BeanCopier>>();
	
	@Autowired
	protected ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	/**
	 * 创建bean，并复制bean属性
	 * @param src 
	 * @param clazz
	 * @return 
	 */
	protected <T> T copyBean(Object src,Class<T> clazz){
		T des = null;
		try {
			des = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		copyBean(src, des);
		return des;
	}
	
	/**
	 * 复制bean属性
	 * @param src
	 * @param des
	 */
	protected void copyBean(Object src,Object des){
		Map<Class<?>, BeanCopier> copierMap = classMap.get(des.getClass());
		if(copierMap==null){
			copierMap = new HashMap<Class<?>, BeanCopier>();
			classMap.put(src.getClass(), copierMap);
		}
		BeanCopier beanCopier = copierMap.get(des.getClass());
		if(beanCopier==null){
//			net.sf.cglib.beans.BeanCopier beanCopierOld = net.sf.cglib.beans.BeanCopier.create(src.getClass(), des.getClass(), false);
//			try {
				beanCopier = BeanCopierCreator.create(src.getClass(), des.getClass());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			copierMap.put(des.getClass(), beanCopier);
		}
		beanCopier.copy(src, des);
	}
}
