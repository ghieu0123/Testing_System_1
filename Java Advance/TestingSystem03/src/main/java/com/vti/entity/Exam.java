package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "exam", catalog = "TestingSystem")
public class Exam implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ExamID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short examId;

	@Column(name = "`code1`", length = 10, nullable = false)
//	@Id
//	@GenericGenerator(
//			name = "exam-code-generator", 
//			strategy = "com.vti.entity.ExamCodeGenerator"
//	)
//	@GeneratedValue(generator = "exam-code-generator")
	private String code1;

	@Column(name = "`code2`", length = 10)
	private String code2;

	@Column(name = "title", length = 50, nullable = false)
	private String title;

	@Column(name = "duration", columnDefinition = "TINYINT UNSIGNED DEFAULT 45")
	private short duration;

	@Column(name = "create_date", updatable = false) //  columnDefinition = "DATETIME DEFAULT NOW()"
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	@ManyToOne
	@JoinColumn(name = "CategoryID")
	private CategoryQuestion categoryQuestion;
	
	@ManyToOne
	@JoinColumn(name = "CreatorID")
	private Account account;
	
	public Exam() {
	}

	public short getExamId() {
		return examId;
	}

	public void setExamId(short examId) {
		this.examId = examId;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public CategoryQuestion getCategoryQuestion() {
		return categoryQuestion;
	}

	public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
		this.categoryQuestion = categoryQuestion;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", code1=" + code1 + ", code2=" + code2 + ", title=" + title + ", duration="
				+ duration + ", createDate=" + createDate + ", categoryQuestion=" + categoryQuestion + ", account="
				+ account + "]";
	}
	
}
