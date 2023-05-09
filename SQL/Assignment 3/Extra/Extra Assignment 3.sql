USE Fresher;

INSERT INTO Trainee (Full_Name, Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes, VTI_Account)
VALUES
	('Nguyen Van A', '2000-01-01', 'male', 15, 18, 35, 1, 'Good trainee', 123456),
	('Tran Thi B', '1999-02-02', 'female', 18, 20, 42, 2, 'Excellent trainee', 234567),
	('Hoang Van C', '2001-03-03', 'male', 12, 15, 28, 1, NULL, 345678),
	('Nguyen Thi D', '2002-04-04', 'female', 10, 13, 25, 2, NULL, 456789),
	('Pham Van E', '2000-05-05', 'male', 13, 16, 30, 1, 'Good trainee', 567890),
	('Le Thi F', '1999-06-06', 'female', 20, 20, 50, 2, 'Excellent trainee', 678901),
	('Vu Van G', '2001-07-07', 'male', 7, 10, 20, 1, NULL, 789012),
	('Ho Thi H', '2002-08-08', 'female', 8, 11, 22, 2, NULL, 890123),
	('Truong Van I', '2000-09-09', 'male', 16, 19, 38, 1, 'Good trainee', 901234),
	('Le Thi K', '1999-10-10', 'female', 19, 20, 48, 2, 'Excellent trainee', 012345);
    

INSERT INTO Sale (Name, Code, ModifiedDate) 
VALUES
	('Product 1', 'P001', '2022-05-01 10:30:00'),
	('Product 2', 'P002', '2022-05-02 14:20:00'),
	('Product 3', 'P003', '2022-05-03 08:15:00'),
	('Product 4', 'P004', '2022-05-04 16:45:00'),
	('Product 5', 'P005', '2022-05-05 11:00:00'),
	('Product 6', 'P006', '2022-05-06 09:00:00'),
	('Product 7', 'P007', '2022-05-07 13:30:00'),
	('Product 8', 'P008', '2022-05-08 15:45:00'),
	('Product 9', 'P009', '2022-05-09 10:00:00'),
	('Product 10', 'P010', '2022-05-10 12:00:00');
    
INSERT INTO Marketing (Name, BirthDate, Gender, IsDeletedFlag)
VALUES
	('Ab', '1990-01-01', '0', 0),
	('Bb', '1992-03-15', '1', 0),
	('Cb', '1988-07-22', NULL, 0),
	('Db', '1995-09-30', '1', 1),
	('Eb', '1994-12-08', '0', 0),
	('Fb', '1996-04-20', '1', 0),
	('Gb', '1993-11-12', '0', 1),
	('Hb', '1987-05-18', '1', 0),
	('Ib', '1991-08-25', '0', 0),
	('Kb', '1997-02-14', NULL, 1);
    
-- Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào,nhóm chúng thành các tháng sinh khác nhau
SELECT MONTH(Birth_Date), COUNT(1) FROM Trainee
WHERE ET_IQ + ET_Gmath + ET_English >=50
GROUP BY MONTH(Birth_Date)
HAVING COUNT(1) >= 1;

-- Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau: 
-- tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
SELECT Full_Name, YEAR(CURDATE()) - YEAR(Birth_Date), Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes
FROM Trainee WHERE LENGTH(Full_Name) = (
		SELECT MAX(LENGTH(Full_Name)) FROM Trainee
);

-- Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là
-- những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
SELECT * FROM Trainee WHERE ET_IQ + ET_Gmath>=20
AND ET_IQ>=8
AND ET_Gmath>=8
AND ET_English>=18;

-- xóa thực tập sinh có TraineeID = 3
DELETE FROM Trainee WHERE TraineeID = 3;

-- Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database
UPDATE Trainee
SET Training_Class = 2
WHERE TraineeID = 5;



