package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Manager", catalog = "TestingSystem")
public class Manager implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AccountID")
	@Id
	private short id;

	
	@Column(name = "ManagementNumberOfYear", nullable = false)
	private short managementNumberOfYear;
	
	@OneToOne
	@JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
	private Account account;
	
	public Manager() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public short getManagementNumberOfYear() {
		return managementNumberOfYear;
	}

	public void setManagementNumberOfYear(short managementNumberOfYear) {
		this.managementNumberOfYear = managementNumberOfYear;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Manager [accountId=" + id + ", managementNumberOfYear=" + managementNumberOfYear + ", accountFullname="
				+ account.getFullName() + "]";
	}
}
