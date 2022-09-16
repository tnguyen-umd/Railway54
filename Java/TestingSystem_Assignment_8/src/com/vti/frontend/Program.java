package com.vti.frontend;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import com.vti.entity.Student;

public class Program {
	static List<Student> students = new ArrayList<>();
	static List<Student> deleteStudents = new ArrayList<Student>();
	static List<Student> studentCopies = new ArrayList<Student>();
	static Stack<Student> interviewStudents = new Stack<>();
	static Queue<Student> queueStudents = new ArrayDeque<>();
	static Map<Integer, Student> mapStudents = new HashMap<>();

	static Scanner scanner = new Scanner(System.in);
	static boolean found;

	public static void main(String[] args) {
//		 * Exercise 1: Collection Question 1: List Tạo 1 student có property id, name
//		 * (trong đó có 3 student có name trùng nhau, id sẽ là auto increment) Khai báo
//		 * ArrayList students, sau đó
		Student student1 = new Student("A");
		Student student2 = new Student("A");
		Student student3 = new Student("A");
		Student student4 = new Student("B");
		Student student5 = new Student("Nguyen Van Nam");
		Student student6 = new Student("Nguyen Van Huyen");
		Student student7 = new Student("Tran Van Nam");
		Student student8 = new Student("Nguyen Van A");
		Student student9 = new Student("A");
		Student student10 = new Student("B");

		// add students 1-4 to arraylist students
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student9);
		students.add(student10);

//add students 5-8 to arraylist interviewStudents
		interviewStudents.push(student5);
		interviewStudents.push(student6);
		interviewStudents.push(student7);
		interviewStudents.push(student8);

		// add students 5-8 to arrayqueue queueStudents
		queueStudents.add(student5);
		queueStudents.add(student6);
		queueStudents.add(student7);
		queueStudents.add(student8);

		// System.out.println(interviewStudents.size());

//		 * Exercise 1: Collection
//		 * 
//		 * Question 1: List Tạo 1 student có property id, name // * (trong đó có 3
//		 * student có name trùng nhau, id sẽ là auto increment) Khai báo // * ArrayList
//		 * students, sau đó // * a) In ra tổng số phần tử của students // showStudent();

		// * b) Lấy phần tử thứ 4 của students //
		// System.out.println(students.get(4));

		// * d) Thêm 1 phần tử vào vị trí đầu của students // * e) Thêm 1 phần tử vào
//		 * vị trí cuối của students

		// * f) Đảo ngược vị trí của students, use arraylist.sort-->reversed()
		// //reverseOrder();

		// * c) In ra phần tử đầu và phần tử cuối của students

		// * g) Tạo 1 method tìm kiếm student theo id //
//		searchID();

		// * h) Tạo 1 method tìm kiếm student theo name //
//		searchName();

		// * i) Tạo 1 method để in ra các student có trùng tên //
//		findDuplicate();

		// * j) Xóa name của student có id = 2; // * k) Delete student có id = 5; //
//		showStudent(); //
//		deleteByID(); //
//		showStudent();

		// * l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào //
		// *studentCopies

//		copyStudent();

		/*
		 * Question 2 (Optional): Stack & Queue Khai báo 1 danh sách lưu các tên học //*
		 * sinh tới tham dự phỏng vấn, thứ tự tới của các học sinh như sau: Nguyễn Văn
		 * //* Nam, Nguyễn Văn Huyên, Trần Văn Nam, Nguyễn Văn A //* //*
		 * 
		 * a) Tạo 1 method để in ra thứ tự tới của các học sinh theo thứ tự từ muộn nhất
		 * //* tới sớm nhất (gợi ý dùng Stack) *
		 * 
		 * b) Tạo 1 method để in ra thứ tự tới của các học sinh theo thứ tự sớm nhất tới
		 * //* muộn nhất (gợi ý dùng Queue)
		 */
//		printInterviewers();
//		printQueueStudents();

