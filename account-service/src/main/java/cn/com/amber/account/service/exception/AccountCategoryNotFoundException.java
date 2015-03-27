package cn.com.amber.account.service.exception;

public class AccountCategoryNotFoundException extends AccountCategoryException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6592613321874219611L;
	
	public AccountCategoryNotFoundException() {
		super();
	}
	
	public AccountCategoryNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getErrorCode() {
		// TODO Auto-generated method stub
		return "";
	}
}
