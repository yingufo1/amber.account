package cn.com.amber.account.service.bean.vo;

import java.util.HashSet;
import java.util.Set;

public class AccountCategory{
	
	/** 
	 * 标识.
	 */

	private long id;

	/** 
	 * 名称.
	 */

	private String name;

	/** 
	 * 账户分类编码.
	 */

	private String code;

	/** 
	 * 最小余额.
	 */

	private Long minSurplus;

	/** 
	 * 最大余额.
	 */

	private Long maxSurplus;

	/** 
	 * 是否允许关联其他账户.
	 */

	private Boolean isAllowRelate;

	/** 
	 * 是否是叶子节点.叶子节点不包含子级，即任何其他的元组不能以此元组为父节点。.
	 */

	private boolean isLeafNode;

	/** 
	 * 级别.顶级为1,次级为2,以此类推.
	 */

	private int categoryLevel;

	/** 
	 * 父级id.如果是顶级，则为null.
	 */

	private Integer parentCategoryId;
	
	private Set<Integer> childrenCategorieId = new HashSet<Integer>(
			0);

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getMinSurplus() {
		return minSurplus;
	}

	public void setMinSurplus(Long minSurplus) {
		this.minSurplus = minSurplus;
	}

	public Long getMaxSurplus() {
		return maxSurplus;
	}

	public void setMaxSurplus(Long maxSurplus) {
		this.maxSurplus = maxSurplus;
	}

	public Boolean getIsAllowRelate() {
		return this.isAllowRelate;
	}

	public void setIsAllowRelate(Boolean isAllowRelate) {
		this.isAllowRelate = isAllowRelate;
	}

	public Boolean getIsLeafNode() {
		return this.isLeafNode;
	}
	
	public void setIsLeafNode(boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	public int getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public Integer getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public Set<Integer> getChildrenCategorieId() {
		return childrenCategorieId;
	}

	public void setChildrenCategorieId(Set<Integer> childrenCategorieId) {
		this.childrenCategorieId = childrenCategorieId;
	}
}
