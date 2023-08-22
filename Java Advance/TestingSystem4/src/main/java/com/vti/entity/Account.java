package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Account", catalog = "TestingSystem", uniqueConstraints = @UniqueConstraint(columnNames = { "UserName", "Email" }))
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "Username", length = 50, nullable = false, updatable = false)
	private String username;

	@Column(name = "FirstName", length = 50, nullable = false, updatable = true)
	private String firstName;
	
	@Column(name = "LastName", length = 50, nullable = false, updatable = true)
	private String lastName;
	
	@Formula(" concat(FirstName, ' ', LastName) ")
	private String fullName;
	
	@Column(name = "Email", length = 50, nullable = false, updatable = false)
	private String email;
	
	@Column(name = "CreateDate", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "PositionID", referencedColumnName = "PositionID")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "SalaryID", referencedColumnName = "SalaryID")
	private Salary salary;	

	@OneToMany(mappedBy = "account")
	private List<Group> createdGroups;
	
	@OneToMany(mappedBy = "account")
	private List<GroupAccount> groupAccounts;
	
	public Account() {
	}
	
	@PrePersist
	public void prePersit() {
		if(createdDate == null) {
			createdDate = new Date();
		}
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public List<Group> getCreatedGroups() {
		return createdGroups;
	}

	public void setCreatedGroups(List<Group> createdGroups) {
		this.createdGroups = createdGroups;
	}
	
	public List<GroupAccount> getGroupAccounts() {
		return groupAccounts;
	}

	public void setGroupAccounts(List<GroupAccount> groupAccounts) {
		this.groupAccounts = groupAccounts;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + id + ", email=" + email + ", username=" + username + ", firstName="
				+ firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", department=" + department
				+ ", position=" + position.getPositionName() + ", salary=" + salary.getName() +", createDate=" + createdDate + "]";
	}
}
