package cn.com.amber.account.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.com.amber.account.service.bean.PagedListBean;

public class BasePagedListBean<T> implements PagedListBean<T>{
	
	private List<T> item ;
	private long totalCount;
	
	public BasePagedListBean(List<T> item,long totalCount){
		item = new ArrayList<T>(item.size());
		Collections.copy(this.item, item);
		this.totalCount = totalCount;
	}

	@Override
	public List<T> getItem() { 
		return item;
	}

	@Override
	public long getTotalCount() { 
		return totalCount;
	}
}
