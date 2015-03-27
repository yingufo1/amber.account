package cn.com.amber.account.service.bean;

import java.util.List;

public interface PagedListBean<T > {
	List<T> getItem();
	long getTotalCount();
}
