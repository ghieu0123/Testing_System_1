package com.TestingSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.TestingSystem.Enum.TypeName;

public class Program {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		// Department
		Department department1 = new Department();
		department1.departmentId = 1;
		department1.departmentName = "Sales";

		Department department2 = new Department();
		department2.departmentId = 2;
		department2.departmentName = "Marketing";

		Department department3 = new Department();
		department3.departmentId = 3;
		department3.departmentName = "Finance";

		// Position
		Position position1 = new Position();
		position1.positionId = 1;
        position1.positionName = PositionName.POSITION_DEV.getPositionName();    
        
		Position position2 = new Position();
		position2.positionId = 2;
        position2.positionName = PositionName.POSITION_TEST.getPositionName();
        
		Position position3 = new Position();
		position3.positionId = 3;
        position3.positionName = PositionName.POSITION_SCRUM_MASTER.getPositionName();

		// Account
		Account account1 = new Account();
		account1.accountId = 1;
        account1.email = "account1@gmail.com";
        account1.userName = "user1";
        account1.fullName = "Hieu";
        account1.department = department1;
        account1.position = position1;
        account1.createDate = dateFormat.parse("24-12-2001");
        
		Account account2 = new Account();
		account2.accountId = 2;
        account2.email = "account2@gmail.com";
        account2.userName = "user2";
        account2.fullName = "Hao";
        account2.department = department2;
        account2.position = position2;
        account2.createDate = dateFormat.parse("14-04-2002");
        
		Account account3 = new Account();
		account3.accountId = 3;
        account3.email = "account3@gmail.com";
        account3.userName = "user3";
        account3.fullName = "Chien";
        account3.department = department3;
        account3.position = position3;
        account3.createDate = dateFormat.parse("26-01-2002");

		// Group
		Group group1 = new Group();
		group1.groupId = 1;
        group1.groupName = "Group 1";
        group1.creator = account1;
        group1.createDate = new Date();
        
		Group group2 = new Group();
		group2.groupId = 2;
        group2.groupName = "Group 2";
        group2.creator = account2;
        group2.createDate = new Date();
        
		Group group3 = new Group();
		group3.groupId = 3;
        group3.groupName = "Group 3";
        group3.creator = account3;
        group3.createDate = new Date();

		// GroupAccount
		GroupAccount groupAccount1 = new GroupAccount();
		groupAccount1.group = group1;
        groupAccount1.account = account1;
        groupAccount1.joinDate = new Date();
        
		GroupAccount groupAccount2 = new GroupAccount();
		groupAccount2.group = group2;
        groupAccount2.account = account2;
        groupAccount2.joinDate = new Date();
        
		GroupAccount groupAccount3 = new GroupAccount();
		groupAccount3.group = group3;
        groupAccount3.account = account3;
        groupAccount3.joinDate = new Date();

		// TypeQuestion
		TypeQuestion typeQuestion1 = new TypeQuestion();
		typeQuestion1.typeId = 1;
        typeQuestion1.typeName = TypeName.TYPENAME_ESSAY.getTypeName();
        
		TypeQuestion typeQuestion2 = new TypeQuestion();
		typeQuestion2.typeId = 2;
        typeQuestion2.typeName = TypeName.TYPENAME_MUTIPLECHOICE.getTypeName();

		// CategoryQuestion
		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.categoryId = 1;
	    categoryQuestion1.categoryName = "Java";
	    
		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.categoryId = 2;
	    categoryQuestion2.categoryName = ".NET";
	    
		CategoryQuestion categoryQuestion3 = new CategoryQuestion();
		categoryQuestion3.categoryId = 3;
	    categoryQuestion3.categoryName = "SQL";

		// Question
		Question question1 = new Question();
		question1.questionId = 1;
	    question1.content = "Mèo có mấy chân?";
	    question1.category = categoryQuestion1;
	    question1.type = typeQuestion1;
	    question1.creator = account1;
	    
		Question question2 = new Question();
		question2.questionId = 2;
	    question2.content = "Bạn có tiền không?";
	    question2.category = categoryQuestion2;
	    question2.type = typeQuestion2;
	    question2.creator = account2;
	  
		Question question3 = new Question();
		question3.questionId = 3;
	    question3.content = "1 + 1 = ?";
	    question3.category = categoryQuestion3;
	    question3.type = typeQuestion1;
	    question3.creator = account3;
		
		// Answer
		Answer answer1 = new Answer();
		answer1.answerId = 1;
	    answer1.content = "3 chân";
	    answer1.question = question1;
	    answer1.isCorrect = true;
	    
		Answer answer2 = new Answer();
		answer2.answerId = 2;
	    answer2.content = "Không. Còn cái nịt!";
	    answer2.question = question2;
	    answer2.isCorrect = false;
	    
		Answer answer3 = new Answer();
		answer3.answerId = 3;
	    answer3.content = "2";
	    answer3.question = question3;
	    answer3.isCorrect = true;
		
