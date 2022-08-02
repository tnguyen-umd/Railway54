-- CREATE DATABASE Fresher
DROP DATABASE IF EXISTS Fresher;
CREATE DATABASE IF NOT EXISTS Fresher;
USE Fresher;

-- CREATE TABLE Trainee
DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee(
	TraineeID INT AUTO_INCREMENT PRIMARY KEY,
	Full_Name VARCHAR(50) NOT NULL UNIQUE,
    Birth_Date DATE NOT NULL,
    Gender ENUM('Male','Female','Unknown'),
    ET_IQ INT CHECK (ET_IQ BETWEEN 0 AND 20), 
    ET_Gmath INT CHECK (ET_Gmath BETWEEN 0 AND 20), 
	ET_English INT CHECK (ET_English BETWEEN 0 AND 50), 
    Training_Class VARCHAR(50) NOT NULL,
    Evaluation_Notes TEXT NOT NULL
    
    );
    
-- ADD VTI_Account to Table Trainee
ALTER TABLE Trainee ADD	VTI_Account VARCHAR(20) UNIQUE NOT NULL;

-- CREATE TABLE Exercise2
DROP TABLE IF EXISTS Exercise2;
CREATE TABLE Exercise2(
	ID MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
	Ex_Name VARCHAR(50) NOT NULL,
    Ex_Code char(5),
	ModifiedDate datetime 
    );

-- CREATE TABLE Exercise3
DROP TABLE IF EXISTS Exercise3;
CREATE TABLE Exercise3(
	ID MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
	Ex_Name VARCHAR(50) NOT NULL,
    Birth_Date date,
    Gender TINYINT CHECK (Gender BETWEEN 0 AND 1), -- 0 là Male, 1 là Female, NULL là Unknown
    IsDeletedFlag TINYINT CHECK (IsDeletedFlag BETWEEN 0 AND 1)-- 0 là đang hoạt động, 1 là đã xóa.
    );




