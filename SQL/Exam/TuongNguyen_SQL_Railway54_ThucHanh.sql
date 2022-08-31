-- ======================RAILWAY 54 - ThucTap======================
DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;
USE ThucTap;

-- ============= Create Table GiangVien =============================
DROP TABLE IF EXISTS GiangVien;
CREATE TABLE GiangVien(
	magv  					INT PRIMARY KEY AUTO_INCREMENT,
    hoten					VARCHAR(200) NOT NULL,
    luong					BIGINT
);

-- ============= Create Table SinhVien =============================
DROP TABLE IF EXISTS SinhVien;
CREATE TABLE SinhVien(
	masv  					INT PRIMARY KEY AUTO_INCREMENT,
    hoten					VARCHAR(200) NOT NULL,
    namsinh					DATETIME, 
    quequan					VARCHAR(200)
);

-- ============= Create Table DeTai =============================
DROP TABLE IF EXISTS DeTai;
CREATE TABLE DeTai(
	madt  					INT PRIMARY KEY AUTO_INCREMENT,
    tendt					VARCHAR(200) NOT NULL,
    kinhphi					BIGINT,
    NoiThucTap				VARCHAR(200)
);

-- ============= Create Table HuongDan =============================
DROP TABLE IF EXISTS HuongDan;
CREATE TABLE HuongDan(
	id				INT PRIMARY KEY AUTO_INCREMENT,
	masv					INT,
    madt					INT,
	magv					INT,
    ketqua					VARCHAR(300),
    
    FOREIGN KEY (masv) 			REFERENCES SinhVien(masv) ON DELETE CASCADE,
    FOREIGN KEY (madt) 			REFERENCES DeTai(madt),
	FOREIGN KEY (magv) 			REFERENCES GiangVien(magv)
);


-- ============= INSERT DATA =============================
INSERT INTO `thuctap`.`giangvien` (`hoten`, `luong`) VALUES ('Nguyen Van A', '5000000');
INSERT INTO `thuctap`.`giangvien` (`hoten`, `luong`) VALUES ('Nguyen Van B', '5000000');
INSERT INTO `thuctap`.`giangvien` (`hoten`, `luong`) VALUES ('Nguyen Van C', '10000000');

INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('Mr. A', '1998-12-21', 'Hanoi');
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('Mr. B', '2000-1-15', 'Saigon');
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('Mr. C', '2000-5-3', 'Can Tho');
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('Mr. D', '1999-11-21', 'Binh Duong');

INSERT INTO `thuctap`.`detai` (`tendt`, `kinhphi`, `NoiThucTap`) VALUES ('Cong nghe sinh hoc', '1000000', 'Hanoi');
INSERT INTO `thuctap`.`detai` (`tendt`, `kinhphi`, `NoiThucTap`) VALUES ('Hoc Ruby', '2000000', 'Hanoi');
INSERT INTO `thuctap`.`detai` (`tendt`, `kinhphi`, `NoiThucTap`) VALUES ('Hoc C3', '3000000', 'TPHCM');

INSERT INTO `thuctap`.`huongdan` (`masv`, `madt`, `magv`, `ketqua`) VALUES ('1', '1', '1', 'Lam xong');
INSERT INTO `thuctap`.`huongdan` (`masv`, `madt`, `magv`, `ketqua`) VALUES ('2', '2', '1', 'Chua lam xong');
INSERT INTO `thuctap`.`huongdan` (`masv`, `madt`, `magv`, `ketqua`) VALUES ('3', '3', '2', 'Lam xong');
INSERT INTO `thuctap`.`huongdan` (`masv`, `ketqua`) VALUES ('4', 'Chua lam');
INSERT INTO `thuctap`.`huongdan` (`masv`, `madt`, `magv`, `ketqua`) VALUES ('2', '1', '1', 'Lam xong');


-- ============================================================================================================================================================================================================================
-- =============LAM BAI============================================
#2Question . Viết lệnh để
#a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT B.hoten, A.madt
FROM huongdan A
LEFT JOIN sinhvien B
ON A.masv=B.masv
WHERE A.madt IS NULL;

#Question 2. Viết lệnh để #b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’
SELECT COUNT(A.tendt) AS SO_SINH_VIEN
FROM detai A
INNER JOIN huongdan B
ON A.madt=B.madt
WHERE A.tendt='Cong nghe sinh hoc';

#Question 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm: 
#mã số, họ tên và tên đề tài
#(Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")

DROP VIEW IF EXISTS SinhVienInfo;
CREATE VIEW SinhVienInfo AS
	SELECT A.masv, A.hoten,B.madt,CASE WHEN C.tendt IS NULL THEN 'Chưa có'
            ELSE C.tendt END AS Ten_de_tai
	FROM sinhvien A
	LEFT JOIN huongdan B
	ON A.masv=B.masv
	LEFT JOIN detai C
	ON C.madt=B.madt;
    
SELECT * FROM SinhVienInfo;

#Question 4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900 
#thì hiện ra thông báo "năm sinh phải > 1900"
DROP TRIGGER IF EXISTS check_nam_sinh;
DELIMITER $$
	CREATE TRIGGER check_nam_sinh
    BEFORE INSERT ON sinhvien
    FOR EACH ROW
    BEGIN
		IF(YEAR(NEW.namsinh) <= YEAR('1900-1-1'))
        THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'năm sinh phải > 1900';
        END IF;
    END $$
DELIMITER ;
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('Mr. e', '1899-12-21', 'Hanoi');

Show TRIGGERS FROM ThucTap;

#Question 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông 
#tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi

#dung ON DELETE CASCADE trong table huongdan
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `quequan`) VALUES ('mr. E', 'Hanoi');
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `quequan`) VALUES ('Mr. F', 'Hanoi');

INSERT INTO `thuctap`.`huongdan` (`masv`, `madt`, `magv`, `ketqua`) VALUES ('10', '1', '1', 'Lam xong');
DELETE FROM `thuctap`.`sinhvien` WHERE (`hoten` = 'Mr. F');



