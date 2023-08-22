	package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "DepartmentID")
@Table(name = "DetailDepartment", catalog = "TestingSystem")
public class DetailDepartment extends Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "EmulationPoint")
	private Short emulationPoint;
	
	@ManyToOne
	@JoinColumn(name = "AddressID")
	private Address address;
	
	public DetailDepartment() {
	}

	public Short getEmulationPoint() {
		return emulationPoint;
	}

	public void setEmulationPoint(Short emulationPoint) {
		this.emulationPoint = emulationPoint;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DetailDepartment [departmentId=" + getId() + ", emulationPoint="
				+ emulationPoint + ", address=" + address.getAddressName() + "]";
	}
	
}