		/*
		 * Use sorting for the following questions, sort by name and then id are
		 * intergrated
		 * 
		 * Question 3 (Optional): Set Tạo 1 student có property id, name Khai báo 1 Set
		 * students, sau đó làm các chức năng tương tự List2
		 * 
		 * Question 4 (Optional): Set Tạo 1 danh sách có chứa name của các student không
		 * trùng nhau In ra set đó
		 * 
		 * Question 5 (Optional): Set Tạo 1 danh sách có chứa name của các student không
		 * trùng nhau. Sắp xếp theo name và in ra set đó
		 * 
		 * Exercise 2 (Optional): Comparing Tạo 1 student có property id, name, ngày
		 * sinh, điểm và tạo 5 student Question 1: Comparable In ra học sinh sắp xếp
		 * theo name
		 * 
		 * Question 2: Comparator In ra học sinh sắp xếp theo name, nếu tên trùng nhau
		 * thì sẽ sắp xếp theo ngày sinh, nếu ngày sinh trùng nhau thì sẽ sắp xếp theo
		 * điểm
		 */
//		sortStudent();
		// * Exercise 2
		// *
		// * Question 6: Map Để thay thế 1 object ta có thể tạo 1 map tên là students có
		// * key = id của student , value là name của students

		// Map: key, object
		mapStudents.put(1, student1);
		mapStudents.put(2, student5);
		mapStudents.put(3, student4);
		mapStudents.put(4, student3);
		mapStudents.put(5, student2);
		// *
		// * Question 7 (Optional): tiếp tục question 6 Thực hiện các chức năng sau:
//		a) In ra các key của students 
		for (Integer number : mapStudents.keySet()) {
			System.out.println(number);
		}
//		b) In ra value của students 
		System.out.println("Before sorting");
		for (Student key : mapStudents.values()) {
			System.out.println(key);
		}

//		c) In ra danh sách
		// * students được sắp xếp theo tên của student
		System.out.println("After sorting using stream() ");
		mapStudents.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		// d) Chuyển đổi map students sang* set *
		// Convert Map keys to Set
		Set<Integer> keySet = new HashSet<Integer>(mapStudents.keySet());
		keySet.forEach(key -> System.out.println(key));

		// Convert Map values to Set
		Set<Student> valueSet = new HashSet<Student>(mapStudents.values());
		valueSet.forEach(value -> System.out.println(value));
	}

	// create print student method
	public static void showStudent() {
		for (Student i : students) {
			System.out.println(i.toString());
		}
	}

	// create searchID method
	public static void searchID() {
		System.out.println("Insert student ID: ");
		int keyboard = scanner.nextInt();

		for (Student student : students) {
			if (keyboard == student.getId()) {
				System.out.print("Student found: ");
				System.out.println(student.toString());
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("This ID does not exist " + keyboard);
		}
	}

	// create by name method
	public static void searchName() {
		System.out.println("Nhap ten student can tim kiem: ");
		String name = scanner.nextLine();
		if (name == null || name.equals("")) {
			System.out.println("Khong co student nao khong co ho ten");
		} else {
			boolean found = false;
			for (Student student : students) {
				if (student.getName().equals(name)) {
					System.out.println(student.toString());
					found = true;
				}
			}
			if (!found) {
				System.out.println("Khong co student nao co ten la: " + name);
			}
		}
	}

	// sap xep nguoc thu tu arraylist
	public static void reverseOrder() {
		students.sort(Comparator.comparing(Student::getId).reversed());
		System.out.println("Thong tin Account: ");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	// find duplicates in arraylist
	public static void findDuplicate() {
		Set<String> sets = new HashSet<String>();

		for (Student student : students) {
			if (!sets.add(student.getName()))
				System.out.println(student.toString() + " is duplicated");
		}
	}

	// delete an instance by ID
	public static void deleteByID() {
		System.out.print("Insert student ID you want to delete: ");
		int keyboard = scanner.nextInt();
		for (Student student : students) {
			if (student.getId() == keyboard)
				deleteStudents.add(student);
		}
		if (deleteStudents.size() > 0) {
			students.removeAll(deleteStudents);
			System.out.println("Deleted the following student with ID " + keyboard);
		} else {
			System.out.println("Khong tim thay student can xoa co ID: " + keyboard);
		}
	}

	// copy arraylist to another arraylist
	public static void copyStudent() {
		for (Student student : students) {
			studentCopies.add(student);
		}

		for (Student student : studentCopies) {
			System.out.println(student.toString());
		}
	}

	public static void printInterviewers() {
		for (int i = interviewStudents.size(); i > 0; i--) {
			System.out.println(interviewStudents.pop().toString());
		}
	}

	public static void printQueueStudents() {
		for (Student student : queueStudents) {
			System.out.println(student.toString());
		}
	}

	public static void sortStudent() {

		// comparing 2 or more layers by using thenComparing
		students.sort(Comparator.comparing(Student::getName).thenComparing(Student::getId));
		System.out.println("Thong tin students: ");
		for (Student student : students) {
			System.out.println(student);
		}
	}
}

/*

 */