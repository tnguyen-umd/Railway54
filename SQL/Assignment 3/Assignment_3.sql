USE TestingSystem;
#Question 1: Thêm ít nhất 10 record vào mỗi table

#Question 2: lấy ra tất cả các Department
SELECT * FROM Department;

#Question 3: lấy ra id của Department "Sale"
SELECT DepartmentID FROM Department
WHERE DepartmentName ='Sale';

#Question 4: lấy ra thông tin account có full name dài nhất
SELECT AccountID, Fullname, length(Fullname) AS TEN_DAI_NHAT FROM `Account` 
ORDER BY TEN_DAI_NHAT DESC
LIMIT 1;

-- UPDATE `Account` SET Fullname='Frederick Johnson' WHERE AccountID=12;
#SELECT * FROM `Account`;
 
#Question 5: Lấy ra thông tin account có full name dài nhất và thuộc DepartmentID  = 3
SELECT AccountID, Fullname, DepartmentID, length(Fullname) AS TEN_DAI_NHAT FROM `Account`
WHERE DepartmentID=3 
ORDER BY TEN_DAI_NHAT DESC
LIMIT 5;

#Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT * FROM `Group`
WHERE CreateDate<'2022-12-20';

#Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT QuestionID FROM `Answer` 
GROUP BY QuestionID
HAVING COUNT(QuestionID)>=4;
#The GROUP BY clause is used to group rows that have the same values. 
#It summarizing data from the database.
#SELECT statements... GROUP BY column_name1[,column_name2,...] [HAVING condition];

#Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày  20/12/2019
SELECT ExamID FROM exam
WHERE Duration>=60
AND CreateDate<'2019-12-20';

#Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;

#Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(DepartmentID) 
AS SO_NHAN_VIEN
FROM `Department`
WHERE DepartmentID=2;

#Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT * FROM `Account`
WHERE Fullname LIKE 'D%o';

#Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
#INSERT INTO Exam (ExamCode , Title , CategoryID, Duration , CreatorID , CreateDate )
#VALUES 
#			('VTIQ001' , N'Đề thi C#' ,1 , 60 , '5' ,'2019-04-05'),
#			('VTIQ002' , N'Đề thi PHP' ,10 , 60 , '2' ,'2019-04-05'),
#			('VTIQ003' , N'Đề thi C++' , 9 ,120 , '2' ,'2019-04-07');
DELETE FROM exam
WHERE CreateDate<'2019-12-20';
SELECT * FROM exam;

#Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE FROM question
WHERE Content LIKE 'Câu hỏi%';
SELECT * FROM question;

#Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và  email thành loc.nguyenba@vti.com.vn
UPDATE `Account`
SET Fullname='Nguyễn Bá Lộc', Email='thành.loc.nguyenba@vti.com.vn'
WHERE AccountID=5;
#SELECT * FROM `Account`;

#Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE `Group_Account`
SET GroupID=4
WHERE AccountID=5;
SELECT * FROM `Group_Account`;