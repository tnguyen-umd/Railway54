package com.vti.frontend;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import AccountManagement.Account;

public class Assignment_3_Program {
	static List<Account> accounts = new ArrayList<>();
	static List<TestingSystem_Assignment_3.Department> departments = new ArrayList<>();

	public static void accountInfo() {
		System.out.println("Thong tin Account: ");
		for (Account acc : accounts)
			System.out.println(acc);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// accountInfo();
		// question1();
		// question2();
		// question3();
		// question4();
		// exercise4Question1();
		// exercise4Question2();
		// exercise4Question3();
		// exercise4Question4();
		// exercise4Question5();
		// exercise4Question7();
		exercise5();

	}

	public static void question1() {
		// Exercise 1 (Optional): Datatype Casting
		// Question 1:
//			Khai báo 2 số lương có kiểu dữ liệu là float.
//			Khởi tạo Lương của Account 1 là 5240.5 $
//			Khởi tạo Lương của Account 2 là 10970.055$
//			Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//			Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
		Scanner accSalary = new Scanner(System.in);

		System.out.println("Nhap vao so luong: ");
		float salary = accSalary.nextFloat();

		long luongChan = (long) salary;
		System.out.println(luongChan);
		accSalary.close();
	}

	public static void question2() {
		// Question 2:
//		Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
//		có số 0 ở đầu cho đủ 5 chữ số)
		Scanner accSalary = new Scanner(System.in);

		System.out.println("Nhap vao so luong: ");
		float salary = accSalary.nextFloat();

		long luongChan = (long) salary;
		System.out.printf("%05d", luongChan);
		accSalary.close();
	}

	public static void question3() {
		// Question 3:
//		Lấy 2 số cuối của số ở Question 2 và in ra.
//		Gợi ý: 
//		Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
//		Cách 2: chia lấy dư số đó cho 100
		Scanner accSalary = new Scanner(System.in);

		System.out.println("Nhap vao so luong: ");
		float salary = accSalary.nextFloat();

		long luongChan = (long) salary;

		System.out.printf("%05d", (luongChan % 100));
		accSalary.close();
	}

	public static void question4() {
		// Question 4:
//		Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
		Scanner number = new Scanner(System.in);

		System.out.println("Nhap vao 2 so: ");
		int num1 = number.nextInt();
		int num2 = number.nextInt();

		float thuongSo = (float) num1 / num2;

		// float có 2 số sau dấu thập phân
		System.out.printf("%.2f", thuongSo);
		System.out.println();

		// Exercise 3
		// Question 2:
//		Khai báo 1 String có value = "1234567"
//		Hãy convert String đó ra số int
		String soThuc = "123456";
		System.out.println(Integer.parseInt(soThuc));

		// Question 3:
//		Khởi tạo 1 số Integer có value là chữ "1234567"
//		Sau đó convert số trên thành datatype int
		Integer value = 123456;
		int val = value;
		System.out.println(val);

		number.close();
	}

	public static void exercise4Question1() {
		// Exercise 4: String
		// Question 1:
//			Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có 
//			thể cách nhau bằng nhiều khoảng trắng );
		Scanner newInput = new Scanner(System.in);

		System.out.println("Please input new string: ");
		String new1 = newInput.nextLine();

		// count number of characters in a String

		System.out.println("number of characters in this string is: " + new1.length());

		newInput.close();
	}

	public static void exercise4Question2() {
		// Question 2:
//		Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
		Scanner newInput = new Scanner(System.in);

		System.out.println("Please input 2 new strings: ");
		String s1 = newInput.next();
		String s2 = newInput.next();

		// count number of characters in a String
		System.out.println("the new string is : " + s1.concat(s2));

		newInput.close();
	}

	public static void exercise4Question3() {
		// Question 3:
//		Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư 
//		viết hoa chữ cái đầu thì viết hoa lên
		Scanner newInput = new Scanner(System.in);

		System.out.println("First name: ");
		String firstName = newInput.next();

		// Capitalize the first letter only
		String s1 = firstName.substring(0, 1).toUpperCase();

		System.out.println("Last name: ");
		String lastName = newInput.next();
		// Capitalize the first letter only
		String s2 = lastName.substring(0, 1).toUpperCase();

		System.out.println("Ten cua ban la: " + s1 + firstName.substring(1) + " " + s2 + lastName.substring(1));

		newInput.close();

	}

	public static void exercise4Question4() {

		// Question 4:
//		Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên 
//		của người dùng ra. Người dùng nhập vào "Nam", hệ thống sẽ in ra	"Ký tự thứ 1 là: N" "Ký tự thứ 2 là: A"  "Ký tự thứ 3 là: M" 
		Scanner newInput = new Scanner(System.in);

		System.out.println("First name: ");
		String firstName = newInput.next();

		for (int i = 0; i < firstName.length(); i++) {
			System.out.println("Letter at character " + i + " is " + firstName.charAt(i));
		}
		newInput.close();

	}

	public static void exercise4Question5() {
		// Question 5:
//		Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người 
//		dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ

		// Question 6:
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và 
//		sau đó hệ thống sẽ tách ra họ, tên , tên đệm
//		VD:
//		Người dùng nhập vào "Nguyễn Văn Nam"
//		Hệ thống sẽ in ra
//		"Họ là: Nguyễn"
//		"Tên đệm là: Văn"
//		"Tên là: Nam"
		Scanner newInput = new Scanner(System.in);

		System.out.println("Full name: ");
		String name = newInput.nextLine();

		// split string by spaces
		String[] vals = name.split(" ");
		System.out.println("Last name: " + vals[0]);
		System.out.println("Middle name: " + vals[1]);
		System.out.println("First name: " + vals[2]);

		newInput.close();
	}

