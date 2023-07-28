USE testingsystem;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó
	DROP PROCEDURE IF EXISTS sp_ds_in_der;
	DELIMITER $$;
    CREATE PROCEDURE sp_ds_in_der (IN p_in_depar_name VARCHAR(255)) 
		BEGIN
			SELECT AccountID 
            FROM `account`
            WHERE DepartmentID = (
				SELECT DepartmentID
                FROM department
                WHERE Departmentname = p_in_depar_name
			);
		END$$;
	DELIMITER ;
    
    CALL sp_ds_in_der('Sale');
    
    -- Question 2: Tạo store để in ra số lượng account trong mỗi group
    DROP PROCEDURE IF EXISTS sp_ds_acc_in_grp;
    DELIMITER $$;
    CREATE PROCEDURE sp_ds_acc_in_grp()
		BEGIN
			SELECT COUNT(AccountID) AS 'số lượng account', GroupID
            FROM groupaccount
            GROUP BY GroupID;
		END $$
	DELIMITER ;
    
    CALL sp_ds_acc_in_grp();
    
-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại
    DROP PROCEDURE IF EXISTS sp_tk_type_question;
	DELIMITER $$
	CREATE PROCEDURE sp_tk_type_question()
	BEGIN 
		SELECT tq.TypeName, COUNT(q.QuestionID) AS TotalQuestion
		FROM typequestion tq
		LEFT JOIN question q ON tq.TypeID = q.TypeID
		GROUP BY tq.TypeName;
	END $$
	DELIMITER ;

    CALL sp_tk_type_question();
    
-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
	-- Cách 1
	DROP PROCEDURE IF EXISTS sp_id_of_max_qs;
    DELIMITER $$
    CREATE PROCEDURE sp_id_of_max_qs(OUT p_out_id TINYINT)
		BEGIN
			SELECT bang_tam.ID INTO p_out_id FROM (
				SELECT tq.TypeID AS 'ID', COUNT(q.QuestionID) AS 'number_of_question' FROM typequestion tq
				LEFT JOIN question q ON tq.TypeID = q.TypeID
				GROUP BY tq.TypeID
				ORDER BY number_of_question DESC LIMIT 1
			) bang_tam;
		END $$
	DELIMITER ;
    
    SET @v_id = '';
    CALL sp_id_of_max_qs(@v_id);
    SELECT @v_id;
    
	-- Cách 2
	DROP PROCEDURE IF EXISTS sp_id_of_max_qs;
    DELIMITER $$
    CREATE PROCEDURE sp_id_of_max_qs(OUT p_out_id TINYINT)
		BEGIN
			WITH CTE_thong_ke AS
            (SELECT tq.TypeID, COUNT(q.QuestionID) AS 'number_of_question'
				FROM typequestion tq
				LEFT JOIN question q ON tq.TypeID = q.TypeID
				GROUP BY tq.TypeID
			)
            SELECT CTE_thong_ke.TypeID INTO p_out_id
				FROM CTE_thong_ke WHERE number_of_question = (
					SELECT MAX(number_of_question) FROM CTE_thong_ke
            );
		END $$
	DELIMITER ;
    
    SET @v_id = '';
	CALL sp_id_of_max_qs(@v_id);
    SELECT @v_id;
        
        
    -- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
    DROP PROCEDURE IF EXISTS sp_name_of_typeques;
    DELIMITER $$
    CREATE PROCEDURE sp_name_of_typeques()
		BEGIN
			SELECT TypeName
            FROM typequestion
            WHERE TypeID = @id;
		END $$
	DELIMITER ;
    
    CALL sp_name_of_typeques();
    
-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập
	DROP PROCEDURE IF EXISTS sp_name_gr_or_acc;
	DELIMITER $$
	CREATE PROCEDURE sp_name_gr_or_acc(IN p_in_name VARCHAR(50))
	BEGIN
		SELECT AccountID AS `ID`, UserName AS `Name` FROM account
		WHERE UserName = p_in_name
		UNION
		SELECT GroupID AS `ID`, GroupName AS `Name` FROM `group`
		WHERE GroupName = p_in_name;
	END $$
	DELIMITER ;
    
    CALL sp_name_gr_or_acc('Sales Team');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
--  username sẽ giống email nhưng bỏ phần @..mail đi
-- 	positionID: sẽ có default là developer
-- 	departmentID: sẽ được cho vào 1 phòng chờ
-- 	Sau đó in ra kết quả tạo thành công
	DROP PROCEDURE IF EXISTS sp_gan;
    DELIMITER $$
    CREATE PROCEDURE sp_gan(IN p_in_fullname VARCHAR(50), IN p_in_email VARCHAR(50))
		BEGIN
            INSERT INTO `account`(Email, Username, Fullname, DepartmentID, PositionID)
            VALUES (p_in_email, SUBSTRING_INDEX(p_in_email, '@', 1), p_in_fullname, 15, 4);
		END $$
	DELIMITER ;
    
    CALL sp_gan('nguyen van A', 'ahaha@gmail.com');
    
-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
	DROP PROCEDURE IF EXISTS sp_thong_ke;
	DELIMITER $$
	CREATE PROCEDURE sp_thong_ke(IN p_type_ques VARCHAR(50))
		BEGIN
			WITH CTE_thong_ke_typeques_theo_do_dai_content_ques AS (
				SELECT q.QuestionID, q.Content, LENGTH(q.Content) AS do_dai_content
				FROM typequestion tq
				LEFT JOIN question q ON tq.TypeID = q.TypeID
				WHERE tq.TypeName = p_type_ques
				GROUP BY q.QuestionID
			),
			CTE_max_content_of_type_ques AS (
				SELECT MAX(do_dai_content) AS max_length_of_content
				FROM CTE_thong_ke_typeques_theo_do_dai_content_ques
			)
			SELECT * FROM CTE_thong_ke_typeques_theo_do_dai_content_ques
			WHERE do_dai_content = (
				SELECT * FROM CTE_max_content_of_type_ques
			);
		END $$
	DELIMITER ;

    CALL sp_thong_ke('Trắc nghiệm');
                
-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
	DROP PROCEDURE IF EXISTS sp_xoa_exam_theo_id;
    DELIMITER $$
    CREATE PROCEDURE sp_xoa_exam_theo_id(IN p_id TINYINT)
		BEGIN
			DELETE FROM exam
            WHERE ExamId = p_id;
		END $$
	DELIMITER ;
    
    CALL sp_xoa_exam_theo_id(5);
            
-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
	
    
    
-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc
	DROP PROCEDURE IF EXISTS sp_xoa

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
