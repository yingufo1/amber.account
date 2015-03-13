package cn.com.amber.account.service.bean.vo;

public interface AccountCategory {
	
	public long getId();
	 
	public String getName();

	public String getCode();
 
	public Long getAccMinSurplus();
 
	public Long getAccMaxSurplus();
 
	public Boolean getIsAllowChild();

	public Boolean getIsAllowRelate();
 
	public Boolean getIsLeafNode();
 
	public int getLevel();
 
	public long getParentId();
}
