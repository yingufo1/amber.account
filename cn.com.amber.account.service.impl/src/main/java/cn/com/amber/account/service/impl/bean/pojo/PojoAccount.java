package cn.com.amber.account.service.impl.bean.pojo;

// Generated 2015-3-11 11:56:28 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Entity: 客户账户
 */
public class PojoAccount implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 48136579516705422L;

	/** 
	 * 标识.
	 */

	private long id;

	/** 
	 * 账户定义.
	 */

	private PojoAccountDefinition accountDefinition;

	/** 
	 * 账户编码.
	 */

	private String code;

	/** 
	 * 账户名.
	 */

	private String name;

	/** 
	 * 余额.
	 */

	private long surplus;

	/** 
	 * 客户id.
	 */

	private long customerId;

	private Set<PoJoAccountSurplusLog> accountLogs = new HashSet<PoJoAccountSurplusLog>(0);

	public PojoAccount() {
	}

	public PojoAccount(long id, PojoAccountDefinition accountDefinition, String code,
			String name, long surplus, long customerId) {
		setId(id);
		setAccountDefinition(accountDefinition);
		setCode(code);
		setName(name);
		setSurplus(surplus);
		setCustomerId(customerId);
	}

	public PojoAccount(long id, PojoAccountDefinition accountDefinition, String code,
			String name, long surplus, long customerId,
			Set<PoJoAccountSurplusLog> accountLogs) {
		setId(id);
		setAccountDefinition(accountDefinition);
		setCode(code);
		setName(name);
		setSurplus(surplus);
		setCustomerId(customerId);
		setAccountLogs(accountLogs);
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PojoAccountDefinition getAccountDefinition() {
		return this.accountDefinition;
	}

	public void setAccountDefinition(PojoAccountDefinition accountDefinition) {
		this.accountDefinition = accountDefinition;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSurplus() {
		return this.surplus;
	}

	public void setSurplus(long surplus) {
		this.surplus = surplus;
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Set<PoJoAccountSurplusLog> getAccountLogs() {
		return this.accountLogs;
	}

	public void setAccountLogs(Set<PoJoAccountSurplusLog> accountLogs) {
		this.accountLogs = accountLogs;
	}

}
