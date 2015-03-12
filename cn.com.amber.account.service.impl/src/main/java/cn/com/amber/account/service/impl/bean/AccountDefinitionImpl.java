package cn.com.amber.account.service.impl.bean;

import cn.com.amber.account.service.bean.vo.AccountDefinition;

public class AccountDefinitionImpl implements AccountDefinition{
	 
	private long id;
	private String name;
	private long minSurplus;
	private long maxSurplus;
	private boolean userOwnMaxCount;
	private boolean isAllowChild;
	private boolean isAllowRelate;
	private String type;
	
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public long getMinSurplus() {
		return minSurplus;
	}
	public void setMinSurplus(long minSurplus) {
		this.minSurplus = minSurplus;
	}
	
	@Override
	public long getMaxSurplus() {
		return maxSurplus;
	}
	public void setMaxSurplus(long maxSurplus) {
		this.maxSurplus = maxSurplus;
	}
	
	@Override
	public boolean isUserOwnMaxCount() {
		return userOwnMaxCount;
	}
	public void setUserOwnMaxCount(boolean userOwnMaxCount) {
		this.userOwnMaxCount = userOwnMaxCount;
	}
	
	@Override
	public boolean isAllowChild() {
		return isAllowChild;
	}
	public void setAllowChild(boolean isAllowChild) {
		this.isAllowChild = isAllowChild;
	}
	
	@Override
	public boolean isAllowRelate() {
		return isAllowRelate;
	}
	public void setAllowRelate(boolean isAllowRelate) {
		this.isAllowRelate = isAllowRelate;
	}
	
	@Override
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
