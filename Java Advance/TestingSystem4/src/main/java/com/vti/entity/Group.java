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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Group", catalog = "TestingSystem", uniqueConstraints = @UniqueConstraint(columnNames = { "GroupName" }))
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "GroupName", length = 50, nullable = false)
	private String name;

	@Column(name = "CreateDate", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "CreatorID", referencedColumnName = "AccountID", updatable = false)
	private Account account;
	
	@OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
	private List<GroupAccount> groupAccounts;
	
	public Group() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public List<GroupAccount> getGroupAccounts() {
		return groupAccounts;
	}

	public void setGroupAccounts(List<GroupAccount> groupAccounts) {
		this.groupAccounts = groupAccounts;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", creatorID=" + account.getId() + ", createdDate=" + createdDate + "]";
	}
	
}
