package cn.com.amber.account.service.exception;

public class NotLeafNodeException extends AccountCategoryException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4502210675991517087L;
	
	public NotLeafNodeException() {
		super(); 
	}
	
	@Override
	public String getErrorCode() {
		// TODO Auto-generated method stub
		return "";
	}
	
}
