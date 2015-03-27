package cn.com.amber.account.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
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
	 * Create bean by given type clazz,Copy the property values of the given source bean into the new bean. 
	 * <br>note:this method dependency Spring framework {@code BeanUtils.copyProperties}
	 * @see BeanUtils
	 * @param src
	 * @param clazz
	 * @return
	 */
	protected <T> T copyBeanDepeSpring(Object source,Class<T> clazz){
		T des = null;
		try {
			des = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		copyBeanDepeSpring(source, des);
		return des;
	}
	
	/**
	 * Copy the property values of the given source bean into des bean. 
	 * <br>note:this method dependency Spring framework {@code BeanUtils.copyProperties} 
	 * @param src
	 * @param des
	 */
	protected void copyBeanDepeSpring(Object source,Object target){
		 BeanUtils.copyProperties(source, target);
	} 
	
	/**
	 * @deprecated
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
	 * @deprecated
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
