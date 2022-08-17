USE TestingSystem;

#Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các  account thuộc phòng ban đó

DROP PROCEDURE IF EXISTS GET_DEPARTMENT_ACCOUNT;
DELIMITER $$
CREATE PROCEDURE GET_DEPARTMENT_ACCOUNT (
				IN IN_DEPARTMENT_NAME VARCHAR(50) 
				)

BEGIN
				SELECT A.AccountID, B.DepartmentName, A.Fullname 
                FROM `account` A
                INNER JOIN department B
                ON A.departmentID=B.departmentID
                WHERE  B.DepartmentName=IN_DEPARTMENT_NAME;

END$$

CALL testingsystem.GET_DEPARTMENT_ACCOUNT('sale');
DELIMITER;

-- QUESTION 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các  account thuộc phòng ban đó
-- CREATE FUNCTION

DROP FUNCTION IF EXISTS FUNCTION_DEPARTMENT_ACCOUNT;
DELIMITER $$
CREATE FUNCTION FUNCTION_DEPARTMENT_ACCOUNT 
				(IN_DEPARTMENT_NAME VARCHAR(50) /*this is the input*/) RETURNS INT DETERMINISTIC READS SQL DATA-- this is the output
BEGIN
				DECLARE v_account_id INT; -- set a variable
                
                SELECT A.AccountID #INTO v_account_id       #B.DepartmentName, A.Fullname, 
                FROM `account` A
                INNER JOIN department B
                ON A.departmentID=B.departmentID
                WHERE  B.DepartmentName=IN_DEPARTMENT_NAME;
                
                RETURN v_account_id; -- return the variable to the RETURN value of the function
END$$
DELIMITER;

SELECT testingsystem.FUNCTION_DEPARTMENT_ACCOUNT('sale');

#Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS GET_ACCOUNT_PER_GROUP;
DELIMITER $$
CREATE PROCEDURE GET_ACCOUNT_PER_GROUP (
				IN IN_GROUP_ID INT 
				)

BEGIN
				SELECT B.GroupID, count(A.GroupID) AS NUMBER_OF_ACCOUNT 
                FROM group_account A
                RIGHT JOIN `group` B
                ON A.GroupID=B.GroupID
                WHERE  B.GroupID=IN_GROUP_ID
                GROUP BY B.GroupID;

END$$
-- USE

#Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo  trong tháng hiện tại
DROP PROCEDURE IF EXISTS GET_QUESTIONS_CREATED_THIS_MONTH;
DELIMITER $$
CREATE PROCEDURE GET_QUESTIONS_CREATED_THIS_MONTH (
				IN IN_QUESTION_TYPE_ID INT 
				)

BEGIN
				SELECT B.TypeName, COUNT(1) AS QUESTIONS_CREATED_THIS_MONTH
				FROM QUESTION A
				INNER JOIN TYPE_QUESTION B
				ON A.TYPEID=B.TYPEID
                
                WHERE A.TYPEID=IN_QUESTION_TYPE_ID
				AND MONTH(A.CREATEDATE)=MONTH(NOW())
				GROUP BY B.TYPEID;

END$$



#INSERT INTO Question (Content , CategoryID, TypeID , CreatorID, CreateDate )
#VALUES 
#			(N'Câu hỏi về Java' , 1 , '1' , '2' ,NOW()),
#			(N'Câu Hỏi về PHP' , 10 , '2' , '2' ,'2022-08-05');

#Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS TYPE_MAX_QUESTION;
DELIMITER $$
CREATE PROCEDURE TYPE_MAX_QUESTION (
				OUT OUT_TYPE_ID INT)

			BEGIN
				SELECT A.TypeID INTO OUT_TYPE_ID        		
                FROM QUESTION A
                INNER JOIN TYPE_QUESTION B
                ON A.TypeID=B.TypeID
                GROUP BY A.TypeID
                HAVING COUNT(A.questionID)=(
					SELECT MAX(x)
                    FROM (SELECT COUNT(q1.questionID) x
                    FROM Question q1
                    GROUP BY q1.typeID) y);
			END$$
DELIMITER   ;         
            
CALL TYPE_MAX_QUESTION(@typeID);
SELECT @typeID;
                            
				/*SELECT A.TypeID, COUNT(1) AS TYPE_MAX_QUESTION
				FROM QUESTION A 
				INNER JOIN TYPE_QUESTION B
				ON A.TypeID=B.TypeID
				
                GROUP BY A.TYPEID
				ORDER BY COUNT(1) DESC
				LIMIT 1;*/


#Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
SELECT TypeName
FROM type_question
WHERE typeID=@typeID;

#Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi 
#trả về group có tên chứa chuỗi của người dùng nhập vào 
#hoặc trả về user có username chứa chuỗi của người dùng nhập vào

DROP PROCEDURE IF EXISTS USER_INPUT_STRING;
DELIMITER $$
CREATE PROCEDURE USER_INPUT_STRING (
				IN IN_USER_ID INT,
                IN USER_STRING CHAR(50))

			BEGIN
				        
				SELECT A.username, USER_STRING
				FROM `account` A
                WHERE A.accountID=IN_USER_ID;
			END$$
DELIMITER   ;         

#Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và  trong store sẽ tự động gán:
#username sẽ giống email nhưng bỏ phần @..mail đi 
#positionID: sẽ có default là developer
#departmentID: sẽ được cho vào 1 phòng chờ Sau đó in ra kết quả tạo thành công

DROP PROCEDURE IF EXISTS USER_INPUT_INFO;
#INSERT INTO Department(DepartmentName) VALUES ('Phong cho');
DELIMITER $$
CREATE PROCEDURE USER_INPUT_INFO (
				IN IN_FULLNAME NVARCHAR(100),
				IN IN_EMAIL VARCHAR(100))

			BEGIN
            INSERT INTO `Account`(FullName, Email, Username, DepartmentID , PositionID, CreateDate)
				VALUES 		
					(IN_FULLNAME , IN_EMAIL, 'nothing',12 , 1,NOW());
                    
				UPDATE account 
                SET Username = SUBSTRING_INDEX(Email, '@',1); # this is to remove everything after @gmail.com
                    
				SELECT *, 'New account created'
				FROM `account`
                WHERE account.FullName=IN_FULLNAME;
			END$$
DELIMITER   ;       

#Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

DROP PROCEDURE IF EXISTS QUESTION_TYPE_LONGEST_CONTENT;
DELIMITER $$
CREATE PROCEDURE QUESTION_TYPE_LONGEST_CONTENT (
				IN_TYPE_QUESTION ENUM('Essay','Multiple-Choice'))
BEGIN
				SELECT A.TypeName, B.QuestionID, LENGTH(B.content) as CONTENT_LENGTH
				FROM type_question A
				INNER JOIN question B
				ON A.TypeID=B.TypeID
				WHERE A.TypeName=IN_TYPE_QUESTION
				GROUP BY LENGTH(B.content)
				LIMIT 1;
END$$
DELIMITER   ;  

#Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS REMOVE_EXAM_ID;
DELIMITER $$
CREATE PROCEDURE REMOVE_EXAM_ID (
				IN_EXAM_ID INT)
BEGIN
				DELETE FROM exam
				WHERE examID=IN_EXAM_ID;
                SELECT * FROM Exam;
END$$
DELIMITER   ;  

#Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử  dụng store ở câu 9 để xóa)
 -- Sau đó in số lượng record đã remove từ các table liên quan trong khi remove
DROP PROCEDURE IF EXISTS REMOVE_EXAM_3YR_OLD;
DELIMITER $$
CREATE PROCEDURE REMOVE_EXAM_3YR_OLD ()
BEGIN
				DECLARE v_Exams_Deleted INT;
				
				SET v_Exams_Deleted = (SELECT count(ExamID) as Number_Of_Exam_Deleted
										FROM exam
										WHERE createDate < (now() - interval 3 year));                                                
				DELETE FROM exam WHERE createDate < (now() - interval 3 year);
                SELECT v_Exams_Deleted AS Exams_Deleted;
END$$
DELIMITER   ;  
 call testingsystem.REMOVE_EXAM_3YR_OLD();

 
/*#Question 11: Viết store cho phép người dùng Delete Department (xóa phòng ban) bằng cách người dùng  nhập vào tên phòng ban 
 và các account thuộc phòng ban đó sẽ được  chuyển về phòng ban default là phòng ban chờ việc*/

