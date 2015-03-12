package cn.com.amber.account.service.bean;

public class Page {
	
	public static final String ORDER_ASC = "asc";
	public static final String ORDER_DESC = "desc";
	
	private final int pageSize;
	private final int currentPage;
	private final String order;
	
	private final static int DEFAULT_PAGESIZE = 10;
	
	private Page(int pageSize,int currentPage,String order){
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.order = order;
	}
	
	public static Page originalPage(){
		return directSortedPage(1,DEFAULT_PAGESIZE,ORDER_ASC);
	}
	
	public static Page directPage(int pageSize,int currentPage){
		return directSortedPage(pageSize,currentPage,ORDER_ASC);
	}
	
	/**
	 * 
	 * @param pageSize
	 * @param currentPage
	 * @param order 
	 * @return throw IllegalArgumentException if the value neither equal <code>Page.ORDER_ASC</code> 
	 * nor <code>Page.ORDER_DESC</code>
	 */
	 
	public static Page directSortedPage(int pageSize,int currentPage,String order){
		if(order==null||!order.equals(ORDER_ASC)||!order.equals(ORDER_DESC)){
			throw new IllegalArgumentException("parameter order value is Illegal.");
		}
		return new Page(pageSize,currentPage,order);
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public String getOrder() {
		return order;
	}
}
