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
    
-- CREATE TABLE Position
DROP TABLE IF EXISTS Position;
CREATE TABLE Position (
	PositionID INT,
	PositionName ENUM('DEV','TEST','PM', 'BOD')
);

-- CREATE TABLE Employee_Account
DROP TABLE IF EXISTS Employee_Account;
CREATE TABLE Employee_Account (
	AccountID INT UNSIGNED PRIMARY KEY UNIQUE KEY,
	Email VARCHAR(50) UNIQUE KEY,
	Username VARCHAR(50) UNIQUE KEY not null,
	Fullname VARCHAR(50) not null,
    DepartmentID INT,
    PositionID INT,
	FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID), #DepartmentID int from Department
	FOREIGN KEY (PositionID) REFERENCES Position (PositionID), #PositionID from Position table 
	CreateDate DATE
);

DROP TABLE IF EXISTS Group_Team;
CREATE TABLE IF NOT EXISTS Group_Team (
	GroupID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	GroupName VARCHAR(50) not null,
	CreatorID INT NOT NULL,
	CreateDate DATE,
    FOREIGN KEY(CreatorID) REFERENCES Employee_Account(AccountID)
);

DROP TABLE IF EXISTS Group_Account;
CREATE TABLE Group_Account (
	FOREIGN KEY (GroupID) REFERENCES Group_Team(GroupID),
	FOREIGN KEY (AccountID) REFERENCES EmployeeAccount(AccountID),
	JoinDate DATE
);

DROP TABLE IF EXISTS Type_Question;
Create table Type_Question (
	TypeID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	TypeName ENUM('Essay','Multiple-Choice')
);

DROP TABLE IF EXISTS Category_Question;
CREATE TABLE Category_Question (
	CategoryID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	CategoryName CHAR(25)
);

DROP TABLE IF EXISTS Question;
CREATE TABLE Question (
	QuestionID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Content VARCHAR(50),
   	FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
	FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID),
	CreatorID INT,
	CreateDate DATE
);

DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer (
	AnswerID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Content VARCHAR(50),
	FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID),
	CreateDate DATE
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
	ExamID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	ExamCode CHAR(50),
	Title VARCHAR(50),
   	FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
	Duration TINYINT,
	CreatorID INT, #nguoi tao de thi
	CreateDate DATE
);

DROP TABLE IF EXISTS Exam_Question;
CREATE TABLE Exam_Question (
	FOREIGN KEY (ExamID) REFERENCES Exam (ExamID), 
	FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

#truncate Department;
#elect * from Department; #show content in a table
#select * from Position; 
#desc EmployeeAccount; #show content in a table in descending order
#show tables;
#INSERT INTO EmployeeAccount (PositionID)  SELECT PositionID FROM Position; #put PositionID into EmployeeAccount