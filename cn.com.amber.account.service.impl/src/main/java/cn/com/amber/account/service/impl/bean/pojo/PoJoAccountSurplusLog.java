package cn.com.amber.account.service.impl.bean.pojo;

// Generated 2015-3-11 14:54:15 by Hibernate Tools 4.0.0

import java.math.BigDecimal;

/**
 * Entity: 账户余额流水
 */
public class PoJoAccountSurplusLog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2893094285549010860L;

	/** 
	 * 标识.
	 */

	private long id;

	/** 
	 * 账户变动流水号.
	 */

	private BigDecimal logSeqNo;

	/** 
	 * 记账标记,C:借记;D:贷记.
	 */

	private String accountingFlag;

	/** 
	 * 金额.
	 */

	private long amount;

	/** 
	 * 系统服务日志id.
	 */

	private long sysSerLogId;

	/** 
	 * 账户id.
	 */

	private Long accountId;

	public PoJoAccountSurplusLog() {
	}

	public PoJoAccountSurplusLog(long id, BigDecimal logSeqNo,
			String accountingFlag, long amount, long sysSerLogId) {
		setId(id);
		setLogSeqNo(logSeqNo);
		setAccountingFlag(accountingFlag);
		setAmount(amount);
		setSysSerLogId(sysSerLogId);
	}

	public PoJoAccountSurplusLog(long id, BigDecimal logSeqNo,
			String accountingFlag, long amount, long sysSerLogId, Long accountId) {
		setId(id);
		setLogSeqNo(logSeqNo);
		setAccountingFlag(accountingFlag);
		setAmount(amount);
		setSysSerLogId(sysSerLogId);
		setAccountId(accountId);
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getLogSeqNo() {
		return this.logSeqNo;
	}

	public void setLogSeqNo(BigDecimal logSeqNo) {
		this.logSeqNo = logSeqNo;
	}

	public String getAccountingFlag() {
		return this.accountingFlag;
	}

	public void setAccountingFlag(String accountingFlag) {
		this.accountingFlag = accountingFlag;
	}

	public long getAmount() {
		return this.amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getSysSerLogId() {
		return this.sysSerLogId;
	}

	public void setSysSerLogId(long sysSerLogId) {
		this.sysSerLogId = sysSerLogId;
	}

	public Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

}
