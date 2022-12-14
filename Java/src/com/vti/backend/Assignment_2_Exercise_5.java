package com.vti.backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.PositionName;

/*
Exercise 5: Input from console

Question 10: Tiếp tục Question 8 và Question 9
	Bổ sung thêm vào bước 2 của Question 8 như sau:
	
	Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào account 
	
	Bổ sung thêm Bước 3 của Question 8 như sau: 
	
	Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng 
	text để hỏi người dùng "Bạn có muốn thực hiện chức năng khác không?". 
	
	Nếu người dùng chọn "Có" thì quay lại bước 1, nếu người 
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
*/

public class Assignment_2_Exercise_5 {

//	Question 1: Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
	public void question1() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input a number: ");
		int number1 = scanner.nextInt();

		System.out.print("Please input a number: ");
		int number2 = scanner.nextInt();

		System.out.print("Please input a number: ");
		int number3 = scanner.nextInt();

		System.out.println("List of numbers: " + number1 + " " + number2 + " " + number3);

		scanner.close();
	}

//	Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
	public void question2() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input a real number: ");
		float float1 = scanner.nextFloat();

		System.out.print("Please input a number: ");
		float float2 = scanner.nextFloat();

		System.out.println("List of numbers: " + float1 + " and " + float2);

		scanner.close();
	}

	// Question 3: Viết lệnh cho phép người dùng nhập họ và tên
	public static void question3() {
		Scanner demo = new Scanner(System.in);
		System.out.print("Please input first name: ");
		String first1 = demo.next();

		System.out.print("Please input last name: ");
		String last1 = demo.next();

		System.out.println("full name: " + first1 + " " + last1);

		demo.close();
	}

//	Question 4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
	public static void question4() throws ParseException {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input your date of birth using this format MM-dd-yyyy: ");
		String s1 = scanner.next();

		String pattern = "MM-dd-yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

		Date date = dateFormat.parse(s1);

		System.out.println("Date of birth :" + date);

		// Date dateOfBirth = SimpleDateFormat.getInstance().parse(demo.nextLine());

		// System.out.println("Date of birth: " + dateOfBirth);

		scanner.close();

	}

//	Question 5: Viết lệnh cho phép người dùng tạo account (viết thành method)
//		Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào 
//		chương trình sẽ chuyển thành Position.Dev, Position.Test, 
//		Position.ScrumMaster, Position.PM

	public void question5() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input account info: ");
		System.out.println("account ID : ");
		int accountId = scanner.nextInt();
		System.out.println("email : ");
		String email = scanner.next();
		System.out.println("username : ");
		String username = scanner.next();
		System.out.println("fullname : ");
		String fullName = scanner.next();
		System.out.println("Position ID : ");
		int positionId = scanner.nextInt();

		Position p1 = new Position(1, PositionName.DEV);
		Position p2 = new Position(2, PositionName.TEST);
		Position p3 = new Position(3, PositionName.PM);
		Position p4 = new Position(4, PositionName.SCRUM_MASTER);

		switch (positionId) {
		case 1: {
			Account account = new Account(accountId, email, username, fullName, null, null, p1, LocalDate.now());
			System.out.println("Account info : " + account.getID() + " " + account.getEmail() + " "
					+ account.getUserName() + " " + account.getName() + " " + account.getPosition().getPositionName());
		}
			break;
		case 2: {
			Account account = new Account(accountId, email, username, fullName, null, null, p2, LocalDate.now());
			System.out.println("Account info : " + account.getID() + " " + account.getEmail() + " "
					+ account.getUserName() + " " + account.getName() + " " + account.getPosition().getPositionName());
		}
			break;
		case 3: {
			Account account = new Account(accountId, email, username, fullName, null, null, p3, LocalDate.now());
			System.out.println("Account info : " + account.getID() + " " + account.getEmail() + " "
					+ account.getUserName() + " " + account.getName() + " " + account.getPosition().getPositionName());
		}
			break;
		case 4: {
			Account account = new Account(accountId, email, username, fullName, null, null, p4, LocalDate.now());
			System.out.println("Account info : " + account.getID() + " " + account.getEmail() + " "
					+ account.getUserName() + " " + account.getName() + " " + account.getPosition().getPositionName());
		}
			break;
		default:
			System.out.println("No account is created");

		}
	}

	// Question 6: Viết lệnh cho phép người dùng tạo department (viết thành method)

	public static void question6() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input department info: ");
		System.out.println();
		System.out.println("Department ID : ");
		int departmentId = scanner.nextInt();

		System.out.println("Department name : ");
		String departmentName = scanner.next();

		Department department = new Department(departmentId, departmentName);
		System.out.println(department.toString());

	}

	public static void main(String[] args) throws ParseException {

		Assignment_2_Exercise_5 exercise_5 = new Assignment_2_Exercise_5();
		// exercise_5.question1();
		// exercise_5.question2();
		// exercise_5.question3();
		// exercise_5.question4();
		// exercise_5.question5();
		// exercise_5.question6();
		// exercise_5.question7();
		exercise_5.question8();

	}

	// Question 7: Nhập số chẵn từ console
	public static void question7() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int num = scanner.nextInt();

		if (num % 2 == 0) {
			System.out.println("Entered number is even : " + num);
		}

	}

