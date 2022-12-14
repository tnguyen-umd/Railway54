package com.vti.frontend;

import java.util.Scanner;

public class Assignment_4_QLCB_Program {

	// Exercise 5: Inheritance
	// Question 1: inheritance
	// Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên.
	// Mỗi cán bộ cần quản lý các dữ liệu: Họ tên, tuổi, giới tính(name, nữ,
	// khác), địa chỉ.
	// Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
	// Cấp kỹ sư có thuộc tính riêng: Nghành đào tạo.
	// Các nhân viên có thuộc tính riêng: công việc.
	// Hãy xây dựng các lớp CongNhan, KySu, NhanVien kế thừa từ lớp
	// CanBo.

	// -------------------------------------------------------------------------------------------------------------------------------

	// Question 2: Tiếp tục Question 1
	// Xây dựng lớp QLCB(quản lý cán bộ) cài đặt các phương thức thực
	// hiện các chức năng sau:
	// a) Thêm mới cán bộ.
	// b) Tìm kiếm theo họ tên.
	// c) Hiện thị thông tin về danh sách các cán bộ.
	// d) Nhập vào tên của cán bộ và delete cán bộ đó
	// e) Thoát khỏi chương trình.

	// -------------------------------------------------------------------------------------------------------------------------------

	// Question 3 (Optional): constructor inheritance
	// Tạo class abstract Person gồm các property name và tạo constructor có
	// 1 parameter name
	// Tạo class abstract Student kế thừa Person gồm các property id, name
	// và tạo constructor có 2 parameter id, name
	// Tạo class HighSchoolStudent kế thừa Student bao gồm các property id,
	// name, clazz (Lớp đang học), desiredUniversity (trường đại học mong
	// muốn vào) và tạo constructor có 4 parameter id, name, clazz,
	// desiredUniversity.
	// Hãy khởi tạo Object HighSchoolStudent với các giá trị: id = 1, name =
	// "Nam", clazz = "Chuyên Văn", desiredUniversity = "Đại học công
	// nghệ"
	// -------------------------------------------------------------------------------------------------------------------------------

	// Question 4 (Optional):
	// Một thư viện cần quản lý các tài liệu bao gồm Sách, Tạp chí, Báo. Mỗi
	// tài liệu gồm có các thuộc tính sau: Mã tài liệu(Mã tài liệu là duy nhất),
	// Tên nhà xuất bản, số bản phát hành.
	// Các loại sách cần quản lý thêm các thuộc tính: tên tác giả, số trang.
	// Các tạp chí cần quản lý thêm: Số phát hành, tháng phát hành.
	// Các báo cần quản lý thêm: Ngày phát hành.
	// Xây dựng chương trình để quản lý tài liệu (QLTV) cho thư viện một
	// cách hiệu quả.
	// Xây dựng lớp QuanLySach có các chức năng sau
	// a) Thêm mới tài liêu: Sách, tạp chí, báo.
	// 4
	// b) Xoá tài liệu theo mã tài liệu.
	// c) Hiện thị thông tin về tài liệu.
	// d) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
	// e) Thoát khỏi chương trình.
	// -------------------------------------------------------------------------------------------------------------------------------

	// Exercise 6: Abstraction
	// Question 1: abstract class & abstract method
	// Tạo 1 class Phone để lưu thông tin liên lạc, trong Phone có chứa 1
	// property có kiểu dữ liệu là Array contacts, trong từng contact có lưu
	// thông tin number, name
	// a) Tạo các abstract method
	// a. void insertContact(String name, String phone)
	// b. void removeContact(String name)
	// c. void updateContact(String name, String newPhone)
	// d. void searchContact(String name)
	// b) Tạo class VietnamesePhone kế thừa Phone và triển khai các
	// method abstract
	// Viết chương trình demo
	// -------------------------------------------------------------------------------------------------------------------------------

	// Question 2 (Optional):
	// Hãy xây dựng 1 class User với các thuộc tính name kiểu String và
	// salary ratio kiểu double.
	// a) Viết các hàm cho phép nhập và trả về name, salary ratio.
	// b) Viết hàm calculatePay() dạng abstract trả về thu nhập của nhân
	// viên, kiểu double.
	// c) Viết hàm displayInfor()
	// -------------------------------------------------------------------------------------------------------------------------------

	// Question 3 (Optional): Tiếp tục Question 2
	// Viết class Employee, Manager, Waiter kế thừa User như sau:
	// Implement method calculatePay() như sau:
	// Đối với Employee sẽ được tính = salary ratio * 420
	// Đối với Manager sẽ được tính = salary ratio * 520
	// Đối với Waiter sẽ được tính = salary ratio * 220

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println(
					"---------------------------------------------------------------------------------------------------1");
			System.out.println("Please select from the following options: ");
			System.out.println("1) Add user");
			System.out.println("2) Search user");
			System.out.println("3) Show all users");
			System.out.println("4) Delete user");
			System.out.println("5) Quit program");
			byte option = sc.nextByte();

			switch (option) {
			case 1: {
				addUser();
				break;
			}
			case 2: {
				searchName();
				break;
			}
			case 3: {
				showUser();
				break;
			}
			case 4: {
				deleteUser();
				break;
			}
			case 5: {
				return;
			}
			default:
				System.out.println("Please select the correct option");
				break;

			}

		}
	}

	public static void addUser() {
		System.out.println("Adding user");

	}

	public static void searchName() {
		System.out.println("Searching user");
	}

	public static void showUser() {
		System.out.println("Showing user");
	}

	public static void deleteUser() {
		System.out.println("Deleting user");
	}
}
