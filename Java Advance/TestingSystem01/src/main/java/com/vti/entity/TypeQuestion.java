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
@Table(name = "TypeQuestion", catalog = "TestingSystem", uniqueConstraints = @UniqueConstraint(columnNames = { "TypeName" }))
public class TypeQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "TypeID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "TypeName", nullable = false, updatable = true)
	private boolean name;
	
	public TypeQuestion() {
	}
	
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public boolean getName() {
		return name;
	}

	public void setName(boolean name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TypeQuestion [id=" + id + ", name=" + name + "]";
	}
}
