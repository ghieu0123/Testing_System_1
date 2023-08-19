package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "GroupAccount", catalog = "TestingSystem")
public class GroupAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID")
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
	@JoinColumn(name = "DepartmentID")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "PositionID")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "SalaryID")
	private Salary salary;
	
	@OneToOne(mappedBy = "account")
	private Employee employee;
	
	@OneToOne(mappedBy = "account")
	private Manager manager;
	
	@OneToMany(mappedBy = "account")
	private List<Group> groups;
	
	public GroupAccount() {	
	}
	
	@PrePersist
	public void prePersit() {
		if(createdDate == null) {
			createdDate = new Date();
		}
	}

	
}
