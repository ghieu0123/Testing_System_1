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
@Table(name = "CategoryQuestion", catalog = "TestingSystem", uniqueConstraints = @UniqueConstraint(columnNames = { "CategoryName" }))
public class CategoryQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CategoryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "CategoryName", length = 50, nullable = false, updatable = true)
	private String name;
	
	@OneToMany(mappedBy = "categoryQuestion")
	private List<Question> questions;
	
	@OneToMany(mappedBy = "categoryQuestion")
	private List<Exam> exams;
	
	public CategoryQuestion() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getCategoryName() {
		return name;
	}

	public void setCategoryName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "CategoryQuestion [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
