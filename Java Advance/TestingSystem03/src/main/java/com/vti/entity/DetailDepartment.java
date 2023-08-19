	package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetailDepartment", catalog = "TestingSystem")
public class DetailDepartment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "EmulationPoint")
	private Short emulationPoint;
	
	@OneToOne
	@JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "AddressID")
	private Address address;
	
	public DetailDepartment() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public Short getEmulationPoint() {
		return emulationPoint;
	}

	public void setEmulationPoint(Short emulationPoint) {
		this.emulationPoint = emulationPoint;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DetailDepartment [departmentId=" + id + ", emulationPoint="
				+ emulationPoint + ", department=" + department + ", address=" + address.getAddressName() + "]";
	}
	
}
