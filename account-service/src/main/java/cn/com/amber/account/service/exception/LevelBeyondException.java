package cn.com.amber.account.service.exception;

public class LevelBeyondException extends AccountCategoryException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1616288947899239877L;

	public LevelBeyondException(int maxlevel) {
		super(String.valueOf(maxlevel));
	}
	
	@Override
	public String getErrorCode() {
		// TODO Auto-generated method stub
		return "";
	}
}
