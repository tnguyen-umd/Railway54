USE TestingSystem;

#Question 1: Viết lệnh để lấy ra danh sách Account và thông tin Department của họ
SELECT a.DepartmentID, A.accountID, a.email, a.Username, a.Fullname, b.departmentName
FROM Account AS A
INNER JOIN Department AS B
ON A.DepartmentID=B.DepartmentID;

#Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010 
SELECT * 
FROM Department A
INNER JOIN Account B
ON A.DepartmentID=B.DepartmentID
WHERE CreateDate>'2010-12-20';

#Question 3: Viết lệnh để lấy ra tất cả các developer PositionIDPositionName
SELECT * 
FROM position A
INNER JOIN Account B
ON A.PositionID=B.PositionID
WHERE PositionName='Dev';

#Question 4: Viết lệnh để lấy ra danh sách các DepartmentName có >3 accountID
SELECT DepartmentName, COUNT(DepartmentName) AS `#EMPLOYEE`
FROM Department A
INNER JOIN Account B
ON A.DepartmentID=B.DepartmentID
GROUP BY DepartmentName
HAVING COUNT(DepartmentName)>3;

#INSERT INTO `Account`(Email , Username, FullName , DepartmentID , PositionID, CreateDate)
#VALUES 		
#			('Email13@gmail.com' , 'Username13' ,'Fullname13', '1' , '1' ,'2020-04-09'),
#			('Email14@gmail.com' , 'Username14' ,'Fullname14', '10' , '1' , DEFAULT),
#			('Email15@gmail.com' , 'Username15','Fullname15' , '10' , '1' , DEFAULT)
#			('Email16@gmail.com' , 'Username16' ,'Fullname16', '2' , '1' ,'2020-04-09');

#Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
#SELECT * FROM `question`;
#SELECT * FROM `EXAM_QUESTION`;

SELECT A.QuestionID, a.content, count(1) AS MAX_QUESTION_EXAM
FROM question A
INNER JOIN exam_question B
ON A.QuestionID=B.QuestionID
GROUP BY A.questionID
ORDER BY COUNT(A.QuestionID) DESC
LIMIT 1;

/*THIS IS HOW TO USE MAX FUNCTION
select examquestion.QuestionID,question.Content
FROM question
INNER JOIN examquestion
ON question.QuestionID=examquestion.QuestionID
group by examquestion.QuestionID
HAVING count(examquestion.QuestionID) = (
select MAX(DEM) AS gtln
FROM (
SELECT QUESTIONid, count(QuestionID) AS DEM
FROM	examquestion
GROUP BY QuestionID) AS MAXCOUNT) ;*/


#Question 6: Thông kê mỗi CategoryID được sử dụng trong bao nhiêu Question
SELECT questionID, count(1) as COUNTING
FROM category_question A
INNER JOIN question B
ON A.CategoryID=B.CategoryID
GROUP BY a.CategoryID;

#SELECT * FROM question;
#SELECT * FROM exam_question;
#INSERT INTO `Question`(QuestionID , Content, CategoryID , TypeID , CreatorID, CreateDate)
#VALUES 		
#			('11' , 'Câu hỏi về Java' ,'2', '1' , '2' ,'2020-04-12'),
#			('12' , 'Câu hỏi về PHP' ,'3', '2' , '3' ,'2020-04-15');
            
#Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT A.questionID, B.ExamID, COUNT(B.questionID) AS COUNT
FROM exam_question B
RIGHT JOIN question A USING(questionID)
GROUP BY A.questionID;

#Question 8: Lấy ra Question có nhiều câu trả lời nhất
#SELECT * FROM ANSWER;
#SELECT * FROM QUESTION;
SELECT a.questionID, A.content, count(1) as Number_Answers
FROM question A
INNER JOIN answer B
ON A.QuestionID=B.QuestionID
GROUP BY a.QuestionID
ORDER BY Number_Answers DESC
LIMIT 1
;


#Question 9: Thống kê số lượng account trong mỗi group
#select * from group_account;
SELECT A.groupID, A.groupname, count(B.groupID) as Number_Accounts
FROM `group_account` B
Right JOIN `group` A
ON A.GroupID=B.GroupID
GROUP BY a.groupID;


