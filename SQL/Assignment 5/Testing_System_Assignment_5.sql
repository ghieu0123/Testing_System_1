use testingsystem;

-- Question 1: tạo view chứa danh sách nhân viên thuộc phòng ban sale]
	DROP VIEW IF EXISTS view_ds_nv_in_sale;
	CREATE VIEW view_ds_nv_in_sale AS
  		SELECT * FROM `Account` 
  		WHERE DepartmentID = (
     		SELECT DepartmentID FROM Department WHERE DepartmentName = 'Sale'
  	);
	SELECT * FROM view_ds_nv_in_sale;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
	DROP VIEW IF EXISTS view_ds_nv_thuoc_nhieu_group;
	CREATE VIEW view_ds_nv_thuoc_nhieu_group AS
  		SELECT a.*, COUNT(ga.GroupID) AS 'number_of_group'
  		FROM `Account` a 
  		LEFT JOIN GroupAccount ga ON a.AccountID = ga.AccountID
  		GROUP BY a.AccountID HAVING number_of_group = 
    			(SELECT MAX(number_of_group) FROM 
       			(SELECT a.*, COUNT(ga.GroupId) AS 'number_of_group'
        		FROM `Account` a LEFT JOIN GroupAccount ga ON a.AccountID = ga.AccountID
        		GROUP BY a.AccountID) bang_tam 
 		);
	SELECT * FROM view_ds_nv_thuoc_nhieu_group;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ
-- được coi là quá dài) và xóa nó đi
	DROP VIEW IF EXISTS max_length_of_question_content;
	CREATE VIEW max_length_of_question_content AS
    		SELECT Content FROM Question WHERE length(Content) > 300;

	DELETE FROM Question 
		WHERE LENGTH(Content) < 300;

	SELECT * FROM Question;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
	DROP VIEW IF EXISTS view_ds_pb;
	CREATE VIEW view_ds_pb AS
    SELECT d.DepartmentName FROM Department d
    LEFT JOIN Account a ON d.DepartmentID = a.DepartmentID
    GROUP BY d.DepartmentName HAVING COUNT(a.AccountID) = (
        SELECT MAX(number_of_account) FROM (
            SELECT d.DepartmentName, COUNT(a.AccountID) AS 'number_of_account' FROM Department d
            LEFT JOIN Account a ON d.DepartmentID = a.DepartmentID
            GROUP BY d.DepartmentName
        ) AS bang_tam
);

SELECT * FROM view_ds_pb;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
	DROP VIEW IF EXISTS view_list_question_by_user_Nguyen;
	CREATE VIEW view_list_question_by_user_Nguyen AS
		SELECT q.QuestionId, q.Content FROM question q
        WHERE q.CreatorID IN (
			SELECT a.AccountID FROM `account` a
            WHERE a.Fullname LIKE 'Nguyen%'
		);
	
    SELECT * FROM view_list_question_by_user_Nguyen;