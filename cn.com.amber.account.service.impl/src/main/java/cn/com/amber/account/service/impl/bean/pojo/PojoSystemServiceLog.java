package cn.com.amber.account.service.impl.bean.pojo;

// Generated 2015-3-11 14:39:56 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Entity: 系统服务日志
 */
public class PojoSystemServiceLog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5447849292398351859L;

	/**
	 * 标识.
	 */

	private long id;

	/**
	 * 服务提供方.
	 */

	private String serviceProvider;

	/**
	 * 消息id.
	 */

	private String messageId;

	/**
	 * 日志生成日期.
	 */

	private Date logDate;

	/**
	 * 服务ip.
	 */

	private String serviceIp;

	/**
	 * 服务主机名.
	 */

	private String serviceHostName;

	public PojoSystemServiceLog() {
	}

	public PojoSystemServiceLog(long id, String serviceProvider, String messageId,
			Date logDate) {
		setId(id);
		setServiceProvider(serviceProvider);
		setMessageId(messageId);
		setLogDate(logDate);
	}

	public PojoSystemServiceLog(long id, String serviceProvider, String messageId,
			Date logDate, String serviceIp, String serviceHostName) {
		setId(id);
		setServiceProvider(serviceProvider);
		setMessageId(messageId);
		setLogDate(logDate);
		setServiceIp(serviceIp);
		setServiceHostName(serviceHostName);
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServiceProvider() {
		return this.serviceProvider;
	}

	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Date getLogDate() {
		return this.logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getServiceIp() {
		return this.serviceIp;
	}

	public void setServiceIp(String serviceIp) {
		this.serviceIp = serviceIp;
	}

	public String getServiceHostName() {
		return this.serviceHostName;
	}

	public void setServiceHostName(String serviceHostName) {
		this.serviceHostName = serviceHostName;
	}
}
