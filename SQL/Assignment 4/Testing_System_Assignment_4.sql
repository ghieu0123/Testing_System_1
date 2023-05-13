USE TestingSystem;

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
	SELECT a.AccountID, a.Fullname, d.* FROM `Account` a LEFT JOIN department d ON a.DepartmentID = d.DepartmentID;
    
-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
	SELECT * FROM `Account` WHERE CreateDate > '2010-12-20';
    
-- Question 3: Viết lệnh để lấy ra tất cả các developer
	SELECT * FROM `Account` a INNER JOIN department d ON a.AccountID = d.departmentID
    WHERE d.DepartmentName = 'developer';
    
-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
	-- Lấy ra số nhân viên theo phòng ban
    SELECT d.*, COUNT(a.AccountID) AS 'number_of_account' FROM department d LEFT JOIN `Account` a ON d.DepartmentID = a.DepartmentID
    GROUP BY d.DepartmentID;
    -- Tìm số phòng ban có nhân viên lớn hơn 3 
    SELECT DepartmentID, DepartmentName, number_of_account FROM (
		SELECT d.*, COUNT(a.AccountID) AS 'number_of_account' FROM department d LEFT JOIN `Account` a ON d.DepartmentID = a.DepartmentID
		GROUP BY d.DepartmentID
    ) bang_tam WHERE number_of_account > 3;
    
-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
	SELECT q.*, COUNT(e.QuestionID) as 'number_of_question' FROM question q LEFT JOIN examquestion e ON q.QuestionID = e.QuestionID
    GROUP BY q.QuestionID HAVING COUNT(e.QuestionID) = (
		SELECT MAX(number_of_question) FROM (
			SELECT q.QuestionID, COUNT(e.QuestionID) AS 'number_of_question' FROM question q 
			LEFT JOIN examquestion e ON q.QuestionID = e.QuestionID
			GROUP BY q.QuestionID) bang_tam);

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
	SELECT c.*, COUNT(q.CategoryID) as 'number_of_categoryquestion' FROM categoryquestion c 
    LEFT JOIN question q ON c.CategoryID = q.CategoryID
    GROUP BY c.CategoryID;
    
-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
	SELECT q.*, COUNT(eq.QuestionID) AS 'number_of_exam' FROM question q
    LEFT JOIN examquestion eq ON q.QuestionID = eq.QuestionID
    GROUP BY q.QuestionID;
    
-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
	SELECT q.*, COUNT(a.AnswerID) AS 'number_of_max_answeer' FROM question q 
	LEFT JOIN answer a ON q.QuestionID = a.QuestionID GROUP BY q.QuestionID
    HAVING COUNT(q.QuestionID) = (SELECT MAX(number_of_question) FROM (
			SELECT q.*, COUNT(a.AnswerID) AS 'number_of_question' FROM question q 
			LEFT JOIN answer a ON q.QuestionID = a.QuestionID
			GROUP BY q.QuestionID) bang_tam);

-- Question 9: Thống kê số lượng account trong mỗi group
	SELECT g.*, COUNT(ga.AccountID) AS 'number_of_account' FROM `group` g
    LEFT JOIN groupaccount ga ON g.GroupID = ga.GroupID
    GROUP BY g.GroupID;
    
-- Question 10: Tìm chức vụ có ít người nhất
	SELECT p.*, COUNT(a.AccountID) AS 'number_of_account' FROM position p LEFT JOIN `Account` a ON p.PositionID = a.PositionID
    GROUP BY p.PositionID;

