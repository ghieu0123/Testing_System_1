package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "Salary", catalog = "TestingSystem", uniqueConstraints = @UniqueConstraint(columnNames = { "SalaryName" }))
public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "SalaryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "SalaryName", nullable = false, updatable = true)
	private int name;
	
	public Salary() {
	}
	
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", name=" + name + "]";
	}
}
