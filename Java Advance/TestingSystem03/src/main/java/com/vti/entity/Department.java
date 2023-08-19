package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Department", catalog = "TestingSystem", uniqueConstraints = @UniqueConstraint(columnNames = { "DepartmentName" }))
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "DepartmentName", length = 30, nullable = false, updatable = true)
	private String name;
	
	@OneToOne(mappedBy = "department")
	DetailDepartment detailDepartment;
	
	@OneToMany(mappedBy = "department")
	private List<Account> accounts;
	
	
	public Department() {
	}
	
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return name;
	}

	public void setDepartmentName(String name) {
		this.name = name;
	}
	
	public DetailDepartment getDetailDepartment() {
		return detailDepartment;
	}

	public void setDetailDepartment(DetailDepartment detailDepartment) {
		this.detailDepartment = detailDepartment;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	
}
