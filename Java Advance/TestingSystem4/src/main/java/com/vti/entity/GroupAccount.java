package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "GroupAccount", catalog = "TestingSystem")
public class GroupAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GroupAccountKey groupAccountID;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("AccountID")
	@JoinColumn(name = "AccountID")
	private Account account;
	
	@ManyToOne
	@MapsId("GroupID")
	@JoinColumn(name = "GroupID")
	private Group group;
	
	@Column(name = "JoinDate", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date joinDate;
	
	public GroupAccount() {	
	}
	
	@PrePersist
	public void prePersit() {
		if(joinDate == null) {
			joinDate = new Date();
		}
	}

	public GroupAccountKey getGroupAccountID() {
		return groupAccountID;
	}

	public void setGroupAccountID(GroupAccountKey groupAccountID) {
		this.groupAccountID = groupAccountID;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "GroupAccount [groupAccountId=" + groupAccountID + ", group=" + group.getName() + ", account=" + account.getFullName()
				+ ", joinDate=" + joinDate + "]";
	}
}