//	Question 8: 
//		Viết chương trình thực hiện theo flow sau:
//		Bước 1: 
//		Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
//		Bước 2: 
//		Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
//		Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo 
//		department
//		Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập lại" và quay trở lại bước 1
	// nều i>2 i=2 i= 3

//	Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng 
//	text để hỏi người dùng "Bạn có muốn thực hiện chức năng khác 
//	không?". Nếu người dùng chọn "Có" thì quay lại bước 1, nếu người 
//	dùng chọn "Không" thì kết thúc chương trình (sử dụng lệnh return để 
//	kết thúc chương trình)

	public void question8() {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			// chu

			// so

			System.out.println("mời bạn nhập vào chức năng muốn sử dụng: ");

			int num = scanner.nextInt();
			// scanner.nextLine();//khi nao chuyen so--> chu hoac nguoc lai thi phai dung
			// nextline() de khong bi dinh nhau
			if (num == 1 || num == 2) {
				switch (num) {
				case 1:
					Assignment_2_Exercise_5 exercise_5 = new Assignment_2_Exercise_5();
					exercise_5.question5();
					System.out.println("Ban co muon tiep tuc khong :");
					String answer = scanner.next(); // cau tra loi la co hoac khong

					if (answer.equals("Khong")) {
						scanner.close();
						return; // neu cau tra loi la khong thi dung han chuong trinh
					}

					break;

				case 2:
					Assignment_2_Exercise_5 exercise_6 = new Assignment_2_Exercise_5();
					exercise_6.question6();
					System.out.println("Ban co muon tiep tuc khong :");
					String answer2 = scanner.next(); // cau tra loi la co hoac khong

					if (answer2.equals("Khong")) {
						scanner.close();
						return; // neu cau tra loi la khong thi dung han chuong trinh
					}

					break;

				}

			} else {
				System.out.println("Nhap lai");

			}

		}

//		if (num == 1) {
//
//		} else if (num == 2) {
//			Exercise_5 exercise_5 = new Exercise_5();
//			exercise_5.question6();
//		} else {
//			System.out.println("Mời bạn nhập lại và quay trở lại bước 1");
//			Exercise_5 exercise_5 = new Exercise_5();
//			exercise_5.question8();
//		}

	}

//	Question 9: 
//	Viết method cho phép người dùng thêm group vào account theo flow sau:
//	Bước 1: In ra tên các usernames của user cho người dùng xem

//	Bước 2: Yêu cầu người dùng nhập vào username của account

//	Bước 3: In ra tên các group cho người dùng xem

//	Bước 4: Yêu cầu người dùng nhập vào tên của group

//	Bước 5: Dựa vào username và tên của group người dùng vừa chọn, hãy thêm account vào group đó
	// groups cua acc chua co j

	public void question9(List<Account> a, List<Group> b) {

		Scanner scanner = new Scanner(System.in);
		// in ra usernames cua cac' user trong allAccounts
		for (int i = 0; i < a.size(); i++) {
			System.out.println("List of usernames:" + a.get(i).getUserName());
		}

		// input your username
		System.out.println("Please input username");
		String userName = scanner.next();

		for (int j = 0; j < b.size(); j++) {
			System.out.println("Group names: " + b.get(j).getName());
		}

		System.out.println("Please input group name");
		String groupName = scanner.next();

//		for (int i = 0; i < b.length; i++) {
//			if (groupName.equals(b[i].getName())) {
////				1)check xem account co ton tai khong
////				2) check xem account+group co ton tai khong
////				3) neu khong ton tai thi` in ra la mot trong 2 khong ton tai
////				4) tao ra newAccount roi cho vao group day
////			}	
//
//			}
////		
//
//			// Account[] g6Accounts= {a1,a2,a3,a4};
//
//			// 1:
//
//			scanner.close();
//		}

		// tim ra group co' groupName trung voi' group nhap vao
		int index = 0;
		for (int i = 0; i < b.size(); i++) {
			if (b.get(i).getName().equals(groupName)) {
				index = i;
				break;
			}
		}

		// them group vao` account day
		for (int i = 0; i < a.size(); i++) {

			// if inUsername nhap vao` co' trong List<Account>(allAccount)
			// cho them gr vao` trong inUsername
			if (a.get(i).getUserName().equals(userName)) {
				a.get(i).getGroups().add(b.get(index));
				b.get(index).getAccounts().add(a.get(i));
				break;
			}
		}

		// cho inUsername them vao trong gr

	}
}
