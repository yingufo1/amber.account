package cn.com.amber.account.service.bean.vo;

public interface AccountDefinition {
	
	public long getId();
	public String getName();
	public long getMinSurplus();
	public long getMaxSurplus() ;
	public boolean isUserOwnMaxCount();
	public boolean isAllowChild();
	public boolean isAllowRelate() ;
	public String getType() ;
}
