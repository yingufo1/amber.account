package cn.com.amber.account.service.impl.bean.pojo;

// Generated 2015-3-11 11:56:28 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Entity: 描述账户定义
 */
public class PojoAccountDefinition implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 287474951403589841L;

	/** 
	 * 标识.
	 */

	private long id;

	/** 
	 * 名称.
	 */

	private String name;

	/** 
	 * 最小余额.
	 */

	private long minSurplus;

	/** 
	 * 最大余额.
	 */

	private long maxSurplus;

	/** 
	 * 允许用户拥有最大数目.
	 */

	private boolean userOwnMaxCount;

	/** 
	 * 是否允许有子账户.
	 */

	private boolean isAllowChild;

	/** 
	 * 是否允许关联其他账户.
	 */

	private boolean isAllowRelate;

	/** 
	 * 账户类型，约束请查阅《数据字典》.
	 */

	private String type;

	private Set<PojoAccount> accounts = new HashSet<PojoAccount>(0);

	public PojoAccountDefinition() {
	}

	public PojoAccountDefinition(long id, String name, long minSurplus,
			long maxSurplus, boolean userOwnMaxCount, boolean isAllowChild,
			boolean isAllowRelate, String type) {
		setId(id);
		setName(name);
		setMinSurplus(minSurplus);
		setMaxSurplus(maxSurplus);
		setUserOwnMaxCount(userOwnMaxCount);
		setIsAllowChild(isAllowChild);
		setIsAllowRelate(isAllowRelate);
		setType(type);
	}

	public PojoAccountDefinition(long id, String name, long minSurplus,
			long maxSurplus, boolean userOwnMaxCount, boolean isAllowChild,
			boolean isAllowRelate, String type, Set<PojoAccount> accounts) {
		setId(id);
		setName(name);
		setMinSurplus(minSurplus);
		setMaxSurplus(maxSurplus);
		setUserOwnMaxCount(userOwnMaxCount);
		setIsAllowChild(isAllowChild);
		setIsAllowRelate(isAllowRelate);
		setType(type);
		setAccounts(accounts);
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

	public long getMinSurplus() {
		return this.minSurplus;
	}

	public void setMinSurplus(long minSurplus) {
		this.minSurplus = minSurplus;
	}

	public long getMaxSurplus() {
		return this.maxSurplus;
	}

	public void setMaxSurplus(long maxSurplus) {
		this.maxSurplus = maxSurplus;
	}

	public boolean isUserOwnMaxCount() {
		return this.userOwnMaxCount;
	}

	public void setUserOwnMaxCount(boolean userOwnMaxCount) {
		this.userOwnMaxCount = userOwnMaxCount;
	}

	public boolean isIsAllowChild() {
		return this.isAllowChild;
	}

	public void setIsAllowChild(boolean isAllowChild) {
		this.isAllowChild = isAllowChild;
	}

	public boolean isIsAllowRelate() {
		return this.isAllowRelate;
	}

	public void setIsAllowRelate(boolean isAllowRelate) {
		this.isAllowRelate = isAllowRelate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<PojoAccount> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set<PojoAccount> accounts) {
		this.accounts = accounts;
	}
}
