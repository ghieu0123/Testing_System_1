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
@Table(name = "Position", catalog = "TestingSystem", uniqueConstraints = @UniqueConstraint(columnNames = { "PositionName" }))
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "PositionName", nullable = false)
	@Convert(converter = PositionNameConverter.class)
	private PositionName name;
	
	@OneToMany(mappedBy = "position")
	private List<Account> accounts;
	
	public Position() {
	}
	
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public PositionName getPositionName() {
		return name;
	}

	public void setPositionName(PositionName name) {
		this.name = name;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Position [positionId=" + id + ", positionName=" + name + ", accounts=" + accounts + "]";
	}
	
	public enum PositionName{
		DEV("Dev"), TEST("Test"), SCRUMASTER("ScrumMaster"), PM("PM");
		
		private String name;

		private PositionName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public static PositionName toEnum(String sqlStatus) {
			for(PositionName item: PositionName.values()){
				if(item.getName().equals(sqlStatus))
					return item;
			}
			return null;
		}
		
	}
}
