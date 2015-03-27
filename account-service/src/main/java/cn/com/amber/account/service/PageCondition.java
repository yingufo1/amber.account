package cn.com.amber.account.service;

public interface PageCondition<T> {
	public enum Order{
		ASC("asc"),DESC("desc");
		private String code;
		private Order(String code){
			this.code = code;
		}
		
		public String getCode(){
			return this.code;
		}
	}
	public T getTemplate();
	public int getPage();
	public int getPageSize();
	public Order getOrder();
	public String getSortPropertyName();
}
