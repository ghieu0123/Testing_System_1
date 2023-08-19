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
@Table(name = "TypeQuestion", catalog = "TestingSystem", uniqueConstraints = @UniqueConstraint(columnNames = { "TypeName" }))
public class TypeQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "TypeID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "TypeName", nullable = false, updatable = true)
	private TypeName name;
	
	@OneToMany(mappedBy = "typeQuestion")
	private List<Question> questions;
	
	public TypeQuestion() {
	}
	
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public TypeName getName() {
		return name;
	}

	public void setName(TypeName name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "TypeQuestion [typeId=" + id + ", typeName=" + name + "]";
	}

	public enum TypeName{
		ESAY("0"), MULTIPLE_CHOICE("1");
		
		private String typeName;

		private TypeName(String name) {
			this.typeName = name;
		}

		public String getTypeName() {
			return typeName;
		}
		
		public static TypeName toEnum(String sqlStatus) {
			for(TypeName item: TypeName.values()) {
				if(item.getTypeName().equals(sqlStatus))
					return item;
			}
			return null;
		}
	}
}
