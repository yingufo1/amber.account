package cn.com.amber.account.service.exception;

public class AccountCategoryException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3346066296976065024L;
	
	public AccountCategoryException(){
	}
	
	public AccountCategoryException(String message){
		setParams(message);
	}

	@Override
	public String getErrorCode() {
		// TODO Auto-generated method stub
		return "";
	}

}
