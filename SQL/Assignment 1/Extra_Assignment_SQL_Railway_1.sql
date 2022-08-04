-- CREATE DATABASE ThucTap
DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE IF NOT EXISTS ThucTap;
USE ThucTap;

-- CREATE TABLE Khoa
DROP TABLE IF EXISTS Khoa;
CREATE TABLE Khoa(
makhoa char(10) PRIMARY KEY, 
tenkhoa char(30), 
dienthoai char(10)
    );

INSERT INTO `Khoa`(makhoa,tenkhoa, dienthoai)
VALUES 		
		('MK1','DIA LY' ,'0981112052'),
		('MK2','QLTN' ,'0981112343'),
		('MK3','LICH SU' ,'0981111111'),
		('MK4','ENGLISH' ,'0981112222'),
		('MK5','TOAN' ,'0981113333'),
		('MK6','VAT LY' ,'0981114444');
 
-- CREATE TABLE GiangVien
DROP TABLE IF EXISTS GiangVien;
CREATE TABLE GiangVien(
magv int AUTO_INCREMENT PRIMARY KEY, 
hotengv char(30), 
luong decimal(5,2), 
makhoa char(10),
FOREIGN KEY (makhoa) REFERENCES Khoa(makhoa) ON DELETE CASCADE
    );

INSERT INTO `GiangVien`(hotengv,luong, makhoa)
VALUES 		
		('Giao Vien A','1.5', 'MK1'),
		('Giao Vien B','2.4', 'MK1'),
		('Giao Vien C','2.5', 'MK2'),  
		('Giao Vien D','2.8', 'MK2'),
		('Giao Vien E','3.5', 'MK3'),     
		('Giao Vien F','4.5', 'MK4');
        
-- CREATE TABLE SinhVien
DROP TABLE IF EXISTS SinhVien;
CREATE TABLE SinhVien(
masv int AUTO_INCREMENT PRIMARY KEY, 
hotensv char(30), 
makhoa char(10), 
namsinh int, 
quequan char(30),
FOREIGN KEY (makhoa) REFERENCES Khoa(makhoa) ON DELETE CASCADE
);

INSERT INTO `SinhVien`(hotensv,namsinh, makhoa, quequan)
VALUES 		
		('Sinh Vien A1','2012', 'MK1', 'Hanoi'),
		('Sinh Vien B2','2019', 'MK1','Thaibinh'),
		('Sinh Vien C1','2018', 'MK2','Danang'),  
		('Sinh Vien D3','2013', 'MK2','Hanoi'),
		('Sinh Vien E4','2012', 'MK3','Hanoi'),     
		('Sinh Vien F4','2011', 'MK4','Hanoi');

-- CREATE TABLE DeTai
DROP TABLE IF EXISTS DeTai;
CREATE TABLE DeTai(
madt char(10) PRIMARY KEY, 
tendt char(30) DEFAULT 'Unknown', 
kinhphi int DEFAULT 20, 
NoiThucTap char(30));

INSERT INTO `DeTai`(madt,tendt, kinhphi, NoiThucTap)
VALUES 		
		('A1','unknown1', '25', 'HCM'),
		('A2','unknown1', '25','HCM'),
		('A3','unknown2', '20','Danang'),  
		('A4','unknown2', '20','Hanoi'),
		('A5','unknown1', '30','Hanoi'),     
		('A6','unknown1', '30','Hanoi');

-- CREATE TABLE HuongDan
DROP TABLE IF EXISTS HuongDan;
CREATE TABLE HuongDan(
masv int PRIMARY KEY, 
madt char(10), 
magv int,
FOREIGN KEY (magv) REFERENCES GiangVien(magv) ON DELETE CASCADE, 
FOREIGN KEY (madt) REFERENCES DeTai(madt) ON DELETE CASCADE,
ketqua decimal(5,2));

INSERT INTO `HuongDan`(masv,madt, magv, ketqua)
VALUES 		
		('1','A1', '1', '10'),
		('2','A1', '2','9'),
		('3','A2', '1','8'),  
		('4','A2', '3','7'),
		('5','A3', '2','6'),     
		('6','A3', '1','5');

#Tạo table và thêm data cho table


#Đưa ra thông tin gồm mã số, họ tênvà tên khoa của tất cả các giảng viên
#Đưa ra thông tin gồm mã số, họ tên và tên khoa của các giảng viên của khoa ‘DIA LY va QLTN’
#Cho biết số sinh viên của khoa ‘CONG NGHE SINH HOC’
#Đưa ra danh sách gồm mã số, họ tênvà tuổi của các sinh viên khoa ‘TOAN’
#Cho biết số giảng viên của khoa ‘CONG NGHE SINH HOC’
#Cho biết thông tin về sinh viên không tham gia thực tập
#Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa
#Cho biết số điện thoại của khoa mà sinh viên có tên ‘Le van son’ đang theo học

#Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn
#Cho biết tên đề tài không có sinh viên nào thực tập
#Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên.
#Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất
#Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập
#Đưa ra mã số, họ tên và điểm của các sinh viên khoa ‘DIALY và QLTN’
#Đưa ra tên khoa, số lượng sinh viên của mỗi khoa
#Cho biết thông tin về các sinh viên thực tập tại quê nhà
#Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập
#Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0

