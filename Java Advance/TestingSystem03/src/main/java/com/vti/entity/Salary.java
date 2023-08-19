package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Salary", catalog = "TestingSystem", uniqueConstraints = @UniqueConstraint(columnNames = { "SalaryName" }))
public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "SalaryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "SalaryName", nullable = false, updatable = true)
	@Convert(converter = SalaryNameConverter.class)
	private SalaryName name;
	
	@OneToMany(mappedBy = "salary")
	private List<Account> accounts;
	
	public Salary() {
	}
	
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public SalaryName getName() {
		return name;
	}

	public void setSalaryName(SalaryName name) {
		this.name = name;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void setName(SalaryName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Salary [salaryId=" + id + ", salaryName=" + name + ", accounts=" + accounts + "]";
	}
	
	public enum SalaryName{
		DEV("600"), TEST("700"), SCRUMASTER("1500"), PM("2000");
		
		private String name;
		
		private SalaryName(String name) {
			this.name = name;
		}
		
		public String getSalaryName() {
			return name;
		}

		public static SalaryName toEnum(String sqlStatus) {
			for(SalaryName item: SalaryName.values()) {
				if(item.getSalaryName().equals(sqlStatus))
					return item;
			}
			return null;
		}
	}
}