#Question 10: Tìm chức vụ có ít người nhất
SELECT PositionID, count(1) as Number_Position
FROM account
GROUP BY PositionID
ORDER BY COUNT(1) ASC
LIMIT 1;

#Question 11: Thống kê mỗi Department có bao nhiêu dev, test, scrum master, PM
#select * from ACCOUNT;
#select * from position;
#select * from department;
SELECT departmentName, a.departmentID, count(1) as Number_Answers
FROM account A
INNER JOIN position B
ON A.PositionID=B.PositionID
INNER JOIN Department C
ON a.DepartmentID=c.DepartmentID
GROUP BY a.DepartmentID;

#Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, type_question.typename, account.Fullname, answer.content, …
#select * from type_question;
#SELECT * FROM `question`;
#SELECT * FROM `answer`;
#SELECT * FROM `account`;
SELECT a.QuestionID, a.content,b.typename,c.Fullname, d.content
FROM question A
INNER JOIN type_question B
ON A.TypeID=B.TypeID
INNER JOIN `account` C
ON A.CreatorID=C.AccountID
INNER JOIN answer D
ON A.QuestionID=D.QuestionID;


#Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT TypeName, count(B.TypeID) as SO_lUONG
FROM question A
LEFT JOIN type_question B
ON A.TypeID=B.TypeID
GROUP BY A.TypeID;

#Question 14:Lấy ra group không có account nào
#select * from ACCOUNT;
#SELECT * FROM `group`;
#select * from group_account;
SELECT *#GroupName, a.GroupID
FROM `group` A
LEFT JOIN group_account B
ON A.GroupID=B.GroupID
WHERE B.AccountID IS NULL;

#Question 15: Lấy ra group không có account nào
#select * from ACCOUNT;
#SELECT * FROM `group`;
#select * from group_account;
SELECT GroupName, a.GroupID, b.AccountID
FROM `group` A
LEFT JOIN group_account B
ON A.GroupID=B.GroupID
WHERE B.AccountID IS NULL;

#Question 16: Lấy ra question không có answer nào
select * from answer;
SELECT * FROM `question`;
#select * from group_account;
SELECT a.questionID, a.content, answerID
FROM `question` A
LEFT JOIN answer B
ON A.questionID=B.questionID
WHERE B.questionID IS NULL;

#Question 17: 
#a) Lấy các account thuộc nhóm thứ 1
SELECT fullname 
FROM account A 
INNER JOIN group_account B
ON A.accountID=B.accountID
WHERE groupID=1;

#b) Lấy các account thuộc nhóm thứ 3
SELECT fullname 
FROM account A 
INNER JOIN group_account B
ON A.accountID=B.accountID
WHERE groupID=3;

#c) UNION Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau\
SELECT fullname
FROM account A 
INNER JOIN group_account B
ON A.accountID=B.accountID
WHERE groupID=1
UNION-- This is where UNION is grouping 2 tables
SELECT fullname 
FROM account A 
INNER JOIN group_account B
ON A.accountID=B.accountID
WHERE groupID=3;


#Question 18: 
#a) Lấy các group có lớn hơn 5 thành viên
select * from `group`;
SELECT * FROM `group_account`;
SELECT GroupName,A.groupID,count(A.groupID) AS SO_LUONG_THANH_VIEN
FROM `group` A 
INNER JOIN group_account B
ON A.groupID=B.groupID
GROUP BY A.groupID
HAVING count(A.groupID)>5;

#b) Lấy các group có nhỏ hơn 7 thành viên
SELECT GroupName,A.groupID,count(A.groupID) AS SO_LUONG_THANH_VIEN
FROM `group` A 
INNER JOIN group_account B
ON A.groupID=B.groupID
GROUP BY A.groupID
HAVING count(A.groupID)<7;

#c) Ghép 2 kết quả từ câu a) và câu b)
SELECT GroupName,A.groupID,count(A.groupID) AS SO_LUONG_THANH_VIEN
FROM `group` A 
INNER JOIN group_account B
ON A.groupID=B.groupID
GROUP BY A.groupID
HAVING count(A.groupID)>5

UNION

SELECT GroupName,A.groupID,count(A.groupID) AS SO_LUONG_THANH_VIEN
FROM `group` A 
INNER JOIN group_account B
ON A.groupID=B.groupID
GROUP BY A.groupID
HAVING count(A.groupID)<7;
