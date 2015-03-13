package cn.com.amber.account.service.exception;

public class IllegalParameterException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3724664046123492240L;
	
	public IllegalParameterException(String message){
		setParams(message);
	}
	
	@Override
	public String getErrorCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
