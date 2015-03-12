package cn.com.amber.account.service.bean;
/**
 * represent service has a ability to return paged list.
 * @author yangying
 *
 * @param <T>
 */
public interface Pageable<T>{
	/**
	 * 
	 * @param queryObject
	 * @param page
	 * @return
	 */
	PagedListBean<T> findPagedList(T queryObject,Page page);
	
	 
	PagedListBean<T> findPagedList(T queryObject,String sortPropertyName,Page page);
}