-- Question 11: Thống kê mỗi phòng ban có bao nhiêuscrum master, PM dev, test,
	-- Cách 1: tạo 1 bảng tạm từ 2 bảng position và department bằng cross join, sau đấy nhóm dpID và poID bằng group by
	SELECT bang_tam.DepartmentName, bang_tam.PositionName, COUNT(a.AccountID) 
		FROM (SELECT * FROM department d
        CROSS JOIN position p) bang_tam 
			LEFT JOIN `Account` a 
            ON bang_tam.DepartmentID = a.DepartmentID AND bang_tam.PositionID = a.PositionID
				GROUP BY bang_tam.DepartmentID, bang_tam.PositionID;
                
     -- Cách 2: nối bảng INNER JOIN Department vs Account, department vs Positon, sau đấy nhóm GROUP BY theo DepartmentName và PositonName
	SELECT a.DepartmentName, c.PositionName, COUNT(b.AccountID) AS 'so_nhan_vien'
    FROM Department a
    INNER JOIN `Account` b ON a.DepartmentID = b.DepartmentID
    INNER JOIN `Position` c ON b.PositionID = c.PositionID
    GROUP BY a.DepartmentName, c.PositionName;
    
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: 
-- thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì,..
	SELECT q.QuestionID, q.Content, cq.CategoryName, aw.Content AS 'dap_an', tq.TypeName AS 'the_loai', a.Fullname AS 'nguoi_tao_ra'
    FROM question q
		INNER JOIN categoryquestion cq ON q.CategoryID = cq.CategoryID
		INNER JOIN typequestion tq ON q.TypeID = tq.TypeID
		INNER JOIN `Account` a ON q.CreatorID = a.AccountID
		INNER JOIN Answer aw ON q.QuestionID = aw.QuestionID
			GROUP BY q.QuestionID, cq.CategoryName, tq.TypeName, a.Fullname, aw.content;
            
-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
	SELECT tq.TypeName, COUNT(q.questionID) AS 'number_of_question' FROM typequestion tq 
		INNER JOIN question q ON tq.TypeID = q.TypeID
			GROUP BY tq.TypeName HAVING tq.TypeName = 'Tự luận' OR tq.TypeName = 'Trắc nghiệm';
            
-- Question 14: Lấy ra group không có Account nào
-- Question 15: Lấy ra group không có Account nào
	SELECT g.GroupName FROM `group` g
    LEFT JOIN groupaccount ga ON g.GroupID = ga.groupID
    WHERE ga.AccountID IS NULL;
    
-- Question 16: lấy ra question không có answer nào
	SELECT q.Content FROM question q
    LEFT JOIN answer aw ON q.QuestionID = aw.QuestionID
    WHERE aw.QuestionID IS NULL;
    
-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
	SELECT a.* FROM `account` a JOIN groupaccount ga ON a.AccountID = ga.AccountID
    WHERE ga.GroupID = 1;
    
-- b) Lấy các account thuộc nhóm thứ 2
	SELECT a.* FROM `account` a JOIN groupaccount ga ON a.AccountID = ga.AccountID
    WHERE ga.GroupID = 2;
    
-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
	SELECT a.* FROM `account` a JOIN groupaccount ga ON a.AccountID = ga.AccountID
    WHERE ga.GroupID = 1
    UNION
    SELECT a.* FROM `account` a JOIN groupaccount ga ON a.AccountID = ga.AccountID
    WHERE ga.GroupID = 2;
    
-- Question 18:
	-- a) Lấy các group có lớn hơn 5 thành viên
		SELECT g.*, COUNT(ga.AccountID) AS 'number_of_account' FROM `group` g JOIN groupaccount ga ON g.GroupID = ga.GroupID
		GROUP BY g.GroupID HAVING number_of_account > 5;
    -- b) Lấy các group có nhỏ hơn 7 thành viên
		SELECT g.*, COUNT(ga.AccountID) AS 'number_of_account' FROM `group` g JOIN groupaccount ga ON g.GroupID = ga.GroupID
		GROUP BY g.GroupID HAVING number_of_account < 7;
    -- c) ghép 2 bảng lại với nhau
		SELECT g.*, COUNT(ga.AccountID) AS 'number_of_account' FROM `group` g JOIN groupaccount ga ON g.GroupID = ga.GroupID
		GROUP BY g.GroupID HAVING number_of_account > 5
        UNION
        SELECT g.*, COUNT(ga.AccountID) AS 'number_of_account' FROM `group` g JOIN groupaccount ga ON g.GroupID = ga.GroupID
		GROUP BY g.GroupID HAVING number_of_account < 7;