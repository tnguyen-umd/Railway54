-- =============================================
-- Create Structure database
-- =============================================

-- Drop the database if it already exists
DROP DATABASE IF EXISTS JavaExam;
-- Create database
CREATE DATABASE IF NOT EXISTS JavaExam;
USE JavaExam;

-- Create table user
DROP TABLE IF EXISTS 	`User`;
CREATE TABLE IF NOT EXISTS `User` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	name	 	CHAR(50) NOT NULL,
	`email` 		CHAR(50),
	`password` 		VARCHAR(800) default '123456',
    ExpInYear		smallint unsigned default 0,
    ProSkill		char(50)

);