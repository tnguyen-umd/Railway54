USE GiaoHang;

#Câu 1: Xóa những khách hàng có tên là “Le Thi A”.
DELETE FROM khach_hang
WHERE TenKhachHang='Le Thi A';

#Câu 2: Cập nhật những khách hàng đang thường trú ở khu vực “Son Tra” thành khu vực “Ngu Hanh Son”.
UPDATE khach_hang A 
INNER JOIN khu_vuc B
ON A.KhuVucID=B.KhuVucID
SET A.KhuVucID='KV003'
WHERE A.KhuVucID='KV001';
SELECT * FROM khach_hang;

#Truy Vấn
#Câu 3: Liệt kê những thành viên (shipper) có họ tên bắt đầu là ký tự ‘Tr’ và có độ dài ít nhất là
	#25 ký tự (kể cả ký tự trắng).
SELECT *
FROM thanh_vien_giao_hang
WHERE TenThanhVienGiaoHang LIKE ('Ng%') AND length(TenThanhVienGiaoHang)>=10;

#Câu 4: Liệt kê những đơn hàng có don_hang_giao_hang.NgayGiaoHang nằm trong năm 2017 và có khu vực giao
	#hàng là “Hai Chau”.
SELECT a.DonHangGiaoHangID, A.KhachHangID
FROM don_hang_giao_hang A
INNER JOIN Khu_Vuc B
ON A.KhuVucGiaoHangID=B.khuvucID
WHERE YEAR(A.NgayGiaoHang)=2017 AND B.TenKhuVuc='Hai Chau';

#Câu 5: Liệt kê MaDonHangGiaoHang, MaThanhVienGiaoHang, TenThanhVienGiaoHang,
	#NgayGiaoHang, PhuongThucThanhToan của tất cả những đơn hàng có trạng thái là “Da giao
	#hang”. Kết quả hiển thị được sắp xếp tăng dần theo NgayGiaoHang và giảm dần theo
	#PhuongThucThanhToan
SELECT A.DonHangGiaoHangID,A.ThanhVienGiaoHangID,B.TenThanhVienGiaoHang,A.NgayGiaoHang,A.PhuongThucThanhToan
FROM don_hang_giao_hang A
INNER JOIN thanh_vien_giao_hang B
ON A.ThanhVienGiaoHangID=B.ThanhVienGiaoHangID
WHERE TrangThaiGiaoHang='Delivered'
ORDER BY NgayGiaoHang ASC, PhuongThucThanhToan DESC;

#Câu 6: Liệt kê những thành viên có giới tính là “Nam” và chưa từng được giao hàng lần nào.
SELECT B.TenThanhVienGiaoHang
FROM don_hang_giao_hang A
INNER JOIN thanh_vien_giao_hang B
ON A.ThanhVienGiaoHangID=B.ThanhVienGiaoHangID
WHERE B.GioiTinh='male' AND A.TrangThaiGiaoHang='Not Delivered';

#Câu 7: Liệt kê họ tên của những khách hàng đang có trong hệ thống. Nếu họ tên trùng nhau
#thì chỉ hiển thị 1 lần. Học viên cần thực hiện yêu cầu này bằng 2 cách khác nhau (mỗi cách được tính 0.5 điểm)
SELECT DISTINCT TenKhachHang
FROM khach_hang;

SELECT TenKhachHang
FROM khach_hang
GROUP BY TenKhachHang;

#Câu 8: Liệt kê MaKhachHang, TenKhachHang, DiaChiNhanHang, MaDonHangGiaoHang,
	#PhuongThucThanhToan, TrangThaiGiaoHang của tất cả các khách hàng đang có trong hệ thống
SELECT B.KhachHangID,B.TenKhachHang,B.DiaChiNhanHang,DonHangGiaoHangID,PhuongThucThanhToan,TrangThaiGiaoHang
FROM don_hang_giao_hang A
INNER JOIN Khach_hang B
ON A.KhachHangID=B.KhachHangID;

#Câu 9: Liệt kê những thành viên giao hàng có giới tính là “Nu” và từng giao hàng cho 10
	#khách hàng khác nhau ở khu vực giao hàng là “Hai Chau” 
SELECT B.TenThanhVienGiaoHang
FROM don_hang_giao_hang A
INNER JOIN thanh_vien_giao_hang B
ON A.ThanhVienGiaoHangID=B.ThanhVienGiaoHangID
INNER JOIN khu_vuc C
ON A.KhuVucGiaoHangID=C.KhuVucID
WHERE B.GioiTinh ='female' AND C.TenKhuVuc='Hai Chau' # THIS IS HOW TO USE WHERE + HAVING IN THE SAME QUERY
GROUP BY A.TrangThaiGiaoHang
HAVING COUNT(A.TrangThaiGiaoHang)>=10;
   
#Câu 10: Liệt kê những 
		#khack_hang.TenKhachHang đã từng yêu cầu giao hàng tại 
		#khu_vực.TenKhuVuc= “Lien Chieu” và
		#chưa từng được một thành viên giao hàng nào có giới tính là “Nam” nhận giao hàng
        #thanh_vien_giao_hang.GioiTinh=! 'male'
SELECT D.TenKhachHang
FROM don_hang_giao_hang A
	INNER JOIN thanh_vien_giao_hang B
	ON A.ThanhVienGiaoHangID=B.ThanhVienGiaoHangID
    
	INNER JOIN khu_vuc C
	ON A.KhuVucGiaoHangID=C.KhuVucID
    
    INNER JOIN khach_hang D
    ON A.KhachHangID=D.KhachHangID
    
WHERE C.TenKhuVuc='Lien Chieu'
AND B.GioiTinh !='male' ;