DROP DATABASE IF EXISTS Fresher;
CREATE DATABASE Fresher;

DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee(
TraineeID			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Fullname			VARCHAR(50),
Gender 				ENUM('male','female', 'unknown') DEFAULT 'unknown',
ET_IQ				INT CHECK(0<=ET_IQ<=20)
);

 ET_IQ: Entry test point (IQ) - Điểm test đầu vào của thực tập sinh (integer có 
giá trị từ 0  20)
 ET_Gmath: Entry test point (Gmath) - Điểm test đầu vào của thực tập sinh 
(integer có giá trị từ 0  20)
 ET_English: Entry test point (English) - Điểm test đầu vào của thực tập sinh 
(integer có giá trị từ 0  50)
 Training_Class: mã lớp của thực tập sinh đang học 
 Evaluation_Notes: 1 vài note đánh giá (free text).