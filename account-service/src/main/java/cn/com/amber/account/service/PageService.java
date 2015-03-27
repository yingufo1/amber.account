package cn.com.amber.account.service;

import cn.com.amber.account.service.bean.PagedListBean;


/**
 * represent service has a ability to return paged list.
 * @author yangying
 *
 * @param <T>
 */
public interface PageService<T>{
	/**
	 * 
	 * @param queryObject
	 * @param page
	 * @return
	 */
	PagedListBean<T> findPagedList(PageCondition<T> pageCondition); 
}
