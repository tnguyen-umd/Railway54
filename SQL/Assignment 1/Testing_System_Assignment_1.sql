-- CREATE DATABASE
DROP DATABASE IF EXISTS Testing_System_Assignment_1;
CREATE DATABASE IF NOT EXISTS Testing_System_Assignment_1;
USE Testing_System_Assignment_1;

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

-- CREATE TABLE Position1
DROP TABLE IF EXISTS Position1;
CREATE TABLE Position1 (
	PositionID INT PRIMARY KEY,
	PositionName varchar(50),
    CHECK (PositionName='DEV'OR  PositionName='TEST'OR PositionName='PM'OR PositionName='Scrum Master')
);

-- CREATE TABLE Employee_Account
DROP TABLE IF EXISTS Employee_Account;
CREATE TABLE Employee_Account (
	AccountID INT PRIMARY KEY UNIQUE KEY,
	Email VARCHAR(50) UNIQUE KEY,
	Username VARCHAR(50) UNIQUE KEY not null,
	Fullname VARCHAR(50) not null,
    DepartmentID INT,
    PositionID INT,
	FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID), #DepartmentID int from Department
	FOREIGN KEY (PositionID) REFERENCES Position (PositionID), #PositionID from Position table 
	CreateDate DATE
);

-- CREATE TABLE Group_Team
DROP TABLE IF EXISTS Group_Team;
CREATE TABLE IF NOT EXISTS Group_Team (
	GroupID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	GroupName VARCHAR(50) not null,
	CreatorID INT NOT NULL,
	CreateDate DATE,
    FOREIGN KEY(CreatorID) REFERENCES Employee_Account(AccountID)
);

-- CREATE TABLE Group_Account
DROP TABLE IF EXISTS Group_Account;
CREATE TABLE Group_Account (
	GroupID INT NOT NULL,
    AccountID INT NOT NULL,
	FOREIGN KEY (GroupID) REFERENCES Group_Team(GroupID),
	FOREIGN KEY (AccountID) REFERENCES Employee_Account(AccountID),
	JoinDate DATE
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
	FOREIGN KEY (CreatorID) REFERENCES Employee_Account(AccountID),
	CreateDate DATE
);

-- CREATE TABLE Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer (
	AnswerID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Content VARCHAR(50),
    QuestionID INT NOT NULL,
	FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID),
	CreateDate DATE
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
	FOREIGN KEY (CreatorID) REFERENCES Employee_Account(AccountID),
	CreateDate DATE
);

-- CREATE TABLE Exam_Question
DROP TABLE IF EXISTS Exam_Question;
CREATE TABLE Exam_Question (
	ExamID INT NOT NULL,
    QuestionID INT NOT NULL,
	FOREIGN KEY (ExamID) REFERENCES Exam (ExamID), 
	FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

#truncate Department;
SELECT * from Department; #show content in a table
#select * from Position; 
#desc EmployeeAccount; #show content in a table in descending order
#show tables;
#INSERT INTO EmployeeAccount (PositionID)  SELECT PositionID FROM Position; #put PositionID into EmployeeAccountCREATE TABLE IF NOT EXISTS Group_Team (  GroupID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,  GroupName VARCHAR(50) not null,  CreatorID INT NOT NULL,  CreateDate DATE,     FOREIGN KEY(CreatorID) REFERENCES Employee_Account(AccountID) )
