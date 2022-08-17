-- CREATE DATABASE TestingSystem
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE IF NOT EXISTS TestingSystem;
USE TestingSystem;

-- CREATE TABLE Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
	DepartmentID INT AUTO_INCREMENT PRIMARY KEY,
	DepartmentName varchar(50) UNIQUE KEY
    );
  
-- CREATE TABLE Position
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position` (
	PositionID INT AUTO_INCREMENT PRIMARY KEY,
	PositionName ENUM('Dev','Test','Scrum Master','PM') NOT NULL UNIQUE KEY
);

-- CREATE TABLE Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
	AccountID INT AUTO_INCREMENT PRIMARY KEY,
	Email VARCHAR(50) UNIQUE KEY,
	Username NVARCHAR(50) UNIQUE KEY not null,
	Fullname NVARCHAR(50) not null,
    DepartmentID INT NOT NULL,
    PositionID INT NOT NULL,
	FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID) ON DELETE CASCADE, #DepartmentID int from Department
	FOREIGN KEY (PositionID) REFERENCES `Position` (PositionID) ON DELETE CASCADE, #PositionID from Position table 
	CreateDate DATETIME DEFAULT NOW()
);
                
-- CREATE TABLE `Group`
DROP TABLE IF EXISTS `Group`;
CREATE TABLE IF NOT EXISTS `Group` (
	GroupID 		INT AUTO_INCREMENT PRIMARY KEY,
	GroupName 		VARCHAR(50) NOT NULL UNIQUE,
	CreatorID 		INT,
	CreateDate 		DATETIME DEFAULT NOW(),
	FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID) ON DELETE CASCADE
);

-- CREATE TABLE Group_Account
DROP TABLE IF EXISTS Group_Account;
CREATE TABLE Group_Account (
	GroupID 		INT NOT NULL,
    AccountID 		INT NOT NULL,
    PRIMARY KEY(GroupID,AccountID),
	FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID) ON DELETE CASCADE,
	FOREIGN KEY(AccountID) REFERENCES `Account`(AccountID) ON DELETE CASCADE,
	JoinDate 		DATETIME DEFAULT NOW()
);

-- CREATE TABLE Type_Question
DROP TABLE IF EXISTS Type_Question;
Create table Type_Question (
	TypeID INT AUTO_INCREMENT PRIMARY KEY,
	TypeName ENUM('Essay','Multiple-Choice') NOT NULL UNIQUE
);

-- CREATE TABLE Category_Question
DROP TABLE IF EXISTS Category_Question;
CREATE TABLE Category_Question (
	CategoryID INT AUTO_INCREMENT PRIMARY KEY,
	CategoryName VARCHAR(50) NOT NULL UNIQUE
);

-- CREATE TABLE Question
DROP TABLE IF EXISTS Question;
CREATE TABLE Question (
	QuestionID INT AUTO_INCREMENT PRIMARY KEY,
	Content VARCHAR(100) NOT NULL,
    CategoryID INT NOT NULL,
    TypeID INT NOT NULL,
   	CreatorID INT  NOT NULL,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY (CategoryID) REFERENCES Category_Question(CategoryID) ON DELETE CASCADE,
	FOREIGN KEY (TypeID) REFERENCES Type_Question(TypeID) ON DELETE CASCADE,
	FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID) ON DELETE CASCADE
	);

-- CREATE TABLE Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer (
	AnswerID INT AUTO_INCREMENT PRIMARY KEY,
	Content VARCHAR(100) NOT NULL,
    QuestionID INT NOT NULL,
    isCorrect BIT DEFAULT 1,
	FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE,
	CreateDate DATETIME DEFAULT NOW()
);

-- CREATE TABLE Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
	ExamID INT AUTO_INCREMENT PRIMARY KEY,
	ExamCode CHAR(50) NOT NULL,
	Title VARCHAR(50) NOT NULL,
    CategoryID INT NOT NULL,
	Duration TINYINT NOT NULL,
    CreateDate DATETIME DEFAULT NOW(),
	CreatorID INT,
   	FOREIGN KEY (CategoryID) REFERENCES Category_Question(CategoryID) ON DELETE CASCADE,
	FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID) ON DELETE CASCADE
);

-- CREATE TABLE Exam_Question
DROP TABLE IF EXISTS Exam_Question;
CREATE TABLE Exam_Question (
	ExamID INT NOT NULL,
    QuestionID INT NOT NULL,
	FOREIGN KEY (ExamID) REFERENCES Exam (ExamID) ON DELETE CASCADE, 
	FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID) ON DELETE CASCADE,
    PRIMARY KEY (ExamID,QuestionID)
);

-- USE TestingSystem;
INSERT INTO Department(DepartmentName) 
VALUES
			(N'Marketing' ),
			(N'Sale' ),
			(N'Bảo vệ' ),
			(N'Nhân sự' ),
			(N'Kỹ thuật' ),
			(N'Tài chính' ),
			(N'Phó giám đốc'),
			(N'Giám đốc' ),
			(N'Thư kí' ),
			(N'No person' ),
			(N'Bán hàng' ),
            (N'Cho viec' );

INSERT INTO `Position`(PositionName) 
VALUES 		('Dev'),
			('Test'),
			('Scrum Master'),
			('PM'); 
            
INSERT INTO `Account`(Email , Username, FullName , DepartmentID , PositionID, CreateDate)
VALUES 		('Email1@gmail.com' , 'Username1' ,'Fullname1' , '5' , '1','2020-03-05'),
			('Email2@gmail.com' , 'Username2' ,'Fullname2' , '1' , '2','2020-03-05'),
			('Email3@gmail.com' , 'Username3' ,'Fullname3', '2' , '2' ,'2020-03-07'),
			('Email4@gmail.com' , 'Username4' ,'Fullname4', '3' , '4' ,'2020-03-08'),
			('Email5@gmail.com' , 'Username5' ,'Fullname5', '4' , '4' ,'2020-03-10'),
			('Email6@gmail.com' , 'Username6' ,'Fullname6', '6' , '3' ,'2020-04-05'), 
			('Email7@gmail.com' , 'Username7' ,'Fullname7', '2' , '2' , NULL ),
			('Email8@gmail.com' , 'Username8' ,'Fullname8', '8' , '1' ,'2020-04-07'),
			('Email9@gmail.com' , 'Username9' ,'Fullname9', '2' , '2' ,'2020-04-07'),
			('Email10@gmail.com' , 'Username10' ,'Fullname10', '10' , '1' ,'2020-04-09'),
			('Email11@gmail.com' , 'Username11' ,'Fullname11', '10' , '1' , DEFAULT),
			('Email12@gmail.com' , 'Username12','Fullname12' , '10' , '1' , DEFAULT);
            
INSERT INTO `Group` ( GroupName , CreatorID , CreateDate)
VALUES 
			(N'Testing System' , 5,'2019-03-05'),
			(N'Development' , 1,'2020-03-07'),
			(N'VTI Sale 01' , 2 ,'2020-03-09'),
			(N'VTI Sale 02' , 3 ,'2020-03-10'),
			(N'VTI Sale 03' , 4 ,'2020-03-28'),
			(N'VTI Creator' , 6 ,'2020-04-06'),
			(N'VTI Marketing 01' , 7 ,'2020-04-07'),
			(N'Management' , 8 ,'2020-04-08'),
			(N'Chat with love' , 9 ,'2020-04-09'),
			(N'Vi Ti Ai' , 10 ,'2020-04-10');

INSERT INTO Group_Account ( GroupID , AccountID , JoinDate )
VALUES 
			( 1 , 1,'2019-03-05'),
			( 1 , 2,'2020-03-07'),
			( 3 , 3,'2020-03-09'),
			( 3 , 4,'2020-03-10'),
			( 5 , 5,'2020-03-28'),
			( 1 , 3,'2020-04-06'),
			( 1 , 7,'2020-04-07'),
			( 8 , 3,'2020-04-08'),
			( 1 , 9,'2020-04-09'),
			( 10 , 10,'2020-04-10');
            
INSERT INTO Type_Question (TypeName ) 
VALUES 
			('Essay' ), 
			('Multiple-Choice' );

INSERT INTO Category_Question (CategoryName )
VALUES 
			('Java' ),
			('ASP.NET' ),
			('ADO.NET' ),
			('SQL' ),
			('Postman' ),
			('Ruby' ),
			('Python' ),
			('C++' ),
			('C Sharp' ),
			('PHP' );

INSERT INTO Question (Content , CategoryID, TypeID , CreatorID, CreateDate )
VALUES 
			(N'Câu hỏi về Java' , 1 , '1' , '2' ,'2020-04-05'),
			(N'Câu Hỏi về PHP' , 10 , '2' , '2' ,'2020-04-05'),
			(N'Hỏi về C#' , 9 , '2' , '3' ,'2020-04-06'),
			(N'Hỏi về Ruby' , 6 , '1' , '4' ,'2020-04-06'),
			(N'Hỏi về Postman' , 5 , '1' , '5' ,'2020-04-06'),
			(N'Hỏi về ADO.NET' , 3 , '2' , '6' ,'2020-04-06'),
			(N'Hỏi về ASP.NET' , 2 , '1' , '7' ,'2020-04-06'),
			(N'Hỏi về C++' , 8 , '1' , '8' ,'2020-04-07'),
			(N'Hỏi về SQL' , 4 , '2' , '9' ,'2020-04-07'),
			(N'Hỏi về Python' , 7 , '1' , '10' ,'2020-04-07');

INSERT INTO Answer ( Content , QuestionID , isCorrect )
VALUES 
			(N'Trả lời 01' , 1 , 0),
			(N'Trả lời 02' , 1 , 1),
			(N'Trả lời 03', 1 , 0 ),
			(N'Trả lời 04', 1 , 1 ),
			(N'Trả lời 05', 2 , 1 ),
			(N'Trả lời 06', 3 , 1 ),
			(N'Trả lời 07', 4 , 0 ),
			(N'Trả lời 08', 8 , 0 ),
			(N'Trả lời 09', 9 , 1 ),
			(N'Trả lời 10', 10 , 1 );
            
INSERT INTO Exam (ExamCode , Title , CategoryID, Duration , CreatorID , CreateDate )
VALUES 
			('VTIQ001' , N'Đề thi C#' ,1 , 60 , '5' ,'2019-04-05'),
			('VTIQ002' , N'Đề thi PHP' ,10 , 60 , '2' ,'2019-04-05'),
			('VTIQ003' , N'Đề thi C++' , 9 ,120 , '2' ,'2019-04-07'),
			('VTIQ004' , N'Đề thi Java' , 6 , 60, '3' ,'2020-04-08'),
			('VTIQ005' , N'Đề thi Ruby' , 5 , 120, '4' ,'2020-04-10'),
			('VTIQ006' , N'Đề thi Postman' , 3 ,60 , '6' ,'2020-04-05'),
			('VTIQ007' , N'Đề thi SQL' , 2 ,60 , '7' ,'2020-04-05'),
			('VTIQ008' , N'Đề thi Python' , 8 ,60 , '8' ,'2020-04-07'),
			('VTIQ009' , N'Đề thi ADO.NET' , 4 ,90 , '9' ,'2020-04-07'),
			('VTIQ010' , N'Đề thi ASP.NET' , 7 ,90 , '10' ,'2020-04-08');

INSERT INTO Exam_Question(ExamID , QuestionID ) 
VALUES 
			( 1 , 5 ),
			( 2 , 10 ), 
			( 3 , 4 ), 
			( 4 , 3 ), 
			( 5 , 7 ), 
			( 6 , 10 ), 
			( 7 , 2 ), 
			( 8 , 10 ), 
			( 9 , 9 ), 
			( 10 , 8 );
SELECT * FROM `Account`     ;
       
--  if we have more than 1 primary keys, use the following code
	#CREATE TABLE SV (
    #id INT NOT NULL,
   # ht VARCHAR(70) NOT NULL,
   # PRIMARY KEY(id,ht));
   
-- to ALTER TABLE with new primary key
	#CREATE TABLE SV (
		#id INT NOT NULL, CHECK (id BETWEEN 0 AND 10 DEFAULT 7.5),
		# ht VARCHAR(70) NOT NULL);
        
   #ALTER TABLE SV ADD PRIMARY KEY (id); OR  #ALTER TABLE SV ADD CONSTRAINT PRIMARY KEY (id); 
		# You can also use the same format for ALTER TABLE SV ADD FOREIGN KEY (id);
        # ALTER TABLE SV DROP FOREIGN KEY (id);
        # ALTER TABLE 'table name' ALTER 'column name' SET DEFAULT;
		# ALTER TABLE 'table name' ALTER 'column name' DROP DEFAULT;
        
#truncate Department;
#SELECT * from Department; #show content in a table
#select * from Position; 
#desc EmployeeAccount; #show content in a table in descending order
#show tables;
#INSERT INTO EmployeeAccount (PositionID)  SELECT PositionID FROM Position; #put PositionID into EmployeeAccountCREATE TABLE IF NOT EXISTS Group_Team (  GroupID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,  GroupName VARCHAR(50) not null,  CreatorID INT NOT NULL,  CreateDate DATE,     FOREIGN KEY(CreatorID) REFERENCES Employee_Account(AccountID) )
