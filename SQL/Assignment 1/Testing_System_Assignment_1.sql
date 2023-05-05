DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

CREATE TABLE Department (
	DepartmentID	INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName	VARCHAR(255) NOT NULL
);

CREATE TABLE Position (
	PositionID 		INT AUTO_INCREMENT PRIMARY KEY,
	PositionName 	VARCHAR(255) NOT NULL
);


CREATE TABLE `Account` (
	AccountID		INT AUTO_INCREMENT PRIMARY KEY,
    Email			VARCHAR(50) NOT NULL,
    Username		VARCHAR(50)NOT NULL,
    Fullname		VARCHAR(50) NOT NULL,
    DepartmentID	INT,
    PositionID		INT,
    CreateDate		DATE
);

CREATE TABLE `Group` (
	GroupID			INT AUTO_INCREMENT PRIMARY KEY,
    GroupName		VARCHAR(50) NOT NULL,
    CreatorID		INT NOT NULL,
    CreateDate		DATE NOT NULL
);

CREATE TABLE GroupAccount (
	GroupID			INT NOT NULL,
    AccountID		INT NOT NULL,
    JoinDate		DATE NOT NULL
);

CREATE TABLE TypeQuestion (
	TypeID			INT AUTO_INCREMENT PRIMARY KEY,
    TypeName		VARCHAR(50) NOT NULL
);

CREATE TABLE CategoryQuestion (
	CategoryID		INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName	VARCHAR(50) NOT NULL
);

CREATE TABLE Question (
	QuestionID		INT AUTO_INCREMENT PRIMARY KEY,
    Content			VARCHAR(50) NOT NULL,
    CategoryID		INT,
    TypeID			INT,
    CreatorID		INT,
    CreateDate		DATE
);

CREATE TABLE Answer (
	AnswerID		INT,
    Content			VARCHAR(50),
    QuestionID		INT,
    isCorrect		BOOLEAN
);

CREATE TABLE Exam (
	ExamID			INT AUTO_INCREMENT PRIMARY KEY,
	Code			VARCHAR(50) NOT NULL,
	Title 			VARCHAR(255) NOT NULL,
	CategoryID 		INT,
	Duration 		TIME,
	CreatorID		INT,
	CreateDate		DATE
);

CREATE TABLE ExamQuestion (
	ExamID			INT,
    QuestionID		INT
);