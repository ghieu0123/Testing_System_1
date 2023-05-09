DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE IF NOT EXISTS TestingSystem;
USE TestingSystem;

CREATE TABLE Department (
	DepartmentID	TINYINT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName	VARCHAR(255) NOT NULL
);

CREATE TABLE Position (
	PositionID 		TINYINT AUTO_INCREMENT PRIMARY KEY,
	PositionName 	VARCHAR(255) NOT NULL
);


CREATE TABLE `Account` (
	AccountID		TINYINT AUTO_INCREMENT PRIMARY KEY,
    Email			VARCHAR(50) NOT NULL,
    Username		VARCHAR(50)NOT NULL,
    Fullname		VARCHAR(50) NOT NULL,
    DepartmentID	TINYINT,
    PositionID		TINYINT,
    CreateDate		DATE,
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID),
    FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID)
);

CREATE TABLE `Group` (
	GroupID			TINYINT AUTO_INCREMENT PRIMARY KEY,
    GroupName		VARCHAR(50) NOT NULL,
    CreatorID		TINYINT,
    CreateDate		DATE NOT NULL,
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

CREATE TABLE GroupAccount (
	GroupID			TINYINT,
    AccountID		TINYINT,
    JoinDate		DATE NOT NULL,
    PRIMARY KEY (GroupID, AccountID),
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
    FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID)
);

CREATE TABLE TypeQuestion (
	TypeID			TINYINT AUTO_INCREMENT PRIMARY KEY,
    TypeName		VARCHAR(50) NOT NULL
);

CREATE TABLE CategoryQuestion (
	CategoryID		TINYINT AUTO_INCREMENT PRIMARY KEY,
    CategoryName	VARCHAR(50) NOT NULL
);

CREATE TABLE Question (
	QuestionID		TINYINT AUTO_INCREMENT PRIMARY KEY,
    Content			VARCHAR(50) NOT NULL,
    CategoryID		TINYINT,
    TypeID			TINYINT,
    CreatorID		TINYINT,
    CreateDate		DATE,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion (TypeID),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

CREATE TABLE Answer (
	AnswerID		INT AUTO_INCREMENT PRIMARY KEY,
    Content			VARCHAR(50),
    QuestionID		TINYINT,
    isCorrect		BOOLEAN,
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

CREATE TABLE Exam (
	ExamID			TINYINT AUTO_INCREMENT PRIMARY KEY,
	Code			VARCHAR(50) NOT NULL,
	Title 			VARCHAR(255) NOT NULL,
	CategoryID 		TINYINT,
	Duration 		TIME,
	CreatorID		TINYINT,
	CreateDate		DATE,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

CREATE TABLE ExamQuestion (
	ExamID			TINYINT,
    QuestionID		TINYINT,
    PRIMARY KEY (ExamID, QuestionID),
    FOREIGN KEY (ExamID) REFERENCES Exam (ExamID),
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

-- Add Data Department
INSERT INTO Department (DepartmentID, DepartmentName)
VALUES
						(1,		'Sale'			),
                        (2, 	'Marketing'		),
                        (3, 	'Giám đốc'		),
                        (4,		'Kỹ thuật'		),
                        (5,		'Bảo vệ'		);
                        
-- Add data Position
INSERT INTO Position (PositionID, PositionName)
VALUES
						(1, 	'Nhân viên bán hàng'	),
						(2, 	'Chuyên viên marketing'	),
						(3, 	'Giám đốc'				),
						(4, 	'Kỹ sư phần mềm'		),
						(5, 	'Bảo vệ'				);
                        
-- Add data Account              
INSERT INTO Account (Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
VALUES
						('hao123@gmail.com', 'hao', 'Nguyen Hao', 1, 1, '2022-01-01'),
						('lan123@gmail.com', 'lan', 'Tran Lan', 2, 2, '2022-01-01'),
						('linh123@gmail.com', 'linh', 'Nguyen Linh', 1, 1, '2022-01-01'),
						('minh123@gmail.com', 'minh', 'Quach Minh', 3, 3, '2022-01-01'),
						('nam123@gmail.com', 'nam', 'Nguyen Nam', 4, 4, '2022-01-01');
                        
-- Add data Group
INSERT INTO `Group` (GroupName, CreatorID, CreateDate)
VALUES
						('Marketing Team', 2, '2022-01-01'),
						('Sales Team', 1, '2022-01-01'),
						('Technical Team', 4, '2022-01-01'),
						('Security Team', 5, '2022-01-01'),
						('Admins', 3, '2022-01-01');
                        
-- Add data Group Account
INSERT INTO GroupAccount (GroupID, AccountID, JoinDate)
VALUES
						(1, 	1, '2022-01-01'),
						(2, 	2, '2022-01-01'),
						(3, 	3, '2022-01-01'),
						(4, 	4, '2022-01-01'),
						(5, 	5, '2022-01-01');
                        
-- Add data TypeQuestion
INSERT INTO TypeQuestion (TypeID, TypeName)
VALUES
						(1, 	'Trắc nghiệm'),
						(2, 	'Tự luận'),
                        (3, 	'Trắc nghiệm'),
						(4, 	'Tự luận'),
						(5, 	'Tổng hợp');
                        

-- Add data CategoryQuestion
INSERT INTO CategoryQuestion (CategoryID, CategoryName)
VALUES
						(1, 	'Toán'),
						(2, 	'Lý'),
						(3, 	'Hóa'),
						(4, 	'Văn'),
						(5, 	'Anh');

-- Add data Question
INSERT INTO Question (Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUES
						('Mèo kêu như nào?', 1, 1, 1, '2022-01-01'),
						('1+5=?', 2, 2, 2, '2022-01-02'),
						('Có bao nhiêu tỉnh ở Việt Nam?', 3, 3, 3, '2022-01-03'),
						('Có bao nhiêu phép toán?',4, 4, 4, '2022-01-04'),
						('33+3=?', 5, 5, 5, '2022-01-05');

-- Add data Answer
INSERT INTO Answer (AnswerID, Content, QuestionID, isCorrect)
VALUES
						(1, 'meow', 1, 1),
						(2, '5', 2, 0),
						(3, '63 Tỉnh', 3, 1),
						(4, '4', 4, 1),
						(5, '34', 5, 0);

-- Add data Exam
INSERT INTO Exam (`Code`, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES
						('EXAM01', 'TỰ nhiên', 1, '01:00:00', 1, '2022-01-10'),
						('EXAM02', 'Toán', 2, '00:30:00', 2, '2022-01-11'),
						('EXAM03', 'Xã hội', 2, '01:30:00', 2, '2022-01-12'),
						('EXAM03', 'Toán', 4, '01:30:00', 4, '2022-01-12'),
						('EXAM04', 'Toán', 3, '01:00:00', 2, '2022-01-13');

-- Add data ExamQuestion
INSERT INTO ExamQuestion (ExamID, QuestionID)
VALUES
						(1, 1),
						(1, 2),
						(2, 1),
						(2, 2),
						(3, 3);