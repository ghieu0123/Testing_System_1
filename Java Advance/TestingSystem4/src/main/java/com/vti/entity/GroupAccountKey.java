package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GroupAccountKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID", nullable = false)
	private short groupID;
	
	@Column(name = "AccountID")
	private short accountID;

	/**
	 * @return the groupId
	 */
	public short getGroupID() {
		return groupID;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupID(short groupID) {
		this.groupID = groupID;
	}

	/**
	 * @return the accountId
	 */
	public short getAccountID() {
		return accountID;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(short accountId) {
		this.accountID = accountId;
	}	
}
