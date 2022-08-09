USE TestingSystem;

#(Sử dụng subquery hoặc CTE)

#QUESTION 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE VIEW NHAN_VIEN_SALE AS
	SELECT a.userName, a.fullName, b.departmentName
	FROM account A
	INNER JOIN department B
	ON A.DepartmentID=B.DepartmentID
	WHERE B.DepartmentID = (SELECT DepartmentID
							FROM department D1
							WHERE D1.departmentname='Sale');

SELECT * FROM NHAN_VIEN_SALE;

#QUESTION 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất (nhieu groupID nhat)
		-- THIS IS HOW I DID IT
		-- CREATED CTE_Counting TO STORE USER INFO AND COUNT GROUPID
		-- CREATED SUBQUERY TO COUNT MAX GROUPID
		-- COMPARE CTE_Counting's Count with Count from Subquery
CREATE VIEW Account_with_most_group AS
	WITH CTE_Counting AS (SELECT A.accountid,a.username,b.groupid, COUNT(B.AccountID) AS COUNT
	FROM account A
	INNER JOIN `group_account` B
	ON A.AccountID=B.AccountID
	GROUP BY B.AccountID) 
	#SELECT * FROM ABC
    
    SELECT * FROM CTE_Counting
	WHERE CTE_Counting.COUNT =				(SELECT MAX(Total) 
											FROM (SELECT COUNT(1) AS Total FROM group_account AS G GROUP BY G.AccountID) AS Results
											);

			#CREATE VIEW Account_with_most_group AS
			#    SELECT A.accountid,a.username,b.groupid, count(a.accountid) AS COUNTING
			#	FROM account A
			#	INNER JOIN `group_account` B
			#	ON A.AccountID=B.AccountID
			#							GROUP BY A.AccountID
			#							ORDER BY COUNTING DESC
			#							LIMIT 1;
			#SELECT * from group_account;

#QUESTION 3: Tạo view có chứa question có những content quá dài (content quá 300 từ  được coi là quá dài) và xóa nó đi
			-- CREATE VIEW QUESTION_TOO_LONG
DROP VIEW IF EXISTS QUESTION_TOO_LONG ;
CREATE VIEW QUESTION_TOO_LONG AS
	WITH CET_Long_question AS 
    (SELECT *, LENGTH(CONTENT) AS LENGTH FROM testingsystem.question
    WHERE  length(Content) >20
    )
    SELECT * FROM CET_Long_question;
    			-- DELETE LONG QUESTION FROM TABLE QUESTION 
DELETE FROM question
WHERE length(Content) >20;


#QUESTION 4: Tạo view có chứa danh sách các phòng ban(department) có max nhiều nhân viên (accountID
DROP VIEW IF EXISTS QUESTION_TOO_LONG ;
CREATE VIEW DEPARTMENT_MAX_EMPLOYEE AS
	WITH CET_RANDOM AS (
    SELECT A.departmentName, Count(1) AS NUMBER_OF_EMPLOYEES
	FROM department AS A
	INNER JOIN account AS B
	ON A.departmentID=B.departmentID
	GROUP BY A.departmentID
	ORDER BY A.departmentID DESC
	LIMIT 1)
    
    SELECT * FROM CET_RANDOM;
    ;


#QUESTION 5: Tạo view có chứa tất các các cau hoi	QUESTION.CREATORid do user(account.AccountID) họ Nguyễn tạo
#SELECT * FROM QUESTION;
#SELECT * FROM account;
#UPDATE  `account`
#SET  Fullname='Nguyễn Thi Ha'
#WHERE accountID=1;
#UPDATE  `account`
#SET  Fullname='Nguyễn Van A'
#WHERE accountID=2;
#UPDATE  `account`
#SET  Fullname='Nguyễn Van Phuc'
#WHERE accountID=3;

	WITH CET_ANOTHER AS 	(SELECT B.Fullname, A.Content AS QUESTION, B.AccountID
							FROM question AS A
							INNER JOIN `account` AS B
							ON A.CREATORid=B.AccountID
							WHERE B.Fullname LIKE ('Nguyễn%'))
	SELECT * FROM CET_ANOTHER                     
                            ;

-- lay ra thong tin cua cau hoi co level tu 2 tro len
