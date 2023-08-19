package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Address", catalog = "TestingSystem", uniqueConstraints = @UniqueConstraint(columnNames = { "AddressName" }))
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AddressID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "AddressName", length = 100, nullable = false)
	private String addressName;
	
	@OneToMany(mappedBy = "address")
	private List<DetailDepartment> detailDepartments;
	
	public Address() {	
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public List<DetailDepartment> getDetailDepartments() {
		return detailDepartments;
	}

	public void setDetailDepartments(List<DetailDepartment> detailDepartments) {
		this.detailDepartments = detailDepartments;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", username=" + addressName + ", detailDepartments=" + detailDepartments + "]";
	}
	
}
