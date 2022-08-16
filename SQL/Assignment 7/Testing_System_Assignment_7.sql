USE TestingSystem;

#Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo 
		# trước 1 năm trước
DROP TRIGGER IF EXISTS Trigger_One_Year;
DELIMITER $$
CREATE TRIGGER Trigger_One_Year
#BEFORE/AFTER/INSTEAD OF INSERT/UPDATE/DELETE ON name_table

BEFORE INSERT ON `Group`
FOR EACH ROW
BEGIN 
-- logic
		IF NEW.CreateDate < date_sub(NOW(), INTERVAL 1 YEAR)
        THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT='Insert date cannot pass 1 year';
		END IF;

END $$
DELIMITER ;

INSERT INTO `Group`(GroupName, CreatorID, CreateDate)
VALUES 
		('thu viec', 1, '2017-12-22');
        

#Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào 
		# department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
		# "Sale" cannot add more user"   
DROP TRIGGER IF EXISTS Trigger_Cannot_Add_Sale_User;
DELIMITER $$
CREATE TRIGGER Trigger_Cannot_Add_Sale_User
BEFORE INSERT ON `Account` 
FOR EACH ROW
BEGIN 
		DECLARE v_deptID INT;
        
        SET v_deptID = (SELECT D.DepartmentID
        FROM Department D
        WHERE D.DepartmentName='Sale');
  
		IF
			NEW.DepartmentID=v_deptID
        THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT='Department Sale cannot add more user';
		END IF;

END $$
DELIMITER ;

INSERT INTO Account(Email , Username, FullName , DepartmentID , PositionID, CreateDate)
VALUES 		('534534@gmail.com' , 'FSDFASF5SD' ,'423423' , 2 , 1,'2020-03-05');

#Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS Max_Users_per_Group;
DELIMITER $$
CREATE TRIGGER Max_Users_per_Group
BEFORE INSERT ON Group_Account
FOR EACH ROW
BEGIN 
-- logic
		DECLARE v_GroupCount INT;
        
        SET v_GroupCount = (SELECT Count(1)
        FROM Group_Account A
        WHERE A.GroupID=NEW.GroupID
        GROUP BY NEW.GroupID
        );

		IF
			v_GroupCount>=5
        THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT='Max user per group is 5';
		END IF;

END $$
DELIMITER ;

INSERT INTO Group_Account ( GroupID , AccountID , JoinDate )
VALUES 
			( 1 , 1,'2019-03-05');

INSERT INTO `Group`(GroupName, CreatorID, CreateDate)
VALUES 
		('thu viec', 1, '2017-12-22');
#Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS Max_Question_per_Exam;
DELIMITER $$
CREATE TRIGGER Max_Question_per_Exam
BEFORE INSERT ON Exam_Question
FOR EACH ROW
BEGIN 
-- logic
		DECLARE v_QuestionCount INT;
        
        SET v_QuestionCount = (SELECT Count(1)
        FROM Exam_Question A
        WHERE A.ExamID=NEW.ExamID
        GROUP BY NEW.ExamID
        );

		IF
			v_QuestionCount>=10
        THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT='Max questions per exam is 10';
		END IF;

END $$
DELIMITER ;

INSERT INTO `Exam_Question`(ExamID, QuestionID)
VALUES 
		(2,10);

#Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là 
		#admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
		#còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông 
		#tin liên quan tới user đó
DROP TRIGGER IF EXISTS Delete_email_not_admin;
DELIMITER $$
CREATE TRIGGER Delete_email_not_admin
BEFORE DELETE ON `account`
FOR EACH ROW
BEGIN 
-- logic
		IF
			OLD.Email='admin@gmail.com'
        THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT='đây là tài khoản admin, không cho phép user xóa';
		END IF;

END $$
DELIMITER ;

DELETE FROM `Account`
WHERE Email='admin@gmail.com';

#Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, 
		#tạo trigger cho phép người dùng khi tạo account không điền 
			# vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
DROP TRIGGER IF EXISTS Default_Department;
DELIMITER $$
CREATE TRIGGER Default_Department
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN 
-- logic
		IF
			NEW.DepartmentID IS NULL 
        THEN
			SET NEW.DepartmentID=12 ;
            #SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'new user was sent to phong cho';
            
		END IF;

END $$
DELIMITER ;

INSERT INTO Account(Email , Username, FullName , PositionID, CreateDate)
VALUES 		('fullname2@gmail.com' , 'fullname2' ,'fullname2' , 1,'2020-03-05');
            
            
#Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi 
		# question, trong đó có tối đa 2 đáp án đúng.

-- CREATE TRIGGER FOR MAX 4 ANSWERS PER QUESTION
DROP TRIGGER IF EXISTS Max_answer_per_question;
DELIMITER $$
CREATE TRIGGER Max_answer_per_question
BEFORE INSERT ON answer
FOR EACH ROW
BEGIN 
-- logic
		DECLARE v_answer_count INT;
        
        SET v_answer_count = (SELECT Count(1)
        FROM answer A
        WHERE A.questionID=NEW.questionID
        GROUP BY NEW.questionID
        );
        
        IF
			v_answer_count>=4
        THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT='max 4 answers per question';
		END IF;
