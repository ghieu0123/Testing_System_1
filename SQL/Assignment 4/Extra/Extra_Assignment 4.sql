DROP DATABASE IF EXISTS training_fresher;
CREATE DATABASE IF NOT EXISTS training_fresher;
USE training_fresher;

CREATE TABLE department (
	departmentNumber 	TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    departmentName 	VARCHAR(30) CHAR SET utf8mb4 NOT NULL
);

CREATE TABLE employee (
	employeeNumber 	INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    employeeName  		VARCHAR(50) CHAR SET utf8mb4 NOT NULL, 
    departmentNumber  	TINYINT NOT NULL, 
    FOREIGN KEY (departmentNumber) REFERENCES department(departmentNumber) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE employeeskill (
	employeeNumber 	INT NOT NULL,
    skillCode  		VARCHAR(30) NOT NULL, 
    dateRegistered  	DATE, 
    PRIMARY KEY (employeeNumber, skillCode),
    FOREIGN KEY (employeeNumber) REFERENCES employee(employeeNumber) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO department(departmentName) 
VALUES 
	('Marketing'),
	('Sale'),
    ('Phát triển'),
    ('Nhân sự'),
    ('Kỹ thuật'),
    ('Tài chính'),
    ('Phó giám đốc'),
    ('Giám đốc'),
    ('Thư kí'),
    ('Bảo vệ');
    
INSERT INTO employee(employeeName, departmentNumber) 
VALUES 
	('Nguyễn Ngọc Anh', 	'1'),
	('Nguyễn Thanh Anh', 	'7'),
    ('Phạm Thanh Thảo', 	'3'),
    ('Hoàng Văn Nhã', 		'3'),
    ('Phạm Thị Nhung', 		'4'),
    ('Nguyễn Ngọc Mai', 	'5'),
    ('Nguyễn Duy Đông', 	'8'),
    ('Trần Hoài Phương', 	'2'),
    ('Nguyễn Phương Ly', 	'9'),
    ('Lê Thu Hiền', 		'2'),
    ('Lê Thu Trang', 		'3'),
    ('Hồ Thị Nguyệt', 		'2'),
    ('Võ Anh Tuấn', 		'2'),
    ('Vũ Thị Thu', 			'4');
    
INSERT INTO employeeskill(employeeNumber, skillCode, dateRegistered) 
VALUES 
	(1, 'Java', 		'2020-11-01'),
    (1, 'C#', 			'2019-03-05'),
    (2, 'JavaScrip', 	'2020-09-06'),
    (3, 'Java', 		'2019-11-09'),
    (4, 'SQL', 			'2020-05-04'),
    (5, 'C#', 			'2020-10-12'),
    (6, 'Python', 		'2020-09-15'),
    (7, 'Ruby', 		'2020-12-19'),
    (8, 'Java', 		'2020-06-25'),
    (9, 'Html', 		'2020-08-01'),
    (10, 'Css', 		'2020-10-17'),
    (11, 'Java', 		'2020-06-21'),
    (12, 'C#', 			'2020-04-05'),
    (13, 'Java', 		'2020-01-02');

-- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
	SELECT e.*, es.skillCode FROM employee e JOIN employeeskill es ON e.employeeNumber = es.employeeNumber
    WHERE es.skillCode = 'Java';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
	SELECT d.departmentName, COUNT(e.employeeNumber) AS 'number_of_employee' FROM department d LEFT JOIN employee e ON d.departmentNumber = e.departmentNumber
    GROUP BY d.departmentName HAVING number_of_employee > 3;
    
-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban.
	SELECT e.employeeName, d.departmentName FROM employee e LEFT JOIN department d ON e.departmentNumber = d.departmentNumber
    GROUP BY e.employeeNumber; 
    
-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.
	SELECT e.*, COUNT(es.employeeNumber) 'number_of_skill'
	FROM employee e 
	JOIN employeeskill es ON e.employeeNumber = es.employeeNumber
	GROUP BY e.employeeNumber
	HAVING COUNT(es.employeeNumber) > 1;