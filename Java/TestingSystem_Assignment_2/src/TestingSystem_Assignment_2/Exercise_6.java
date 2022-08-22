package TestingSystem_Assignment_2;


/*
 * Chú ý: Tạo 1 Project đặt tên là "TestingSystem_Assignment_2", tách mỗi
 * exercise thành 1 class riêng, mỗi Question tách thành 1 method
 */

//Exercise 6 (Optional): Method
//Question 1:
//Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
//Question 2:
//Tạo method để in thông tin các account
//Question 3:
//Tạo method để in ra các số nguyên dương nhỏ hơn 10

//PRINT INTERGER SMALLER THAN 10
public class Exercise_6 {

	public static void  printNumber(int a) {
		for (int i = 0; i <a; i++) {
			System.out.println(i);
		}
		
	}
	
	public static void main(String[] args)  {
		
		printNumber(10);
		
		
	}

}



Exercise 2 (Optional): System out printf
Question 1: 
	Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số 
	nguyên đó
Question 2: 
	Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in 
	ra số nguyên đó thành định dạng như sau: 100,000,000
Question 3: 
	Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số 
	thực đó chỉ bao gồm 4 số đằng sau
Question 4: 
	Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định 
	dạng như sau:
	Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau: 
	Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
Question 5:
	Lấy thời gian bây giờ và in ra theo định dạng sau:
	24/04/2020 11h:16p:20s 
Question 6:
	In ra thông tin account (như Question 8 phần FOREACH) theo định dạng 
	table (giống trong Database)
	Exercise 3 (Optional): Date Format
Question 1: 
	In ra thông tin Exam thứ 1 và property create date sẽ được format theo định 
	dạng vietnamese
	Question 2: 
	In ra thông tin: Exam đã tạo ngày nào theo định dạng 
	Năm – tháng – ngày – giờ – phút – giây
Question 3: 
	Chỉ in ra năm của create date property trong Question 2
	4
	Question 4: 
	Chỉ in ra tháng và năm của create date property trong Question 2
	Question 5: 
	Chỉ in ra "MM-DD" của create date trong Question 2
	Exercise 4 (Optional): Random Number
	Question 1: 
	In ngẫu nhiên ra 1 số nguyên
	Question 2: 
	In ngẫu nhiên ra 1 số thực 
	Question 3: 
	Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên 
	ra tên của 1 bạn
	Question 4:
	Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-
	1995
	Question 5:
	Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
	Question 6:
	Lấy ngẫu nhiên 1 ngày trong quá khứ
	Question 7:
	Lấy ngẫu nhiên 1 số có 3 chữ số
	Exercise 5: Input from console
	Question 1: 
	Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
	Question 2: 
	Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
	Question 3: 
	Viết lệnh cho phép người dùng nhập họ và tên
	Question 4: 
	Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
	Question 5: 
	Viết lệnh cho phép người dùng tạo account (viết thành method)
	Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào 
	chương trình sẽ chuyển thành Position.Dev, Position.Test, 
	Position.ScrumMaster, Position.PM
5
Question 6: 
	
Viết lệnh cho phép người dùng tạo department (viết thành method)
Question 7: 
	Nhập số chẵn từ console
	Question 8: 
	Viết chương trình thực hiện theo flow sau:
	Bước 1: 
	Chương trình in ra text "mời bạn nhập vào chức năng muốn sử 
	dụng"
	Bước 2: 
	Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
	Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo 
	department
	Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập 
	lại" và quay trở lại bước 1
Question 9: 
Viết method cho phép người dùng thêm group vào account theo flow sau:
	Bước 1: 
	In ra tên các usernames của user cho người dùng xem
	Bước 2: 
	Yêu cầu người dùng nhập vào username của account
	Bước 3: 
	In ra tên các group cho người dùng xem
	Bước 4: 
	Yêu cầu người dùng nhập vào tên của group
	Bước 5: 
	Dựa vào username và tên của group người dùng vừa chọn, hãy 
	thêm account vào group đó .
Question 10: Tiếp tục Question 8 và Question 9
	Bổ sung thêm vào bước 2 của Question 8 như sau:
	Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào 
	account 
	Bổ sung thêm Bước 3 của Question 8 như sau: 
	Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng 
	text để hỏi người dùng "Bạn có muốn thực hiện chức năng khác 
	không?". Nếu người dùng chọn "Có" thì quay lại bước 1, nếu người 
	dùng chọn "Không" thì kết thúc chương trình (sử dụng lệnh return để 
	kết thúc chương trình)
Question 11: Tiếp tục Question 10
	Bổ sung thêm vào bước 2 của Question 8 như sau:
	Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account 
	vào 1 nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau:
	Bước 1: 
	In ra tên các usernames của user cho người dùng xem
	6
	Bước 2: 
	Yêu cầu người dùng nhập vào username của account
	Bước 3: 
	Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
	Bước 4: 
	Thêm account vào group chương trình vừa chọn ngẫu nhiên