		// Exam
		Exam exam1 = new Exam();
		exam1.examId = 1;
	    exam1.code = "Ex1";
	    exam1.title = "Java Fundamentals";
	    exam1.category = categoryQuestion1;
	    exam1.duration = 60;
	    exam1.creator = account1;
	    
		Exam exam2 = new Exam();
		exam2.examId = 2;
	    exam2.code = "Ex2";
	    exam2.title = ".NET Basics";
	    exam2.category = categoryQuestion2;
	    exam2.duration = 45;
	    exam2.creator = account2;
	    
		Exam exam3 = new Exam();
		exam3.examId = 3;
	    exam3.code = "Ex3";
	    exam3.title = "SQL Queries";
	    exam3.category = categoryQuestion3;
	    exam3.duration = 30;
	    exam3.creator = account3;
	    
		// ExamQuestion
		ExamQuestion examQuestion1 = new ExamQuestion();
		examQuestion1.exam = exam1;
	    examQuestion1.question = question1;
	    
	    ExamQuestion examQuestion2 = new ExamQuestion();
	    examQuestion2.exam = exam2;
	    examQuestion2.question = question2;

	    ExamQuestion examQuestion3 = new ExamQuestion();
	    examQuestion3.exam = exam3;
	    examQuestion3.question = question3;
	    
	    // In các giá trị
	    System.out.println("==========Danh sách phòng ban============");
		System.out.println("Department1: departmentId = " + department1.departmentId + ", departmentName = " + department1.departmentName);
		System.out.println("Department2: departmentId = " + department2.departmentId + ", departmentName = " + department2.departmentName);
		System.out.println("Department3: departmentId = " + department3.departmentId + ", departmentName = " + department3.departmentName);
		System.out.println();
		
		System.out.println("==============Danh sách vị trí============");
		System.out.println("Position1: positionId = " + position1.positionId + ", positionName = " + position1.positionName);
		System.out.println("Position2: positionId = " + position2.positionId + ", positionName = " + position2.positionName);
		System.out.println("Position3: positionId = " + position3.positionId + ", positionName = " + position3.positionName);
		System.out.println();
		
		System.out.println("===========Danh sách Account=============");
		System.out.println("Account1: accountId = " + account1.accountId + ", email = " + account1.email
				+ ", \n\t  userName = " + account1.userName + ", fullName = " + account1.fullName
				+ ", \n\t  department = " + account1.department.departmentName + ", position = " + account1.position.positionName
				+ ", \n\t  createDate = " + dateFormat.format(account1.createDate));
		System.out.println("Account2: accountId = " + account2.accountId + ", email = " + account2.email
				+ ", \n\t  userName = " + account2.userName + ", fullName = " + account2.fullName
				+ ", \n\t  department = " + account2.department.departmentName + ", position = " + account2.position.positionName
				+ ", \n\t  createDate = " + dateFormat.format(account2.createDate));
		System.out.println("Account3: accountId = " + account3.accountId + ", email = " + account3.email
				+ ", \n\t  userName = " + account3.userName + ", fullName = " + account3.fullName
				+ ", \n\t  department = " + account3.department.departmentName + ", position = " + account3.position.positionName
				+ ", \n\t  createDate = " + dateFormat.format(account3.createDate));
		
		System.out.println();
		System.out.println("===============Danh sách Group=============");
		System.out.println("Group1: groupId = " + group1.groupId + ", groupName = " + group1.groupName
				+ ", \n\t  creator = " + group1.creator.fullName + ", createDate = " + dateFormat.format(group1.createDate));
		System.out.println("Group2: groupId = " + group2.groupId + ", groupName = " + group2.groupName
				+ ", \n\t  creator = " + group2.creator.fullName + ", createDate = " + dateFormat.format(group2.createDate));
		System.out.println("Group3: groupId = " + group3.groupId + ", groupName = " + group3.groupName
				+ ", \n\t  creator = " + group3.creator.fullName + ", createDate = " + dateFormat.format(group3.createDate));
		System.out.println();
		
		System.out.println("==============Danh sách GroupAccount============");
		System.out.println("GroupAccount1: group = " + groupAccount1.group.groupName + ", account = " + groupAccount1.account.fullName
				+ ", \n\t  JoinDate = " + dateFormat.format(groupAccount1.joinDate));
		System.out.println("GroupAccount2: group = " + groupAccount2.group.groupName + ", account = " + groupAccount2.account.fullName
				+ ", \n\t  JoinDate = " + dateFormat.format(groupAccount2.joinDate));
		System.out.println("GroupAccount3: group = " + groupAccount3.group.groupName + ", account = " + groupAccount3.account.fullName
				+ ", \n\t  JoinDate = " + dateFormat.format(groupAccount3.joinDate));
		System.out.println();
		
		System.out.println("================Danh sách TypeQuestion===========");
		System.out.println("TypeQuestion1: typeId = " + typeQuestion1.typeId + ", typeName = " + typeQuestion1.typeName);
		System.out.println("TypeQuestion2: typeId = " + typeQuestion2.typeId + ", typeName = " + typeQuestion2.typeName);
		System.out.println();
	}
}
