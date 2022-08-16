-- CREATE DATABASE GiaoHang
DROP DATABASE IF EXISTS GiaoHang;
CREATE DATABASE IF NOT EXISTS GiaoHang;
USE GiaoHang;

-- CREATE TABLE Loai_Mat_Hang
DROP TABLE IF EXISTS Loai_Mat_Hang;
CREATE TABLE Loai_Mat_Hang (
	LoaiMatHangID VARCHAR(200) PRIMARY KEY,
	TenMatHang NVARCHAR(50) UNIQUE KEY
    );
    
-- CREATE TABLE Khu_Vuc
DROP TABLE IF EXISTS Khu_Vuc;
CREATE TABLE Khu_Vuc (
	KhuVucID			CHAR(50) PRIMARY KEY,
    TenKhuVuc			NVARCHAR(100) NOT NULL
    );

   
    -- CREATE TABLE Dich_Vu
DROP TABLE IF EXISTS Dich_Vu;
CREATE TABLE Dich_Vu (
	DichVuID			CHAR(10) PRIMARY KEY,
    TenDichVu			NVARCHAR(100) NOT NULL
    );

    -- CREATE TABLE Khoang_Thoi_Gian
DROP TABLE IF EXISTS Khoang_Thoi_Gian;
CREATE TABLE Khoang_Thoi_Gian (
	KhoangThoiGianID			CHAR(10) PRIMARY KEY,
    MoTa						NVARCHAR(100) NOT NULL
    );

  
-- CREATE TABLE Khach_Hang
DROP TABLE IF EXISTS Khach_Hang;
CREATE TABLE Khach_Hang (
	KhachHangID 		CHAR(100) PRIMARY KEY,
    KhuVucID 			CHAR(50) NOT NULL,
    TenKhachHang 		NVARCHAR(100) NOT NULL,
    TenCuaHang			NVARCHAR(100) NOT NULL,
    SoDTKhachHang		INT(10) NOT NULL,
    Email				VARCHAR(100) NOT NULL,
    DiaChiNhanHang		NVARCHAR(500) NOT NULL,
	FOREIGN KEY (KhuVucID) REFERENCES Khu_Vuc(KhuVucID) ON DELETE CASCADE
);

 -- CREATE TABLE Thanh_Vien_Giao_Hang
DROP TABLE IF EXISTS Thanh_Vien_Giao_Hang;
CREATE TABLE Thanh_Vien_Giao_Hang (
	ThanhVienGiaoHangID					CHAR(25) PRIMARY KEY,
    TenThanhVienGiaoHang				NVARCHAR(100) NOT NULL,
    NgaySinh							DATE NOT NULL,
    GioiTinh							ENUM('Male', 'Female', 'Unknown') DEFAULT('Unknown'),
	DienThoaiThanhVien					INT(10) DEFAULT(0000000000),
    DiaChiThanhVien						NVARCHAR(100)    
	);

-- CREATE TABLE Dang_Ky_Giao_Hang
DROP TABLE IF EXISTS Dang_Ky_Giao_Hang;
CREATE TABLE Dang_Ky_Giao_Hang (
	ID									INT AUTO_INCREMENT PRIMARY KEY,
    ThanhVienGiaoHangID					CHAR(25) NOT NULL,
    KhoangThoiGianDKGiaoHangID			CHAR(10) NOT NULL,
	FOREIGN KEY (KhoangThoiGianDKGiaoHangID) 
		REFERENCES Khoang_Thoi_Gian(KhoangThoiGianID) ON DELETE CASCADE,
    FOREIGN KEY (ThanhVienGiaoHangID) 
		REFERENCES Thanh_Vien_Giao_Hang(ThanhVienGiaoHangID) ON DELETE CASCADE
    );

-- CREATE TABLE Chi_Tiet_Don_Hang
DROP TABLE IF EXISTS `Chi_Tiet_Don_Hang`;
CREATE TABLE `Chi_Tiet_Don_Hang` (
	DonHangGiaoHangID 			CHAR(100),
	TenSanPhamDuocGiao 			VARCHAR(50),
    SoLuong						INT UNSIGNED,
    TrongLuong					Decimal(10,2),
    LoaiMatHangID				VARCHAR(200),
    TienThuHo					INT UNSIGNED,
    FOREIGN KEY (LoaiMatHangID) REFERENCES Loai_Mat_Hang(LoaiMatHangID) ON DELETE CASCADE,
    PRIMARY KEY(DonHangGiaoHangID,TenSanPhamDuocGiao)
);
                
-- CREATE TABLE `Don_Hang_Giao_Hang`
DROP TABLE IF EXISTS `Don_Hang_Giao_Hang`;
CREATE TABLE IF NOT EXISTS `Don_Hang_Giao_Hang` (
	DonHangGiaoHangID 		CHAR(100) PRIMARY KEY,
	KhachHangID		 		CHAR(100),
		FOREIGN KEY (KhachHangID) REFERENCES Khach_Hang(KhachHangID) ON DELETE CASCADE,
    ThanhVienGiaoHangID		CHAR(25),
	FOREIGN KEY (ThanhVienGiaoHangID) REFERENCES Thanh_Vien_Giao_Hang(ThanhVienGiaoHangID) ON DELETE CASCADE,
	DichVuID				CHAR(10),
		FOREIGN KEY (DichVuID) REFERENCES Dich_Vu(DichVuID) ON DELETE CASCADE,
	KhuVucGiaoHangID				CHAR(50),
		FOREIGN KEY (KhuVucGiaoHangID) REFERENCES Khu_Vuc(KhuVucID) ON DELETE CASCADE,
	TenNguoiNhan			NVARCHAR(100),
    DiaChiGiaoHang			NVARCHAR(100),
    DTNguoiNhan				INT(10),
    KhoangThoiGianGiaoHangID	CHAR(10),
		FOREIGN KEY (KhoangThoiGianGiaoHangID) 
        REFERENCES Khoang_Thoi_Gian(KhoangThoiGianID) ON DELETE CASCADE,
	NgayGiaoHang			DATE DEFAULT(NOW()),
    PhuongThucThanhToan		ENUM('Cash','Card', 'Online') DEFAULT('Cash'),
    TrangThaiPheDuyet		ENUM('Approved', 'Rejected') DEFAULT ('Rejected'),
    TrangThaiGiaoHang		ENUM('Delivered', 'Not Delivered')
	);
