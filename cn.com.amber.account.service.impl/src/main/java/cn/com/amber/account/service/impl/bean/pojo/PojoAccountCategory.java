package cn.com.amber.account.service.impl.bean.pojo;

// Generated 2015-3-13 10:37:47 by Hibernate Tools 4.0.0

/**
 * Entity: 描述账户分类.
 为了支持多层次的账户,定义这个实体。账户分类是可多级别的，
 但是非叶子节点是不可以拥有
 acc_min_surplus，acc_max_surplus，  max_count ，is_allow_child， is_allow_relate这几个属性的。所以，所有非叶子节点的上述字段都应该是null。  
 */
public class PojoAccountCategory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1186826375131981892L;

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

	private Long accMinSurplus;

	/** 
	 * 最大余额.
	 */

	private Long accMaxSurplus;

	/** 
	 * 是否允许有子账户.
	 */

	private Boolean isAllowChild;

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

	private int level;

	/** 
	 * 父级id.如果是顶级，则为-1.
	 */

	private long parentId;

	public PojoAccountCategory() {
	}

	public PojoAccountCategory(long id, String name, String code,
			boolean isLeafNode, int level, long parentId) {
		setId(id);
		setName(name);
		setCode(code);
		setIsLeafNode(isLeafNode);
		setLevel(level);
		setParentId(parentId);
	}

	public PojoAccountCategory(long id, String name, String code,
			Long accMinSurplus, Long accMaxSurplus, Boolean isAllowChild,
			Boolean isAllowRelate, boolean isLeafNode, int level,
			long parentId) {
		setId(id);
		setName(name);
		setCode(code);
		setAccMinSurplus(accMinSurplus);
		setAccMaxSurplus(accMaxSurplus);
		setIsAllowChild(isAllowChild);
		setIsAllowRelate(isAllowRelate);
		setIsLeafNode(isLeafNode);
		setLevel(level);
		setParentId(parentId);
	}

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

	public Long getAccMinSurplus() {
		return this.accMinSurplus;
	}

	public void setAccMinSurplus(Long accMinSurplus) {
		this.accMinSurplus = accMinSurplus;
	}

	public Long getAccMaxSurplus() {
		return this.accMaxSurplus;
	}

	public void setAccMaxSurplus(Long accMaxSurplus) {
		this.accMaxSurplus = accMaxSurplus;
	}

	public Boolean getIsAllowChild() {
		return this.isAllowChild;
	}

	public void setIsAllowChild(Boolean isAllowChild) {
		this.isAllowChild = isAllowChild;
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

	public void setIsLeafNode(Boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getParentId() {
		return this.parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

}
