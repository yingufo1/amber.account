package cn.com.amber.account.service.exception;

public class LevelByondLimitException extends AccountCategoryException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4502210675991517087L;
	
	public LevelByondLimitException(int maxLevel) {
		super(String.valueOf(maxLevel)); 
	}
	
	@Override
	public String getErrorCode() {
		// TODO Auto-generated method stub
		return "";
	}
	
}
