package com.vti.entity;

import java.io.Serializable;

import com.vti.backend.ScannerUtils;

//Exercise 1: Static
//Question 1: static variable 
//Khai báo 1 class student có các thuộc tính id, name, college
//Với college là static variable.
//Hãy khởi tạo các student sau:
//Student có id = 1, name ="Nguyễn Văn A"
//Student có id = 2, name = " Nguyễn Văn B "
//Student có id = 3, name = " Nguyễn Văn C "
//Và tất cả các student này đều học ở "Đại học bách khoa".
//Dùng vòng for để in ra thông tin các student
//Sau đó hãy chuyển các student này sang "Đại học công nghệ"
//Dùng vòng for để in ra thông tin các student

//Question 2: tiếp tục question 1
//Bổ sung thuộc tính moneyGroup cho Student (moneyGroup là tiền quỹ 
//lớp - dùng chung cho tất cả các student). 
//Hãy viết chương trình main() để mô tả các bước sau:
//B1: Các Student sẽ nộp quỹ, mỗi Student 100k
//B2: Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan
//B3: Student thứ 2 lấy 20k đi mua bánh mì
//B4: Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm
//B5: cả nhóm mỗi người lại đóng quỹ mỗi người 50k
//In ra số tiền còn của nhóm tại mỗi bước 

//Question 4: tiếp tục Question 1
//Trong class Student
//a) Viết method cho phép thay đổi college
//b) Viết method cho phép lấy giá trị của college 

//Question 5: 
//Hãy viết chương trình đếm số Student được sinh ra (tham khảo code 
//trên google)

//Question 6: tiếp tục Question 5
//Tạo class PrimaryStudent, SecondaryStudent, hãy viết chương trình 
//đếm số lượng PrimaryStudent được sinh ra, SecondaryStudent được 
//sinh ra.
//Viết chương trình demo.
//Khởi tạo 6 Student, trong đó có 2 PrimaryStudent và 4 
//SecondaryStudent, sau đó in ra số lượng Student, 
//PrimaryStudent, SecondaryStudent được sinh ra.

//Question 7: tiếp tục Question 6
//Chỉ cho phép user tạo được tối đa 7 học sinh 

//------NOT DOING THIS--------------
//Question 3: static method------------------------------------------
//a) Viết class MyMath để thay thế cho class Math của java.
//b) Viết thêm method min(), sum vào class MyMath
//-------------------------------------------------------------------

//Question 8: 
//Tạo class Configs có các static property
//SO_LUONG_HINH_TOI_DA = 5;
//Tạo class HinhHoc, và class HinhTron, HinhChuNhat sẽ kế thừa từ 
//class HinhHoc, implement method tính chu vi, diện tính
//Viết chương trình chỉ cho phép khởi tạo được tối đa 5 hình, nếu người 
//dùng khởi tạo tới hình thứ 6 thì sẽ throw ra 1 custom Exception có tên 
//là HinhHocException có message là: "Số lượng hình tối đa là: " + Configs. SO_LUONG_HINH_TOI_DA

//Question 9: 
//Thay đổi các method ở class ScannerUtils ở Assignment 6 thành static 
//để tiện dùng hơn

//Question 2:
//Tạo class Student có property id, name hãy thiết kế class Student sao 
//cho khi đã khởi tạo Student thì id là không thể thay đổi trong suốt quá 
//trình chạy chương trình chương trình

//Question 3: Tiếp tục Question 2 (final method)
//Student bắt buộc phải học bài, và việc học bài là như nhau đối với các 
//học sinh  ta viết method void study(), bên trong method ta sẽ in ra 
//text "Đang học bài…"
//Tiếp theo ta có các loại Student như sau: PrimaryStudent, 
//SecondaryStudent, và có thể còn có nhiều loại học sinh khác trong 
//tương lai, tất cả các student này đều kế thừa Student
//Hãy thiết kế chương trình để tất cả các học sinh đều có method study() 
//như nhau (nghĩa là PrimaryStudent, SecondaryStudent không thể 
//override được method study())

//Question 4: Tiếp tục Question 3 (final class)
//Hãy thiết kế chương trình sao cho không có class nào có thể kế thừa từ 
//PrimaryStudent, SecondaryStudent 

public class Student implements Serializable {

	private int id;
	private String name;
	private static String college;
	private static long moneyGroup;
	private static int counter;
	private static int maxStudentCount = 7;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getCollege() {
		return college;
	}

	public static void setCollege(String college) {
		Student.college = college;
	}

	public Student() throws Exception {
		ScannerUtils su = new ScannerUtils();

		if ((counter + PrimaryStudent.getPrimeCounter() + SecondaryStudent.getSecondCounter()) < maxStudentCount - 1) {
			System.out.print("Please input your id: ");
			this.id = su.inputInt("Wrong input, use integers only");
			System.out.print("Please input your name: ");
			this.name = su.inputString();
			college = "Đại học bách khoa";
			moneyGroup = 100000;
			counter++;
		} else {
			throw new Exception("**********Number of student cannot exceed " + maxStudentCount);
		}

	}

	public static long getMoneyGroup() {
		return moneyGroup;
	}

	public static void setMoneyGroup(long moneyGroup) {
		Student.moneyGroup = moneyGroup;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	public static int getCounter() {
		return counter;
	}

	public static final void study() {
		System.out.println("Student is studying");
	}
}
