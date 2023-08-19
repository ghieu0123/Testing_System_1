package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Answer", catalog = "TestingSystem")
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Answers")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "Content", length = 100, nullable = false, updatable = true)
	private String content;
	
	@Column(name = "isCorrect")
	private boolean isCorrect = true;
	
	@ManyToOne
	@JoinColumn(name = "QuestionID")
	private Question question;
	
	public Answer() {
	}

	
	
	public short getAnswerId() {
		return id;
	}



	public void setAnswerId(short answerId) {
		this.id = answerId;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Boolean getIsCorrect() {
		return isCorrect;
	}



	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}



	public Question getQuestion() {
		return question;
	}



	public void setQuestion(Question question) {
		this.question = question;
	}



	@Override
	public String toString() {
		return "Answer [answerId=" + id + ", Content=" + content + ", isCorrect=" + isCorrect + ", question="
				+ question + "]";
	}
}
