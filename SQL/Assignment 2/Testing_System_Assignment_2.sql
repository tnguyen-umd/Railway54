-- CREATE DATABASE
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE IF NOT EXISTS TestingSystem;
USE TestingSystem;

-- CREATE TABLE Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
	DepartmentID INT AUTO_INCREMENT PRIMARY KEY,
	DepartmentName varchar(50) UNIQUE KEY
    );

-- Insert values into Department Table
INSERT INTO Department (DepartmentID, DepartmentName)
VALUES
				(1, 		N'Marketing'),
				(2, 		N'Sale'),
        		(3, 		N'Bao Ve'),
				(4, 		N'Nhan Su'),
				(5, 		N'Ky Thuat'),
				(6, 		N'Tai Chinh'),
				(7, 		N'Pho Giam Doc'),
				(8, 		N'Giam Doc'),
				(9, 		N'Thu Ky'),
				(10, 		N'Ban Hang');
    
-- CREATE TABLE Position
DROP TABLE IF EXISTS Position;
CREATE TABLE Position (
	PositionID INT PRIMARY KEY,
	PositionName ENUM('DEV','TEST','PM', 'Scrum Master')
);

INSERT INTO Position (PositionID, PositionName)
VALUES
				(1, 		N'DEV'),
				(2, 		N'TEST'),
        		(3, 		N'PM'),
				(4, 		N'Scrum Master');

-- CREATE TABLE Position1
#DROP TABLE IF EXISTS Position1;
#CREATE TABLE Position1 (
#	PositionID INT PRIMARY KEY,
#	PositionName varchar(50),
 #   CHECK (PositionName='DEV'OR  PositionName='TEST'OR PositionName='PM'OR PositionName='Scrum Master')
#);

-- CREATE TABLE Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
	AccountID INT PRIMARY KEY,
	Email VARCHAR(50) UNIQUE KEY,
	Username VARCHAR(50) UNIQUE KEY not null,
	Fullname VARCHAR(50) not null,
    DepartmentID INT,
    PositionID INT,
	FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID), #DepartmentID int from Department
	FOREIGN KEY (PositionID) REFERENCES Position (PositionID), #PositionID from Position table 
	CreateDate DATETIME DEFAULT NOW()
);

INSERT INTO `Account` (AccountID, Email, Username, Fullname, DepartmentID, PositionID)
VALUES
				(1, 		N'testing@gmail.com', 		N'grantor', 		N'Nikky Smart', 		1, 		1),
				(2, 		N'abc@gmail.com', 			N'referee', 		N'Tom Boy', 			2, 		2),
        		(3, 		N'def@gmail.com', 			N'bookie', 			N'Abrahim Lincoln', 	3, 		3),
				(4, 		N'123@gmail.com', 			N'zombie', 			N'Nguyen Trong Duc', 	4, 		4),
				(5, 		N'ikl@gmail.com', 			N'superman', 		N'Le Duc Anh', 			5, 		1),
				(6, 		N'456@gmail.com', 			N'waterboy', 		N'Funny Son', 			6, 		2),
        		(7, 		N'789@gmail.com', 			N'trainer', 		N'Dickerson Sky', 		7, 		3),
				(8, 		N'ScrumMaster@gmail.com', 	N'eater', 			N'Super Person', 		8, 		4),
				(9, 		N'DEV@gmail.com', 			N'kicker', 			N'Hippy Boy', 			9, 		1),
				(10, 		N'TEST@gmail.com', 			N'baller', 			N'Dang Thanh', 			10, 	2),
        		(11, 		N'PM@gmail.com', 			N'jumper', 			N'Thich La Nhich', 		1, 		3),
				(12, 		N'Scrum Master@gmail.com', 	N'dancer', 			N'Deo Khau Trang', 		2, 		4);

-- CREATE TABLE `Group`
DROP TABLE IF EXISTS `Group`;
CREATE TABLE IF NOT EXISTS `Group` (
	GroupID 		INT NOT NULL,
	GroupName 		VARCHAR(50) not null,
	CreatorID 		INT NOT NULL,
	CreateDate 		DATETIME DEFAULT NOW(),
					FOREIGN KEY(CreatorID) REFERENCES Account(AccountID)
);

INSERT INTO `Group` (GroupID, GroupName, CreatorID)
VALUES
				(1, 		N'SkyTeam', 			1),
				(2, 		N'MorningStar', 		2),
        		(3, 		N'StarAlliance', 		3),
				(4, 		N'United', 				4),
				(1, 		N'SkyTeam', 			5),
				(2, 		N'MorningStar', 		6),
        		(3, 		N'StarAlliance', 		7),
				(4, 		N'United',			 	8),
				(1, 		N'SkyTeam', 			9),
				(2, 		N'MorningStar', 		10),
        		(3, 		N'StarAlliance', 		11),
				(4, 		N'United', 				12);

-- CREATE TABLE Group_Account
DROP TABLE IF EXISTS Group_Account;
CREATE TABLE Group_Account (
	GroupID 		INT,
    AccountID 		INT,
    PRIMARY KEY(GroupID,AccountID),
	FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
	FOREIGN KEY(AccountID) REFERENCES Employee_Account(AccountID),
	JoinDate 		DATETIME DEFAULT NOW()
);

-- CREATE TABLE Type_Question
DROP TABLE IF EXISTS Type_Question;
Create table Type_Question (
	TypeID INT AUTO_INCREMENT PRIMARY KEY,
	TypeName ENUM('Essay','Multiple-Choice')
);

-- CREATE TABLE Category_Question
DROP TABLE IF EXISTS Category_Question;
CREATE TABLE Category_Question (
	CategoryID INT AUTO_INCREMENT PRIMARY KEY,
	CategoryName CHAR(25)
);

-- CREATE TABLE Question
DROP TABLE IF EXISTS Question;
CREATE TABLE Question (
	QuestionID INT AUTO_INCREMENT PRIMARY KEY,
	Content VARCHAR(50),
    CategoryID INT,
    TypeID INT,
   	FOREIGN KEY (CategoryID) REFERENCES Category_Question(CategoryID),
	FOREIGN KEY (TypeID) REFERENCES Type_Question(TypeID),
	CreatorID INT,
	FOREIGN KEY (CreatorID) REFERENCES Account(AccountID),
	CreateDate DATETIME DEFAULT NOW()
);

-- CREATE TABLE Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer (
	AnswerID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Content VARCHAR(50),
    QuestionID INT NOT NULL,
	FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID),
	CreateDate DATETIME DEFAULT NOW()
);

-- CREATE TABLE Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
	ExamID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	ExamCode CHAR(50),
	Title VARCHAR(50),
    CategoryID INT NOT NULL,
   	FOREIGN KEY (CategoryID) REFERENCES Category_Question(CategoryID),
	Duration TINYINT,
	CreatorID INT, #nguoi tao de thi
	FOREIGN KEY (CreatorID) REFERENCES Account(AccountID),
	CreateDate DATETIME DEFAULT NOW()
);

-- CREATE TABLE Exam_Question
DROP TABLE IF EXISTS Exam_Question;
CREATE TABLE Exam_Question (
	ExamID INT NOT NULL,
    QuestionID INT NOT NULL,
	FOREIGN KEY (ExamID) REFERENCES Exam (ExamID), 
	FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

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
