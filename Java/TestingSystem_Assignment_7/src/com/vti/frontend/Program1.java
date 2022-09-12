package com.vti.frontend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.ScannerUtils;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

import Utils.FileManager;

public class Program1 {

	static Scanner scanner = new Scanner(System.in);
	static List<Student> students = new ArrayList<>();
	static ScannerUtils su = new ScannerUtils();

	public static void main(String[] args) throws Exception {

		System.out.println("------------------------ * * * ---------------------------");
		System.out.println("Chao mung ban den voi he thong phan mem quan ly sinh vien!!");

		while (true) {
			System.out.println("-------------Moi ban lua chon chuong trinh-------------------");
			System.out.println(
					"1. Thêm mới sinh vien " + "----2. Add primary student " + "----3. Add secondary student ");
			System.out.println("4. Dong quy lop " + "----5. Change school name" + "----6. Thoat chuong trinh"
					+ "----7. Hien thi students");

			int idChucNang = su.inputInt("Wrong input, use integers only");

			switch (idChucNang) {
			case 1:
				addStudent("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Railway54\\abc\\", "Student.ser");
				countStudent();
				countPrimaryStudent();
				countSecondaryStudent();
				break;
			case 2:
				addPrimaryStudent();
				countStudent();
				countPrimaryStudent();
				countSecondaryStudent();
				break;
			case 3:
				addSecondaryStudent();
				countStudent();
				countPrimaryStudent();
				countSecondaryStudent();
				break;
			case 4:
				quyLop();
				break;
			case 5:
				changeCollegeName();
				break;
			case 6:
				System.out.println("Cám ơn bạn đã sử dụng dịch vụ, xin chào và hẹn gặp lại ");
				return;
			case 7:
				showStudent("C:\\Users\\tnguy\\OneDrive\\Documents\\GitHub\\Railway54\\abc\\", "Student.ser");
				break;
			default:
				System.out.println("Nhap sai, moi nhap lai");
				break;
			}
		}
	}

