use TestingSystem;


INSERT INTO Department (DepartmentName)
VALUES
                        ('Design'		),
                        ('Thủ Quỹ'		),
                        ('Thực Tập Sinh'),
                        ('Suport'		),
                        ('Thủ Kho'		),
                        ('Quảng Cáo'	),
                        ('Phó giám đốc'	),
                        ('Bán Hàng'		),
                        ('Chuyên Viên'	),
                        ('Phòng chờ');
                        
-- Add data Position
INSERT INTO Position (PositionName)
VALUES
                        ('Nhân viên thiết kế'		),
						('Quản lý tiền'				),
						('Nhân viên chưa chính thức'),
						('Hỗ trợ'					),
						('Quản lý kho'				),
                        ('Quảng cáo'				),
						('Phó giám đốc'				),
						('Bán Hàng'					),
						('Chuyên gia'				),
						('Trên giám đốc'			);
                        
-- Add data Account              
INSERT INTO Account (Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
VALUES
						('ha123@gmail.com', 'ha', 'Tran Ha', 7, 1, '2022-01-01'),
						('la123@gmail.com', 'la', 'Tran La', 2, 9, '2022-01-01'),
						('lin123@gmail.com', 'lin', 'Nguyen Lin', 6, 1, '2022-01-01'),
						('min123@gmail.com', 'min', 'Quach Min', 8, 3, '2022-01-01'),
						('na123@gmail.com', 'na', 'Trieu Na', 4, 4, '2022-01-01'),
                        ('ho123@gmail.com', 'ho', 'Nguyen Ho', 1, 1, '2022-01-01'),
						('lu123@gmail.com', 'lu', 'Tran Lu', 2, 2, '2022-01-01'),
						('ling123@gmail.com', 'ling', 'Do Ling', 8, 1, '2022-01-01'),
						('man123@gmail.com', 'man', 'Quach Man', 3, 3, '2022-01-01'),
						('kien123@gmail.com', 'kien', 'Nguyen kien', 7, 4, '2022-01-01');
                        
-- Add data Group
INSERT INTO `Group` (GroupName, CreatorID, CreateDate)
VALUES
                        ('Design team', 2, '2022-01-01'			),
                        ('Thủ Quỹ team', 5, '2019-01-01'		),
                        ('Thực Tập Sinh team', 2, '2020-01-01'	),
                        ('Suport team', 1, '2021-01-01'			),
                        ('Thủ Kho team', 2, '2022-05-01'		),
                        ('Quảng Cáo team', 4, '2023-02-01'		),
                        ('Phó giám đốc team', 2, '2022-01-01'	),
                        ('Bán Hàng team', 3, '2022-01-01'		),
                        ('Chuyên Viên team', 2, '2022-01-01'	),
                        ('Chủ Tịch team', 3, '2022-01-01'		);
                        
-- Add data Group Account
INSERT INTO GroupAccount (GroupID, AccountID, JoinDate)
VALUES
						(6, 	6, '2022-01-01'),
						(7, 	7, '2022-01-01'),
						(8, 	8, '2022-01-01'),
						(9, 	9, '2022-01-01'),
						(10, 	12, '2022-01-01'),
                        (10, 	11, '2022-01-01'),
						(12, 	12, '2022-01-01'),
						(13, 	13, '2022-01-01'),
						(14, 	14, '2022-01-01'),
						(15, 	15, '2022-01-01');
                        
-- Add data TypeQuestion
INSERT INTO TypeQuestion (TypeName)
VALUES
						('Trắc nghiệm'),
						('Tự luận'),
                        ('Trắc nghiệm'),
						('Tự luận'),
						('Tổng hợp'),
                        ('Trắc nghiệm'),
						('Tự luận'),
                        ('Trắc nghiệm'),
						('Tự luận'),
						('Tổng hợp');

-- Add data CategoryQuestion
INSERT INTO CategoryQuestion (CategoryName)
VALUES
						('ToánTN'),
						('LýTN'),
						('HóaTN'),
						('VănTN'),
						('AnhTN'),
                        ('ToánLT'),
						('LýLT'),
						('HóaLT'),
						('VănLT'),
						('AnhLT');

-- Add data Question
INSERT INTO Question (Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUES
						('Mèo kêu như nào?', 1, 1, 1, '2022-01-01'),
						('1+5=?', 2, 2, 2, '2022-01-02'),
						('Có bao nhiêu tỉnh ở Việt Nam?', 7, 3, 3, '2022-01-03'),
						('Có bao nhiêu phép toán?',12, 2, 4, '2022-01-04'),
						('33+3=?', 5, 1, 5, '2022-01-05'),
                        ('Mèo kêu như nào?', 8, 1, 1, '2022-01-01'),
						('1+5=?', 2, 2, 2, '2022-01-02'),
						('Có bao nhiêu tỉnh ở Việt Nam?', 6, 3, 3, '2022-01-03'),
						('Có bao nhiêu phép toán?',3, 3, 4, '2022-01-04'),
						('33+3=?', 5, 1, 5, '2022-01-05');

-- Add data Answer
INSERT INTO Answer (Content, QuestionID, isCorrect)
VALUES
						('gauw', 1, 1),
						('5', 2, 0),
						('63 Tỉnh', 3, 1),
						('4', 4, 1),
						('34', 5, 0),
                        ('meow', 1, 1),
						('50', 2, 0),
						('3 Tỉnh', 3, 1),
						('4', 4, 1),
						('11', 5, 0);

-- Add data Exam
INSERT INTO Exam (`Code`, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES
						('EXAM06', 'TỰ nhiên', 1, '01:00:00', 1, '2022-01-10'),
						('EXAM07', 'Toán', 2, '00:30:00', 2, '2022-01-11'),
						('EXAM08', 'Xã hội', 2, '01:30:00', 2, '2022-01-12'),
						('EXAM09', 'Toán', 4, '01:30:00', 4, '2022-01-12'),
						('EXAM10', 'Toán', 3, '01:00:00', 2, '2022-01-13'),
                        ('EXAM11', 'TỰ nhiên', 1, '01:00:00', 1, '2022-01-10'),
						('EXAM12', 'Toán', 2, '00:30:00', 2, '2022-01-11'),
						('EXAM13', 'Xã hội', 2, '01:30:00', 2, '2022-01-12'),
						('EXAM14', 'Toán', 4, '01:30:00', 4, '2022-01-12'),
						('EXAM15', 'Toán', 3, '01:00:00', 2, '2022-01-13');

-- Add data ExamQuestion
INSERT INTO ExamQuestion (ExamID, QuestionID)
VALUES
						(5, 5),
						(5, 6),
						(5, 7),
						(5, 8),
						(6, 6),
                        (7, 7),
						(8, 8),
						(6, 7),
						(6, 8),
						(7, 8);
                        
-- Lấy ra tất cả các phòng ban
SELECT DepartmentName FROM Department;

-- Lấy ra id của phòng ban Sale
SELECT DepartmentID FROM Department WHERE DepartmentName = 'Sale';

-- Lấy ra thông tin account có full name dài nhất
SELECT * FROM `Account` WHERE LENGTH(Fullname) = (SELECT MAX(Length(Fullname)) FROM `Account`);

-- Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT * FROM `Account` WHERE DepartmentID = 3
AND LENGTH(Fullname) = (SELECT MAX(Length(Fullname)) FROM `Account` WHERE DepartmentID = 3);

-- Lấy ra tên Group đã tham gia trước ngày 20/12/2019
SELECT GroupName, CreateDate  FROM `Group` WHERE CreateDate < '2019-12-20';

-- Lấy ra id của question có từ trên 4 câu trả lời
SELECT QuestionID, COUNT(1) FROM Answer GROUP BY QuestionID HAVING COUNT(1) >= 4;

-- Lấy ra các mã đề thi có thời gian thi >= 60p và được tạo trước ngày 20/12/2019
SELECT ExamID FROM Exam WHERE Duration >= 60 AND CreateDate < '2019-12-20';

-- Lấy ra 5 group được tạo gần đây nhất
SELECT * FROM `Group`
ORDER BY CreateDate DESC LIMIT 5;

-- Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(1) FROM Department WHERE DepartmentID = 2;

-- Lấy ra tên nhân viên có tên bắt đầu bằng D và kết thúc bằng o
SELECT Username FROM `Account` WHERE Username LIKE 'h%o';

-- xóa tất cả các exam trước ngày 20/12/2019
DELETE FROM Exam WHERE CreateDate < '2019-12-20';

-- Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE FROM Question WHERE Content LIKE 'câu hỏi%';

-- Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE `Account`
SET Fullname = 'Nguyễn Bá Lộc', Email = 'loc.nguyenba@vti.com.vn'
WHERE AccountID = 5;

-- update account có id = 5 sẽ thuộc group có id = 4
UPDATE `GroupAccount`
SET GroupID = 4
WHERE AccountID = 5;