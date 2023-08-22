package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "AccountID")
@Table(name = "Employee")
public class Employee extends Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private Short workingNumberOfYear;

    public Employee() {
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

	@Override
	public String toString() {
		return "Employee [WorkingNumberOfYear=" + workingNumberOfYear + ", account="
				+ getId() + ", name = " + getFullName() +"]";
	}
	
}
