USE GiaoHang;
INSERT INTO loai_mat_hang(LoaiMatHangID,TenMatHang) 
VALUES
			('MH001','Quan ao' ),
			('MH002','My pham' ),
            ('MH003','Do gia dung' ),
            ('MH004','Do dien tu' );
            
#            select * from loai_mat_hang;
			
INSERT INTO Khoang_Thoi_Gian(KhoangThoiGianID,MoTa) 
VALUES
			('TG001','7h-9h AM' ),
			('TG002','9h-11h AM' ),
            ('TG003','1h-3h PM' ),
            ('TG004','3h-5h PM' ),
            ('TG005','7h-9h30 PM' );
            
#            select * from Khoang_Thoi_Gian;


INSERT INTO Khu_Vuc(KhuVucID,TenKhuVuc) 
VALUES
			('KV001','Son Tra' ),
			('KV002','Lien Chieu' ),
            ('KV003','Ngu Hanh Son' ),
            ('KV004','Hai Chau' ),
            ('KV005','Thanh Khe' );
            
#            select * from Khu_Vuc;           

INSERT INTO Dich_Vu(DichVuID,TenDichVu) 
VALUES
			('DV001','Giao hang nguoi nhan tra tien phi' ),
			('DV002','Giao hang nguoi gui tra tien phi' ),
            ('DV003','Giao hang cong ich(khong tinh phi)' );
            
#            select * from Dich_Vu;       

INSERT INTO Thanh_Vien_Giao_Hang(ThanhVienGiaoHangID , TenThanhVienGiaoHang, NgaySinh , GioiTinh , DienThoaiThanhVien, DiaChiThanhVien)
VALUES 		('TV0001' , 'Nguyen Van A' ,'1995-11-20' , 'Male' , '0905111111','23 Ong Ich Khiem'),
			('TV0002' , 'Nguyen Van B' ,'1992-12-26' , 'Female' , '0905111112','234 Ton Duc Thang'),
            ('TV0003' , 'Nguyen Van C' ,'1990-11-30' , 'Female' , '0905111113','245 Hoang Dieu'),
            ('TV0004' , 'Nguyen Van D' ,'1995-7-8' , 'Male' , '0905111114','23/33 Ngu Hanh Son'),
            ('TV0005' , 'Nguyen Van E' ,'1991-2-4' , 'Male' , '0905111115','56 Dinh Thi Dieu');
            
#select * from Thanh_Vien_Giao_Hang;

INSERT INTO Dang_Ky_Giao_Hang(ThanhVienGiaoHangID,KhoangThoiGianDKGiaoHangID) 
VALUES
			('TV0001','TG004' ),
			('TV0002','TG005' ),
            ('TV0003','TG001' ),
            ('TV0003','TG002' ),
            ('TV0003','TG003' );
            
 #           select * from Dang_Ky_Giao_Hang; 
            
INSERT INTO Khach_Hang(KhachHangID,KhuVucID,TenKhachHang,TenCuaHang,SoDTKhachHang,Email,DiaChiNhanHang)
VALUES
('KH001','KV001','Le Thi A', 'Cua Hang 1',0905111111,'alethi@gmail.com','80 Pham Phu Thai'),
('KH002','KV001','Nguyen Van B', 'Cua Hang 2',0905111112,'bnguyenvan@gmail.com','100 Phan Tu'),
('KH003','KV002','Le Thi B', 'Cua Hang 3',0905111113,'blethi@gmail.com','23 An Thuong 18'),
('KH004','KV002','Nguyen Van C', 'Cua Hang 4',0905111114,'cnguyenvan@gmail.com','60 Ngo The Thai'),
('KH005','KV001','Le Thi D', 'Cua Hang 5',0905111115,'dlethi@gmail.com','100 Chau Thi Vinh Te');

#select * from Khach_Hang; 
            
INSERT INTO Don_Hang_Giao_Hang(DonHangGiaoHangID,KhachHangID,ThanhVienGiaoHangID,DichVuID,KhuVucGiaoHangID,TenNguoiNhan,DiaChiGiaoHang,
DTNguoiNhan,KhoangThoiGianGiaoHangID,NgayGiaoHang,PhuongThucThanhToan,TrangThaiPheDuyet,TrangThaiGiaoHang)
VALUES
('DH0001','KH001','TV0001', 'DV001','KV001','Pham Van A','30 Hoang Van Thu',0905111111,'TG004','2016-10-10','Cash','Approved', 'Delivered'),
('DH0002','KH002','TV0002', 'DV001','KV005','Pham Van B','15 Le Dinh Ly',0905111112,'TG005','2016-12-23','Cash','Approved', 'Not Delivered'),
('DH0003','KH003','TV0003', 'DV001','KV005','Pham Van C','23 Le Dinh Duong',0905111113,'TG001','2017-4-8','Cash','Approved', 'Delivered'),
('DH0004','KH004','TV0001', 'DV003','KV002','Pham Van D','45 Pham Phu Thai',0905111114,'TG002','2015-10-11','Online','Approved', 'Delivered'),
('DH0005','KH005','TV0005', 'DV003','KV003','Pham Van E','78 Hoang Dieu',0905111115,'TG003','2017-4-4','Online','Rejected', NULL);

#select * from Don_Hang_Giao_Hang; 

INSERT INTO Chi_Tiet_Don_Hang(DonHangGIaoHangID,TenSanPhamDuocGiao,SoLuong,TrongLuong,LoaiMatHangID,TienThuHo)
VALUES
('DH0001','Ao Len',2, 0.5,'MH001',200000),
('DH0001','Quan Au',1, 0.25,'MH001',350000),
('DH0002','Ao Thun',1, 0.25,'MH001',1000000),
('DH0002','Ao Khoac',3, 0.25,'MH001',2000000),
('DH0003','Sua duong the',2, 0.25,'MH003',780000),
('DH0003','Kem tay da chet',3, 0.5,'MH003',150000),
('DH0003','Kem duong ban dem',4, 0.25,'MH003',900000);
#select * from Chi_Tiet_Don_Hang; 

