package com.vti.backend;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.PositionName;

/*

WHILE
Question 16:
	Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với 
	lệnh break, continue
	DO-WHILE
Question 17:
	Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với 
	lệnh break, continue*/

public class Assignment_2_Exercise_1 {

	/*
	 * Question 1: Kiểm tra account thứ 2 Nếu không có phòng ban (tức là department
	 * == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban" Nếu không thì sẽ
	 * in ra text "Phòng ban của nhân viên này là …"
	 */
	public void question1(Account a) {
		// System.out.println(greeting);

		if (a.getDepartment().getName() == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Question 1: Phòng ban của nhân viên này là : " + a.getDepartment().getName());
		}
	}

	/*
	 * Question 2: Kiểm tra account thứ 2 Nếu không có group thì sẽ in ra text
	 * "Nhân viên này chưa có group" Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra
	 * text "Group của nhân viên này là Java Fresher, C# Fresher" Nếu có mặt trong 3
	 * Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều
	 * group" Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
	 * người hóng chuyện, tham gia tất cả các group"
	 */

	public void question2(Account x) {

		if (x.getGroups().size() == 0) {
			System.out.println("Question 2: Nhân viên này chưa có group");
		} else if (x.getGroups().size() == 1 || x.getGroups().size() == 2) {
			System.out.println("Question 2: Group của nhân viên này là Java Fresher, C# Fresher");

			// this is how to print out the values of array a2Group that belongs to the
			// Group
			for (Group group : x.getGroups()) {
				System.out.println(group.getName());
			}

		} else if (x.getGroups().size() == 3) {
			System.out.println("Question 2: Nhân viên này là người quan trọng, tham gia nhiều group");
		} else {
			System.out.println("Question 2: Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}

	}

	/*
	 * Question 3: Sử dụng toán tử ternary để làm Question 1
	 */
	public static void question3(Account x) {
		System.out.println(x.getDepartment().getName() == null ? "Question 3: this account does not have a department"
				: "Question 3: The department of this account is: " + x.getDepartment().getName());

	}

	/*
	 * Question 4: Sử dụng toán tử ternary để làm yêu cầu sau: Kiểm tra Position của
	 * account thứ 1 Nếu Position = Dev thì in ra text "Đây là Developer" Nếu không
	 * phải thì in ra text "Người này không phải là Developer"
	 */
	public static void question4(Account x) {
		System.out.println(x.getPosition().getPositionName() == PositionName.DEV ? "Question 4: Đây là Developer"
				: "Question 4: Người này không phải là Developer");

	}

	/*
	 * SWITCH CASE Question 5: Lấy ra số lượng account trong nhóm thứ 1 và in ra Nếu
	 * số lượng account = 1 thì in ra "Nhóm có một thành viên" Nếu số lượng account
	 * = 2 thì in ra "Nhóm có hai thành viên" Nếu số lượng account = 3 thì in ra
	 * "Nhóm có ba thành viên" Còn lại in ra "Nhóm có nhiều thành viên"
	 */
	public static void question5(Group x) {
		switch (x.getAccounts().size()) {
		case 1: {
			System.out.println("Nhóm có một thành viên");
		}
			break;
		case 2: {
			System.out.println("Nhóm có hai thành viên");
		}
			break;
		case 3: {
			System.out.println("Nhóm có ba thành viên");
		}
			break;
		default:
			System.out.println("Nhóm có nhiều thành viên");
		}
	}

//	Question 6: 
//		Sử dụng switch case để làm lại Question 2

	public static void question6(Account x) {
		switch (x.getGroups().size()) {
		case 0: {
			System.out.println("Question 6: Nhân viên này chưa có group");
		}
			break;
		case 1: {
			System.out.println("Question 6: Group của nhân viên này là Java Fresher, C# Fresher");
		}
			break;
		case 2: {
			System.out.println("Question 6: Group của nhân viên này là Java Fresher, C# Fresher");
		}
			break;
		case 3: {
			System.out.println("Question 6: Nhân viên này là người quan trọng, tham gia nhiều group");
		}
			break;
		case 4: {
			System.out.println("Question 6: Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
			break;
		default:
			System.out.println("nothing");
		}
	}

	// Question 7:
//		Sử dụng switch case để làm lại Question 4
	public static void question7(Account x) {
		switch (x.getPosition().getPositionName()) {
		case DEV: {
			System.out.println("Question 7: Đây là Developer");
		}
			break;
		default:
			System.out.println("Question 7: Người này không phải là Developer");
		}
	}

//FOREACH
//Question 8 and 9
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của 	họ
//	In ra thông tin các phòng ban bao gồm: id và name	

	public void question8(Account[] x) {

		for (Account a : x) {
			System.out.println(a.toString());
			// a is an element of the `x` array.
		}
	}

//	FOR
//	Question 10: 
//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của 
//		họ theo định dạng như sau:
//	Thông tin account thứ 1 là: 
//	Email: NguyenVanA@gmail.com
//	Full name: Nguyễn Văn A
//	Phòng ban: Sale

//		Thông tin account thứ 2 là: 
//	Email: NguyenVanB@gmail.com
//	Full name: Nguyễn Văn B
//	Phòng ban: Marketting

	public void question10(Account[] x) {

		for (int i = 0; i < x.length; i++) {
			System.out.println("Email: " + x[i].getEmail());// x[i] is to assign the value of the index.
			System.out.println("Full name: " + x[i].getName());
			System.out.println("Phòng ban: " + x[i].getDepartment().getID());
			System.out.println();
		}

	}

//	
//	Question 11: 
//		In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau: 
//		Thông tin department thứ 1 là: 
//		Id: 1
//		Name: Sale
//		Thông tin department thứ 2 là: 
//		Id: 2
//		Name: Marketing

	public void question11(Department[] x) {

		for (int i = 0; i < x.length; i++) {
			System.out.println("ID: " + x[i].getID());// x[i] is to assign the value of the index.
			System.out.println("Name: " + x[i].getName());
			System.out.println();
		}

	}

//	Question 12: 
//		Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
	public void question12(Department[] x) {

		for (int i = 0; i < 2; i++) {
			System.out.println("ID: " + x[i].getID());// x[i] is to assign the value of the index.
			System.out.println("Name: " + x[i].getName());
			System.out.println();

		}

	}

//	Question 13: 
//		In ra thông tin tất cả các account ngoại trừ account thứ 2
	public void question13(Account[] x) {

		for (int i = 0; i < x.length; i++) {
			if (i == 1)
				continue;

			System.out.println("Email: " + x[i].getEmail());// x[i] is to assign the value of the index.
			System.out.println("Full name: " + x[i].getName());
			System.out.println("Phòng ban: " + x[i].getDepartment().getID());
			System.out.println();
		}

	}

//	Question 14: 
//		In ra thông tin tất cả các account có id < 4
	public void question14(Account[] x) {

		for (int i = 0; i < x.length; i++) {
			if (x[i].getID() == 4)
				break;

			System.out.println("Email: " + x[i].getEmail());// x[i] is to assign the value of the index.
			System.out.println("Full name: " + x[i].getName());
			System.out.println("Phòng ban: " + x[i].getDepartment().getID());
			System.out.println();
		}

	}

//		Question 15: 
//		In ra các số chẵn nhỏ hơn hoặc bằng 20
	public void question15(int x) {

		for (int i = 0; i <= x; i += 2)

			System.out.println(i);
	}

}
