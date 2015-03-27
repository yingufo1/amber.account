package cn.com.amber.account.service.exception;

import java.util.ResourceBundle;

public abstract class BaseException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 960830736664404547L; 
	private static ResourceBundle rb = ResourceBundle.getBundle("Exception_Des");
	private Object[] params;

	public BaseException() {
		super();
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}
	
	@Override
	public String getMessage(){
		return String.format(getMessageDes(getErrorCode()), params);
	}
	
	private String getMessageDes(String key){
		return rb.getString(key);
	}
	
	abstract public String getErrorCode();
	
	protected void setParams(Object... params){
		this.params = params;
	}
}