END $$
DELIMITER ;

-- CREATE TRIGGER FOR MAX 2 CORRECT ANSWERS PER QUESTION
DROP TRIGGER IF EXISTS Max_correct_answer_per_question;
DELIMITER $$ 
CREATE TRIGGER Max_correct_answer_per_question BEFORE INSERT ON answer FOR EACH ROW
BEGIN 
-- logic
        DECLARE v_isCorrect_count INT;
                
        SET v_isCorrect_count = (SELECT Count(1)
        FROM answer A
        WHERE isCorrect is TRUE AND A.questionID=NEW.questionID
        GROUP BY questionID
		);
        IF
			v_isCorrect_count>=2
        THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT='Max 2 correct answers per question';
		END IF;
END $$ DELIMITER ;


INSERT INTO answer(content, questionID , isCorrect)
VALUES 		('Trả lời 09' , 9 , 1);

       
#Question 8: Viết trigger sửa lại dữ liệu cho đúng: 
		# Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định 
		# Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
-- CREATE TRIGGER FOR MAX 2 CORRECT ANSWERS PER QUESTION
#ALTER TABLE account drop column gender;

ALTER TABLE `account` ADD COLUMN Gender TEXT AFTER Fullname;

DROP TRIGGER IF EXISTS Update_Gender_Format;
DELIMITER $$ 
CREATE TRIGGER Update_Gender_Format BEFORE INSERT ON `account` FOR EACH ROW
BEGIN 
        DECLARE v_gender_input text;
                
        SET v_gender_input = (SELECT A.Gender
        FROM account A
        WHERE A.Gender=NEW.Gender
        );
        IF v_gender_input='nam'
			THEN SET NEW.Gender ='Male';
		ELSEIF v_gender_input='nu'
			THEN SET NEW.Gender ='Female';
		ELSE SET NEW.Gender ='Unknown';
		END IF;
END $$ DELIMITER ;

INSERT INTO Account(Email , Username, FullName , Gender,PositionID,DepartmentID)
VALUES 		('11111111221211@gmail.com' , '1112221211122111' ,'111212111111' , 'fjhsdjfhdsjkf',1,1);

#Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS Delete_Exam;
DELIMITER $$ 
CREATE TRIGGER Delete_Exam BEFORE DELETE ON exam FOR EACH ROW
BEGIN 
        IF OLD.CreateDate >= date_sub(NOW(), INTERVAL 2 DAY)
        THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT='Cannot delete exam created within the last 2 days';
		END IF;
END $$ DELIMITER ;

INSERT INTO exam(examCode, Title, CategoryID, Duration, CreateDate,CreatorID)
VALUES	('VTI005','Ruby',5,120,now(),4);

DELETE FROM exam
WHERE examID=12;
		

#Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các 
		#question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS Delete_Exam;
DELIMITER $$ 
CREATE TRIGGER Delete_Exam BEFORE DELETE ON question FOR EACH ROW
BEGIN 
		DECLARE v_delete_question INT;
        SET v_delete_question=(
								SELECT COUNT(B.questionID)
								FROM exam_question B
								RIGHT JOIN question A USING(questionID)
								wHERE A.questionID=OLD.questionID
								GROUP BY A.questionID);
        

        IF v_delete_question>0
        THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT='Only question not in an exam can be deleted';
		END IF;
END $$ DELIMITER ;

INSERT INTO question(questionID, content, CategoryID, TypeID,CreatorID)
VALUES	(6,'Ruby',5,2,4);

DELETE FROM `question`
WHERE questionID=7;


        
#Question 12: Lấy ra thông tin exam trong đó:
		#Duration <= 30 thì sẽ đổi thành giá trị "Short time"
		#30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
		#Duration > 60 thì sẽ đổi thành giá trị "Long time"
SELECT ExamID, Title, CASE
WHEN Duration<=30 THEN 'short Time'
WHEN Duration>=30 AND Duration<=60 THEN 'medium time'
WHEN Duration>60 THEN 'long time' END
AS Duration
FROM exam;

#Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên 
		# là the_number_user_amount và mang giá trị được quy định như sau:
#		Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
#		Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
#		Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
SELECT GroupID, AccountID, COUNT(A.GroupID), CASE 
	WHEN COUNT(A.GroupID)<=5 OR NULL THEN 'few'
    WHEN COUNT(A.GroupID)>5 AND COUNT(A.GroupID)<=20 THEN 'normal'
    WHEN COUNT(A.GroupID)>20 THEN 'higher' 
    END
    
AS number_user_amount
FROM group_account A
GROUP BY A.GroupID;

#Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào 
		# không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
        
SELECT A.departmentID, A.departmentName, CASE 
WHEN count(B.departmentID)>0 THEN count(B.departmentID)
ELSE 'No User'
END
AS Number_Accounts
FROM `account` B
Right JOIN `department` A
ON A.departmentID=B.departmentID
GROUP BY a.departmentID;
