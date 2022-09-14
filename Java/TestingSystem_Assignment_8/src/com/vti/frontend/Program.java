package com.vti.frontend;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.vti.entity.Student;

public class Program {
	static List<Student> students = new ArrayList<>();
	static List<Student> deleteStudents = new ArrayList<Student>();
	static List<Student> studentCopies = new ArrayList<Student>();

	static Scanner scanner = new Scanner(System.in);
	static boolean found;

	public static void main(String[] args) {
//		 * Exercise 1: Collection Question 1: List Tạo 1 student có property id, name
//		 * (trong đó có 3 student có name trùng nhau, id sẽ là auto increment) Khai báo
//		 * ArrayList students, sau đó
		Student student1 = new Student("Mr A");
		Student student2 = new Student("Mr A");
		Student student3 = new Student("Mr A");
		Student student4 = new Student("Mr B");

		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);

//		 * a) In ra tổng số phần tử của students
//		showStudent();

//		 * b) Lấy phần tử thứ 4 của students
//		System.out.println(students.get(4));

//		 * d) Thêm 1 phần tử vào vị trí đầu của students
//		 * e) Thêm 1 phần tử vào vị trí cuối của students

//		 * f) Đảo ngược vị trí của students, use arraylist.sort-->reversed()
		// reverseOrder();

//		 * c) In ra phần tử đầu và phần tử cuối của students

		// * g) Tạo 1 method tìm kiếm student theo id
		// searchID();

//		 * h) Tạo 1 method tìm kiếm student theo name
		// searchName();

//		 * i) Tạo 1 method để in ra các student có trùng tên
		// findDuplicate();

//		 * j) Xóa name của student có id = 2;
//		 * k) Delete student có id = 5;
//		showStudent();
//		deleteByID();
//		showStudent();

//		 * l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
//		 * studentCopies
		// copyStudent();

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

}

/*
 * 
 * 
 * 
 * 
 * Question 2 (Optional): Stack & Queue Khai báo 1 danh sách lưu các tên học
 * sinh tới tham dự phỏng vấn, thứ tự tới của các học sinh như sau: Nguyễn Văn
 * Nam, Nguyễn Văn Huyên, Trần Văn Nam, Nguyễn Văn A a) Tạo 1 method để in ra
 * thứ tự tới của các học sinh theo thứ tự từ muộn nhất tới sớm nhất (gợi ý dùng
 * Stack) b) Tạo 1 method để in ra thứ tự tới của các học sinh theo thứ tự sớm
 * nhất tới muộn nhất (gợi ý dùng Queue)
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
 * Question 6: Map Để thay thế 1 object ta có thể tạo 1 map tên là students có
 * key = id của student , value là name của students
 * 
 * Question 7 (Optional): tiếp tục question 6 Thực hiện các chức năng sau: a) In
 * ra các key của students b) In ra value của students c) In ra danh sách
 * students được sắp xếp theo tên của student d) Chuyển đổi map students sang
 * set
 * 
 * Exercise 2 (Optional): Comparing Tạo 1 student có property id, name, ngày
 * sinh, điểm và tạo 5 student
 * 
 * Question 1: Comparable In ra học sinh sắp xếp theo name
 * 
 * Question 2: Comparator In ra học sinh sắp xếp theo name, nếu tên trùng nhau
 * thì sẽ sắp xếp theo ngày sinh, nếu ngày sinh trùng nhau thì sẽ sắp xếp theo
 * điểm
 * 
 * Exercise 3: Generic
 * 
 * Question 1: T generic (class) Tạo class student có property id, name (trong
 * đó id của student có thể là int, long, float) a) Tạo đối tượng student có id
 * là int b) Tạo đối tượng student có id là float c) Tạo đối tượng student có id
 * là double
 * 
 * Question 2: T generic (method) Tạo method để in ra thông tin nhập vào
 * (parameter) (parameter có thể là họ và tên, hoặc student, hoặc int) Gợi ý:
 * tạo method print(T a) và cài đặt system out (a) ra Demo chương trình với
 * print(student), print(4), print(4.0)
 * 
 * Question 4: E generic Tạo 1 array int, 1 array float, 1 array long, 1 array
 * double Tạo 1 method có parameter là array và in ra các số trong array đó
 * 
 * Question 5: E generic 3 Tạo 1 class Employee có property id, name, salaries
 * với salaries là lương các tháng của Employee đó và là 1 array có data type có
 * thể là int, long, float. Viết method trong Employee để in ra thông tin của
 * Employee bao gồm id, name, salaris. Viết method trong Employee để in ra thông
 * tin tháng lương cuối cùng của Employee a) Hãy tạo chương trình demo với
 * Employee có salaries là datatype int b) Hãy tạo chương trình demo với
 * Employee có salaries là datatype float c) Hãy tạo chương trình demo với
 * Employee có salaries là datatype double Question 6: K & V generic
 * 
 * Tạo 1 class có tên là MyMap, lưu dữ liệu theo dạng key, value Tạo các method
 * a) GetValue() b) getKey () Viết chương trình demo: tạo 1 object Student có
 * key là Mã sinh viên và value là tên của sinh viên đó
 * 
 * Question 7: K & V generic Tạo 1 class có tên là Phone, lưu dữ liệu theo dạng
 * key, value (extends MyMap) Với key là email hoặc là số thứ tự hoặc là tên
 * người sử dụng Với value là số điện thoại Tạo các method a) GetPhoneNumber()
 * b) getKey () Viết chương trình demo với a) key là email b) key là số thứ tự
 * c) key là tên của người sử dụng
 * 
 * Question 8: K & V generic Tạo 1 class có tên là Staff, lưu dữ liệu theo dạng
 * key, value (extends MyMap) Với key là id của Staff (ID có thể là int, long)
 * Với value là tên của Staff Tạo các method a) GetId () b) getName () Viết
 * chương trình demo 4
 * 
 * Exercise 4 (Optional): Wildcard (Generic)
 * 
 * Question 1: Tạo 1 class Salary để đại diện cho datatype là các số a) Hãy
 * config class Salary như sau: Salary <N> với N phải được extends từ
 * Number.class b) Tạo method để print ra salary hiện tại
 * 
 * Question 2: Tạo 1 class MyNumber để đại diện cho datatype là các số Hãy
 * config class MyNumber như sau: MyNumber<N> với N phải được extends từ
 * Number.class
 * 
 * Question 3: T generic (method) Tạo method tính max của 2 số (số nhập vào có
 * thể là float, double, int, long). Demo chương trình
 * 
 * Question 4: T generic (method & class) Tạo class MyMath<T> có thể làm việc
 * được với các số int, long, double và có chứa các method sau: a) tính tổng của
 * 2 số b) tính tổng của 3 số c) tính tổng của 4 số d) tính hiệu của 2 số e) hàm
 * tính số mũ (a,b) Gợi ý: sử dụng optional parameter để làm câu a,b,c. Demo
 * chương trình
 * 
 * Question 5: Tạo 1 cursor như sau: ArrayList <Object> listWildcards. Hãy khởi
 * tạo đối tượng có chứa thông tin của khách hàng (mỗi thông tin là 1 element)
 * và thêm các giá trị vào trong ArrayList như: a) Nguyễn Văn Nam b) 30 tuổi c)
 * Hà đông, Hà nội
 */