	public static void exercise4Question7() {
		// Question 7:
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và 
//		chuẩn hóa họ và tên của họ như sau:
//		a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập 
//		vào
//		3
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ 
//		chuẩn hóa thành "nguyễn văn nam"
//		b) Viết hoa chữ cái mỗi từ của người dùng
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ 
//		chuẩn hóa thành "Nguyễn Văn Nam"

		Scanner newInput = new Scanner(System.in);

		System.out.println("Full name: ");
		String inputName = newInput.nextLine();

		// take out the spaces at the beginning and end of the string
		String name = inputName.trim();

		// split string by spaces
		String[] vals = name.split(" ");

		// Capitalize the first letter only
		String s1 = vals[0].substring(0, 1).toUpperCase();
		String s2 = vals[1].substring(0, 1).toUpperCase();
		String s3 = vals[2].substring(0, 1).toUpperCase();

		System.out.println("Ten cua ban la: " + s1 + vals[0].substring(1) + " " + s2 + vals[1].substring(1) + " " + s3
				+ vals[2].substring(1));

		newInput.close();
	}

	public static void exercise5() {
		// Exercise 5: Object’s Method

		TestingSystem_Assignment_3.Department d1 = new TestingSystem_Assignment_3.Department(1, "Accounting",
				"45 Hoang Hoa Tham");
		TestingSystem_Assignment_3.Department d2 = new TestingSystem_Assignment_3.Department(2, "Boss of director",
				"21 Doi Can");
		TestingSystem_Assignment_3.Department d3 = new TestingSystem_Assignment_3.Department(3, "Marketing",
				"123 Vu Ngoc Phan");
		TestingSystem_Assignment_3.Department d4 = new TestingSystem_Assignment_3.Department(4, "Sale",
				"50 Truong Chinh");
		TestingSystem_Assignment_3.Department d5 = new TestingSystem_Assignment_3.Department(5, "Accounting",
				"132 Phan Boi Chau");
		TestingSystem_Assignment_3.Department d6 = new TestingSystem_Assignment_3.Department(6, "Waiting room",
				"132 Phan Boi Chau");

		departments.add(d1);
		departments.add(d2);
		departments.add(d3);
		departments.add(d4);
		departments.add(d5);
		departments.add(d6);

		// Question 1:
//			In ra thông tin của phòng ban thứ 1 (sử dụng toString())
		System.out.println("Question 1: Thong tin phong ban 1: " + d1.toString());
		System.out.println();

		// Question 2:
		// I n ra thông tin của tất cả phòng ban (sử dụng toString())
		System.out.println("Question 2: Thong tin tat ca cac phong ban: ");
		for (TestingSystem_Assignment_3.Department dep : departments) {
			System.out.println(dep.toString());
		}
		System.out.println();
		// Question 3:
//		In ra địa chỉ của phòng ban thứ 1

		System.out.println("Question 3: Address of department 1: " + d1.getAddress());
		System.out.println();

		// Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
		if (d1.getName().equals("Phong A")) {
			System.out.println("Question 4: ten cua phong ban 1 la Phong A");
		} else {
			System.out.println("Question 4: ten cua phong ban 1 khong phai la Phong A");
		}
		System.out.println();

		// Question 5:
//		So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau 
//		không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
		if (d1.equals(d5)) {
			System.out.println("Question 5: phong 1 va phong 5 bang nhau");
		} else {
			System.out.println("Question 5: phong 1 va phong 5 khong bang nhau");
		}
		System.out.println();
		// Question 6:
//		Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh 
//		sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
//		VD: //	Accounting//	Boss of director//	Marketing//	Sale//	Waiting room
		System.out.println("Question 6: Sorting department names by alphabetical order");
		departments.sort(Comparator.comparing(TestingSystem_Assignment_3.Department::getName));
		for (TestingSystem_Assignment_3.Department dep : departments) {
			System.out.println(dep);
		}

		// Question 7:
//		Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh 
//		sách phòng ban được sắp xếp theo tên
//		VD: 
//		Accounting
//		Boss of director
//		Marketing
//		waiting room
//		Sale

	}
}

//	

//
//Exercise 2 (Optional): Default value
//Question 1:
//	Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi 
//	tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
//	 Email: "Email 1"
//	 Username: "User name 1"
//	 FullName: "Full name 1"
//	 CreateDate: now
//
//Exercise 3(Optional): Boxing & Unboxing
//Question 1:
//	Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//	Sau đó convert lương ra float và hiển thị lương lên màn hình (với số 
//	float có 2 số sau dấu thập phân)
//
//Question 8:
//In ra tất cả các group có chứa chữ "Java"
//Question 9:
//In ra tất cả các group "Java"
//Question 10 (Optional):
//Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không. 
//Nếu có xuất ra “OK” ngược lại “KO”. 
//Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
//Question 11 (Optional): Count special Character 
//Tìm số lần xuất hiện ký tự "a" trong chuỗi
//Question 12 (Optional): Reverse String
//Đảo ngược chuỗi sử dụng vòng lặp
//Question 13 (Optional): String not contains digit
//Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược 
//lại true.
//Ví dụ:
//"abc" => true
//"1abc", "abc1", "123", "a1bc", null => false
//Question 14 (Optional): Replace character
//Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác 
//cho trước. 
//Ví dụ:
//"VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"
//Question 15 (Optional): Revert string by word
//Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng 
//thư viện. 
//Ví dụ: " I am developer " => "developer am I". 
//Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
//Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt 
//chuỗi theo dấu cách
//Question 16 (Optional):
//Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần 
//bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn 
//hình “KO”.