DROP PROCEDURE IF EXISTS Delete_Set_Default_Department;
DELIMITER $$
CREATE PROCEDURE Delete_Set_Default_Department (IN In_Department_Name CHAR(50))
BEGIN
				DECLARE v_DepartmentID INT;
 
				SET v_DepartmentID = 	(SELECT DepartmentID
										FROM Department
										WHERE departmentName=In_Department_Name);
				UPDATE  `account`
                SET DepartmentID=12
                WHERE DepartmentID=v_DepartmentID;
                                        
END$$
DELIMITER   ;   
 
CALL Delete_Set_Default_Department('sale');

#Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
	#this year, each month: count created question

DROP PROCEDURE IF EXISTS Question_Created_per_Month;
DELIMITER $$
CREATE PROCEDURE Question_Created_per_Month (IN In_month INT)
BEGIN
				
			SELECT QuestionID, 	EXTRACT(YEAR FROM createDate) AS YEAR,
								EXTRACT(MONTH FROM createDate) AS MONTH,
                                COUNT(createDate) AS Number_of_Question_Created
			FROM question
			WHERE YEAR(createDate)=YEAR(CURDATE()) AND 
			MONTH(createDate)=In_month
			GROUP BY YEAR(createDate);
                                        
END$$
DELIMITER   ;   
 
CALL Question_Created_per_Month(8);


#Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6  tháng gần đây nhất
#Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng"
DROP PROCEDURE IF EXISTS Questions_Created_Last_Six_Months;
DELIMITER $$
CREATE PROCEDURE Questions_Created_Last_Six_Months ()
BEGIN	

		SELECT MONTHNAME(createdate) AS Past_Six_Months, 
						COUNT(1) AS Number_of_Question_Created
		FROM question
		WHERE MONTH(createDate) = MONTH(date_sub(NOW(), INTERVAL 6 MONTH))
		AND YEAR(createDate)=YEAR(CURDATE())

		UNION
		SELECT MONTHNAME(createdate) AS Past_Six_Months, COUNT(1) AS Number_of_Question_Created
		FROM question
		WHERE MONTH(createDate) = MONTH(date_sub(NOW(), INTERVAL 5 MONTH))
		AND YEAR(createDate)=YEAR(CURDATE())

		UNION
		SELECT MONTHNAME(createdate) AS Past_Six_Months, COUNT(1) AS Number_of_Question_Created
		FROM question
		WHERE MONTH(createDate) = MONTH(date_sub(NOW(), INTERVAL 4 MONTH))
		AND YEAR(createDate)=YEAR(CURDATE())

		UNION
		SELECT MONTHNAME(createdate) AS Past_Six_Months, COUNT(1) AS Number_of_Question_Created
		FROM question
		WHERE MONTH(createDate) = MONTH(date_sub(NOW(), INTERVAL 3 MONTH))
		AND YEAR(createDate)=YEAR(CURDATE())

		UNION
		SELECT MONTHNAME(createdate) AS Past_Six_Months, COUNT(1) AS Number_of_Question_Created
		FROM question
		WHERE MONTH(createDate) = MONTH(date_sub(NOW(), INTERVAL 2 MONTH))
		AND YEAR(createDate)=YEAR(CURDATE())

		UNION
		SELECT MONTHNAME(createdate) AS Past_Six_Months, COUNT(1) AS Number_of_Question_Created
		FROM question
		WHERE MONTH(createDate) = MONTH(date_sub(NOW(), INTERVAL 1 MONTH))
		AND YEAR(createDate)=YEAR(CURDATE())

		UNION
		SELECT MONTHNAME(createdate) AS Past_Six_Months, COUNT(1) AS Number_of_Question_Created
		FROM question
		WHERE MONTH(createDate) = MONTH(date_sub(NOW(), INTERVAL 0 MONTH))
		AND YEAR(createDate)=YEAR(CURDATE())

		GROUP BY MONTH(createDate);
                                        
END$$
DELIMITER   ;  

CALL Questions_Created_Last_Six_Months();

INSERT INTO question(content,CategoryID,TypeID,CreatorID,createDate)
VALUES
		('Ruby',5,2,2,'2022-2-21'),
        ('Python',5,2,2,'2022-3-21'),
        ('Java',5,2,2,'2022-4-21'),
        ('C++',5,2,2,'2022-5-21'),
        ('Ruby',5,2,2,'2022-6-21'),
        ('Java',5,2,2,'2022-7-21'),
        ('Python',5,2,2,'2022-8-21')
        ;



