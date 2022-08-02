USE TestingSystem;
SELECT 		*FROM department;

SELECT 		DepartmentID,DepartmentName
FROM 		Department
WHERE 		DepartmentName = 'Sale';

SELECT MAX(LENGTH(FullName)) FROM Account;

SELECT * FROM `Group`.GroupID
WHERE Creatdate < '2020-12-20'; 

-- Question 7 Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT * FROM exam_question.questionID
GROUP BY 
HAVING COUNT(questionID) <= 4

-- Question 8 Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT * FROM exam
WHERE Duration >= 60 AND CreateDate<'2019-12-20'; 

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT *
FROM testingsystem.Group
ORDER BY Createdate desc
LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT DepartmentID, count(AccountID) AS SO_NHAN_VIEN FROM testingsystem.Account 
where DepartmentID=2; 

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT * FROM testingsystem.Account
WHERE Username LIKE (D%o);

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
-- Question 15: update account có id = 5 sẽ thuộc group có id = 4