	public static void addStudent(String directory, String fileName) {
		Student student;
		try {
			if (FileManager.checkFolder(directory)) {
				FileOutputStream fileOutputStream = new FileOutputStream(directory + fileName);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				student = new Student();
				students.add(student);

				// write object to file
				objectOutputStream.writeObject(student);

				// write list of object to file
				objectOutputStream.writeObject(students);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FileManager.createFolder(directory);
		}

	}

	public static void addPrimaryStudent() {
		try {
			PrimaryStudent primaryStudent = new PrimaryStudent();
			students.add(primaryStudent);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void addSecondaryStudent() {
		try {
			SecondaryStudent secondaryStudent = new SecondaryStudent();
			students.add(secondaryStudent);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void changeCollegeName() {
		System.out.println("Moi ban nhap vao ten truong");
		String schoolName = scanner.nextLine();
		Student.setCollege(schoolName);
		System.out.println("Truong cua ban da duoc doi thanh: " + schoolName);
	}

	public static void countStudent() {
		System.out.println("Number of students created is: " + Student.getCounter());
	}

	public static void countPrimaryStudent() {
		System.out.println("Number of primary students created is: " + PrimaryStudent.getPrimeCounter());
	}

	public static void countSecondaryStudent() {
		System.out.println("Number of secondary students created is: " + SecondaryStudent.getSecondCounter());
	}

	public static void quyLop() {

		// Quy lop khoi dau
		Student.setMoneyGroup(Student.getMoneyGroup() * students.size());
		System.out.println("Quy lop khoi dau = " + Student.getMoneyGroup());

		// Quy lop sau khi mua ban
		Student.setMoneyGroup(Student.getMoneyGroup() - spendMoney());
		System.out.println("Quy lop sau khi cac hoc sinh mua cac thu = " + Student.getMoneyGroup());

		// Quy lop sau khi hoc sinh dong them tien
		Student.setMoneyGroup(Student.getMoneyGroup() + students.size() * dongQuy());
		System.out.println("Quy lop sau khi dong them vao quy = " + Student.getMoneyGroup());
	}

	public static long spendMoney() {
		System.out.println("Students are buying things");
		System.out.println("Student 1 spent ");
		long x1 = scanner.nextLong();
		System.out.println("Student 2 spent ");
		long x2 = scanner.nextLong();
		System.out.println("Student 3 spent ");
		long x3 = scanner.nextLong();

		long purchase;
		return purchase = x1 + x2 + x3;

	}

	public static long dongQuy() {
		System.out.println("Nhap vao so dien dong quy lop ");
		long addAmount = scanner.nextLong();
		return addAmount;
	}

	public static void showStudent(String directory, String fileName) throws ClassNotFoundException, IOException {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(directory + fileName);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = objectInputStream.readObject();
			objectInputStream.close();

			Student student = (Student) object;
			System.out.println(student.toString());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

//Exercise 3 (Optional): File
//Tạo class FileManager ở package utils, sau đó tất cả các Question trong Exercise này 
//sẽ viết vào trong class FileManager, với mỗi Question sẽ viết demo ở front-end
//Chú ý: tất cả các error message nên để là constant (static final String)

//Question 1: Check File is exists
//Tạo 1 method có đầu vào là String path để check xem path đó có tồn 
//tại hay không.
//VD: path = "C:\Users\pc\Desktop\Test.txt"
// Gợi ý: Tạo method boolean isFileExists(String pathFile)

//Question 2: Create new file
//Tạo 1 method để có thể tạo được file.
//Chú ý:
//Kiểm tra xem file đã tồn tại hay chưa, nếu file đã tồn tại thì sẽ 
//throw ra Exception "Error! File Exist."
//Gợi ý: 
//Tạo method void createNewFile(String pathFile)
//Vào tạo thêm method void createNewFile(String path, String 
//fileName)

//Question 4: Delete file
//Tạo 1 method để có thể delete file
//Chú ý: 
//4
//Kiểm tra xem file đã tồn tại hay chưa, nếu file chưa tồn tại thì 
//sẽ throw ra Exception "Error! File Not Exist."
//Gợi ý: Tạo method void deleteFile(String pathFile)

//Question 5: Check path is File or Folder
//Tạo 1 method để kiểm tra xem path có thể là File hay Folder.
//Gợi ý: Tạo method boolean isFolder(String path)

//Question 6: Get all File name of Folder
//Tạo 1 method để lấy ra tất cả các tên file trong 1 Folder.
//Chú ý: 
//Kiểm tra xem path nhập vào có phải là folder hay không, nếu
//không phải thì sẽ throw ra Exception "Error! Path is not 
//folder."
//Gợi ý: Tạo method List<String> getAllFileName(String path)

//Question 7: Copy File
//Tạo 1 method để copy file.
//Chú ý: 
//Nếu file không tồn tại thì sẽ throw ra Exception "Error! Source 
//File Not Exist."
//Nếu file đích đã tồn tại thì sẽ throw ra Exception "Error! 
//newPath has File same name."
//Gợi ý: 
//Tạo method void copyFile(String sourceFile, String 
//distinationPath, String newName)
//Và tạo method void copyFile(String sourceFile, String 
//newPath). Với File mới sẽ có tên cùng với file cũ 

//Question 8: Moving file
//Tạo 1 method để di chuyển file sang folder khác.
//Chú ý: 
//Nếu file không tồn tại thì sẽ throw ra Exception "Error! File 
//Not Exist.".
//Phải xóa file cũ đi
//Gợi ý: 
//Tạo method void moveFile(String sourceFile, String 
//destinationPath)

//Question 9: Rename File
//Tạo 1 method để đổi tên file.
//Chú ý: 
//Nếu file không tồn tại thì sẽ throw ra Exception "Error! File 
//Not Exist.".
//5
//Nếu newName đã tồn tại thì sẽ throw ra Exception "Error!
//Name is Exist.".
//Gợi ý: 
//Tạo method void renameFile(String pathFile, String 
//newName)

//Question 10: Create new folder
//Tạo 1 method để có thể tạo được folder.
//Chú ý: 
//Kiểm tra xem folder đã tồn tại hay chưa, nếu folder đã tồn tại 
//thì sẽ throw ra Exception "Error! Folder Exist."
//Gợi ý: Tạo method void createNewFolder(String newPathFolder)

//Question 11: Download File
//Hãy viết 1 method để có thể download được file ở trên mạng
//Chú ý: 
//Nếu folder không tồn tại thì sẽ tạo folder.
//Nếu tên file download đã tồn tại trong folder thì sẽ thêm (1), (2) 
//vào sau tên file (giống download file ở window).
//Gợi ý: 
//Tạo method void downloadFile(String fileLink, String 
//folder)

//Code tham khảo

//Exercise 4 (Optional): IO Stream
//Tạo class IOManager ở package utils, sau đó tất cả các Question trong Exercise này 
//sẽ viết vào trong class IOManager, với mỗi Question sẽ viết demo ở front-end
//Chú ý: tất cả các error message nên để là constant (static final String)

//Question 1: Tạo method read File
//Tạo 1 method có đầu vào là String filePath và return ra nội dung trong 
//file.
//Chú ý: 
//Nếu file không tồn tại thì sẽ throw ra Exception "Error! File 
//Not Exist." (sử dụng FileManager ở trên đẻ check)
// Gợi ý: Tạo method String readFile(String pathFile)

//Question 2: Tạo method write content to File
//Tạo 1 method để write file
//Chú ý: 
//Nếu file không tồn tại thì sẽ throw ra Exception "Error! File 
//Not Exist." (sử dụng FileManager ở exercise trên để check)
//Gợi ý: Tạo method void writeFile(String pathFile, isContinuing
//String content)
//Nếu isContinuing = false thì sẽ xóa hết nội dung trong file đi và 
//write content mới vào
//Nếu isContinuing = true thì sẽ ghi content vào cuối file

//Question 3: Tạo method write Object
//Hãy viết 1 method để có thể write object
//Chú ý: 
//Nếu object = null thì sẽ throw ra Exception "Error! Object is 
//Null."
//Nếu folder không tồn tại thì sẽ tạo folder.
//Nếu file đã tồn tại trong folder thì sẽ ghi đè lên file cũ
//Gợi ý: Tạo method void writeObject(Object object, String path, 
//String fileName)

//Question 4: Tạo method read Object
//Tạo 1 method có đầu vào là String filePath và return ra Object
//Chú ý: 
//Nếu file không tồn tại thì sẽ throw ra Exception "Error! File 
//Not Exist." (sử dụng FileManager ở trên để check)
// Gợi ý: Tạo method Object readObject(String filePath)

//Exercise 5: Demo File & IO Stream
//Question 1: Tạo class Student có property id, name. 
//a) Sau đó khởi 3 instance từ console (sử dụng ScannerUtils)
//b) Write 3 student này ra file tên là StudentInformation.txt
//c) Sau đó đọc thông tin file StudentInformation.txt và in ra màn hình

//Question 2: Tạo LogUtils (sử dụng write Object Exception)
//Tạo 1 custom Exception Object, sau đó tại hàm main sẽ bắt exception 
//ko mong muốn và lưu thông tin Exception.ser file
//Các bước làm sẽ như sau:
//B1: Tạo 1 object MyException sẽ extends Exception, trong 
//MyException sẽ chứa các thông tin như: message, reason, StackTrace, 
//time (thời gian bị Exception), …
//B2: Sau đó tạo class LogUtils có 1 vài method như sau:
//1. void writeLog (String message, String reason, StackTrace, 
//Datetime time) (gợi ý: sử dụng IOManager ở trên để write file)
//2. void writeLog (MyException exception)
//B3: đặt try catch ở method main() hoặc ở bất kỳ chỗ nào muốn lưu lại 
//thông tin exception
//B4: Tạo method để đọc thông tin trong file Exception và in ra màn 
//hình
//B5: Demo chương trình

//Question 3 (Optional):
//Thiết kế bài lô đề của exercise trước với những cải tiến về handling 
//exception, đăt các property static, final cho hợp lý và thêm các chức 
//năng sau đây:
//a) Đăng ký tài khoản (thông tin các tài khoản sẽ lưu vào file)
//Có 2 loại tài khoản admin và user.
//b) Đăng nhập vào hệ thống
//c) Đăng xuất tài khoản
//d) Cho phép nạp tiền vào tài khoản (lưu thông tin vào file)
//e) Lưu thông tin kết quả lô đề từng ngày vào file
//f) Lưu thông tin người dùng chơi lô đề vào file
//g) Tạo thêm chức năng sau:
//1) Chỉ có admin mới có thể xem thông tin tất cả các tài 
//khoản (giống table ở SQL khi SELECT * Account, ẩn 
//mật khẩu đi)
//2) Người dùng có thể xem lại thông tin lô đề từng ngày (hệ 
//thống có hỗ trợ chức năng tìm kiếm theo ngày, và lọc 
//chỉ xem từ ngày nào tới ngày nào)
