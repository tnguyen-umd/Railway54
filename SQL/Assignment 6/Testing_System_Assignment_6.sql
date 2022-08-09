USE TestingSystem;

#Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các  account thuộc phòng ban đó
DELIMITER $$
DROP PROCEDURE IF EXISTS GET_DEPARTMENT_ACCOUNT;
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

#Question 2: Tạo store để in ra số lượng account trong mỗi group
DELIMITER $$
DROP PROCEDURE IF EXISTS GET_ACCOUNT_PER_GROUP;
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
DELIMITER $$
DROP PROCEDURE IF EXISTS GET_QUESTIONS_CREATED_THIS_MONTH;
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
DELIMITER $$
DROP PROCEDURE IF EXISTS TYPE_MAX_QUESTION;
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

#Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên 
 #chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào
 
#Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và  trong store sẽ tự động gán:
#username sẽ giống email nhưng bỏ phần @..mail đi positionID: sẽ có default là developer
#departmentID: sẽ được cho vào 1 phòng chờ Sau đó in ra kết quả tạo thành công
 
#Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

#Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID

#Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử  dụng store ở câu 9 để xóa)
 -- Sau đó in số lượng record đã remove từ các table liên quan trong khi 
 -- removing
#Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng  nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được  chuyển về phòng ban default là phòng ban chờ việc
#Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm  nay
#Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6  tháng gần đây nhất
#Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng"
