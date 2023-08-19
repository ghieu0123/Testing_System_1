package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AccountID")
    private Short accountID;

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private Short workingNumberOfYear;

    @OneToOne
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    private Account account;

    public Employee() {
    }
	
	public short getAccountID() {
		return accountID;
	}

	public void setAccountID(short accountID) {
		this.accountID = accountID;
	}



	/**
	 * @return the workingNumberOfYear
	 */
	public short getWorkingNumberOfYear() {
		return workingNumberOfYear;
	}

	/**
	 * @param workingNumberOfYear the workingNumberOfYear to set
	 */
	public void setWorkingNumberOfYear(short workingNumberOfYear) {
		this.workingNumberOfYear = workingNumberOfYear;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Employee [accountId=" + accountID + ", workingNumberOfYear=" + workingNumberOfYear + ", accountFullname="
				+ account.getFullName() + "]";
	}
	
}
