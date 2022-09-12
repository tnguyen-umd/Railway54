package TestingSystem_Assignment_5;

import java.util.ArrayList;
import java.util.List;

///Exercise 2: Polymorphism
//Question 1: Interface Management
//Tạo 1 class Student gồm các property id, name, group(int)

//Tạo 1 interface IStudent bao gồm các method : điểmDanh(), họcBài(), đi dọn vệ sinh()

//Class Student sẽ implement interface như sau:
//Method điểm danh() sẽ in ra nội dung như sau: 
//"Nguyễn Văn A điểm danh"
//"Nguyễn Văn B điểm danh"
//"Nguyễn Văn C điểm danh"
//….
//Method học Bài () sẽ in ra nội dung như sau: 
//"Nguyễn Văn A đang học bài"
//"Nguyễn Văn B đang học bài "
//"Nguyễn Văn C đang học bài "
//…
//Tương tự với các method còn lại
//Hãy viết chương trình thực hiện các lệnh sau:
//a) Tạo 10 học sinh, chia thành 3 nhóm 
//b) Kêu gọi cả lớp điểm danh.
//c) Gọi nhóm 1 đi học bài
//d) Gọi nhóm 2 đi dọn vệ sinh

//Question 3: This & Super, Overriding
//Tạo 1 class HinhChuNhat có 2 method: tính chu vi và tính diện tích. 
//Hãy implement 2 method này.
//Tiếp theo hãy tạo 1 class HinhVuong extends HinhChuNhat, có 2 
//method tính chu vi và tính diện tích
//Chú ý:
//Không implement method trong class HinhVuong theo công 
//thức tính diện tích, chu vi hình vuông mà sẽ gọi theo 
//HinhChuNhat.tinhChuVi(), HinhChuNhat.tinhDienTich() )
//Và trong mỗi method print thêm dòng "Tính diện tích/ chu vi 
//theo Hình Vuông/ Hình Chữ Nhật"
//Question 4 (Optional): 
//Tạo 1 class MyMath có method sum có 2 parameter (có thể là int, có 
//thể là byte, có thể là float), sau đó trả về tổng của 2 số đó. Hãy viết 
//chương trình demo.
public class Assignment_5_Exercise_2_Program {
	public static void main(String[] args) {
		Student student1 = new Student(1, "Mr. A", 1);
		Student student2 = new Student(2, "Mr. B", 1);
		Student student3 = new Student(3, "Mr. C", 1);
		Student student4 = new Student(4, "Mr. D", 2);
		Student student5 = new Student(5, "Mr. E", 2);
		Student student6 = new Student(6, "Mr. F", 2);
		Student student7 = new Student(7, "Mr. G", 3);
		Student student8 = new Student(8, "Mr. H", 3);
		Student student9 = new Student(9, "Mr. I", 3);
		Student student10 = new Student(10, "Mr. K", 3);

		List<Student> allStudents = new ArrayList<>();
		allStudents.add(student1);
		allStudents.add(student2);
		allStudents.add(student3);
		allStudents.add(student4);
		allStudents.add(student5);
		allStudents.add(student6);
		allStudents.add(student7);
		allStudents.add(student8);
		allStudents.add(student9);
		allStudents.add(student10);
		for (int i = 0; i < allStudents.size(); i++) {
			allStudents.get(i).diemDanh();

		}

		List<Student> g1 = new ArrayList<>();
		g1.add(student1);
		g1.add(student2);
		g1.add(student3);
		g1.add(student4);
		g1.add(student5);

		for (int i = 0; i < g1.size(); i++) {
			g1.get(i).hocBai();

		}

		List<Student> g2 = new ArrayList<>();
		g2.add(student6);
		g2.add(student7);
		g2.add(student8);
		g2.add(student9);
		g2.add(student10);
		for (int i = 0; i < g2.size(); i++) {
			g2.get(i).veSinh();

		}

	}

}

//Question 5 (Optional): 

//Dien thoai: call(), listen(), sendMessage(), receiveMessage(), weapon();
//nghe và gọi điện thoại, gửi và nhận tin nhắn văn bản. 
//đều có thể sử dụng làm vũ khí

//Riêng điện thoại thông minh thì có thêm các chức năng: sử dụng 3G, chụp hình. 
// 3G(), takePhoto();
//Điện thoại cổ điển có sẵn chức năng nghe đài radio: listenRadio();
//Hãy thiết kế các class, interface, method
