package cn.com.amber.account.service.impl.bean;

import cn.com.amber.account.service.bean.vo.AccountCategory;

public class AccountCategoryImpl implements AccountCategory{
	private long id;
	private String name;
	private String code;
	private Long accMinSurplus;
	private Long accMaxSurplus;
	private Boolean isAllowChild;
	private Boolean isAllowRelate;
	private Boolean isLeafNode;
	private int level;
	private long parentId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getAccMinSurplus() {
		return accMinSurplus;
	}
	public void setAccMinSurplus(Long accMinSurplus) {
		this.accMinSurplus = accMinSurplus;
	}
	public Long getAccMaxSurplus() {
		return accMaxSurplus;
	}
	public void setAccMaxSurplus(Long accMaxSurplus) {
		this.accMaxSurplus = accMaxSurplus;
	}
	public Boolean getIsAllowChild() {
		return isAllowChild;
	}
	public void setIsAllowChild(Boolean isAllowChild) {
		this.isAllowChild = isAllowChild;
	}
	public Boolean getIsAllowRelate() {
		return isAllowRelate;
	}
	public void setIsAllowRelate(Boolean isAllowRelate) {
		this.isAllowRelate = isAllowRelate;
	}
	public Boolean getIsLeafNode() {
		return isLeafNode;
	}
	public void setIsLeafNode(Boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
}
