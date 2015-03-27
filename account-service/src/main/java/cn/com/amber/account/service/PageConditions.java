package cn.com.amber.account.service;

import cn.com.amber.account.service.PageCondition.Order;

public class PageConditions {

	private final static int DEFAULT_PAGESIZE = 10;

	private PageConditions() {
	}

	public static <T extends PageVo> PageCondition<T> newDefaultPageCondition(T t) {
		return newPageCondition(t, 1, DEFAULT_PAGESIZE, Order.ASC,null);
	}

	public static <T extends PageVo> PageCondition<T> newDirectPageCondition(T t,
			int page, int pageSize) {
		return newPageCondition(t, page, pageSize, Order.ASC,null);
	}

	
	public static <T> PageCondition<T> newPageCondition(final T t,
			final int page, final int pageSize, final Order order,
			final String sortPropertyName) {
		PageCondition<T> condition = new PageCondition<T>() {
			public Order getOrder() {
				return order;
			}

			@Override
			public T getTemplate() {
				return t;
			}

			@Override
			public int getPage() {
				return page;
			}

			@Override
			public int getPageSize() {
				return pageSize;
			}

			@Override
			public String getSortPropertyName() { 
				return sortPropertyName;
			}
		};
		return condition;
	}
}
