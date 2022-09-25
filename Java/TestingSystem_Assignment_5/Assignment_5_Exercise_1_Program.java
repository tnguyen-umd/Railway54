package TestingSystem_Assignment_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.News;

//

//Tạo một class News bao gồm thuộc tính: 
//ID (int), Title (String), PublishDate (String), Author (String), Content (String) và AverageRate (float). 
//Tạo các setter và getter cho từng thuộc tính, riêng AverageRate thì chỉ có getter.

//Implement các method trong interface INews như sau:
//a) Method Display() sẽ in ra Title, PublishDate, Author, Content và AverageRate của tin tức ra console.
//b) Method có tên Calculate() để thiết đặt thuộc tính Khai báo một array có tên Rates kiểu int gồm 3 phần tử
//AverageRate là trung bình cộng của 3 phần tử của array Rates.

//c) Tạo chương trình demo có tên là MyNews và tạo một menu lựa chọn gồm các mục sau:
//1- Insert news, 2 View list news, 3 Average rate, 4 Exit

//Nếu người dùng chọn 1 từ bàn phím thì tạo một object của class News và nhập giá trị cho các thuộc tính Title, 
//PublishDate, Author, Content sau đó yêu cầu người dùng nhập vào 3 đánh giá để lưu vào Rates.

//Nếu người dùng chọn 2 từ bàn phím thì thực thi method Display().
//Nếu người dùng chọn 3 từ bàn phím thì thực hiện method Calculate() để tính đánh giá trung bình, sau đó thực thi method Display().
//Trường hợp người dùng chọn 4 thì sẽ thoát khỏi chương trình.

//Question 2 (Optional): 
//2
//Các thí sinh dự thi đại học bao gồm các thí sinh thi khối A, B, và khối 
//C. Các thí sinh cần quản lý các thông tin sau: Số báo danh, họ tên, địa 
//chỉ, mức ưu tiên.
//Thí sinh thi khối A thi các môn: Toán, Lý, Hoá.
//Thí sinh thi khối B thi các môn: Toán, Hoá, Sinh.
//Thí sinh thi khối C thi các môn: Văn, Sử, Địa.
//a) Xây dựng các class để quản lý các thi sinh dự thi đại học.
//b) Xây dựng interface ITuyenSinh và class TuyenSinh có các 
//chức năng:
//a. Thêm mới thí sinh.
//b. Hiện thị thông tin của thí sinh và khối thi của thí sinh.
//c. Tìm kiếm theo số báo danh.
//d. Thoát khỏi chương trình.

//Question 2 (Optional): Abstract Management
//Tạo 1 class Person chứa các property sau: tên, giới tính, ngày sinh, địa 
//chỉ với đầy đủ getter setter, constructor không tham số, constructor đầy 
//đủ tham số
//a) Viết phương thức inputInfo(), nhập thông tin Person từ bàn 
//phím
//b) Viết phương thức showInfo(), hiển thị tất cả thông tin Person
//3
//Tạo class Student thừa kế Person, lưu trữ các thông tin một sinh viên: 
//Mã sinh viên, Điểm trung bình, Email
//a) Override phương thức inputInfo(), nhập thông tin Student từ 
//bàn phím
//b) Override phương thức showInfo(), hiển thị tất cả thông tin 
//Student
//c) Viết phương thức xét xem Student có được học bổng không? 
//Điểm trung bình từ 8.0 trở lên là được học bổng

public class Assignment_5_Exercise_1_Program {

	static Scanner sc = new Scanner(System.in);
	static List<News> listNews = new ArrayList<News>();
	public static List<Float> rates = new ArrayList<>();

	public static void main(String[] args) {
//		News new1 = new News();
//		new1.Calculate();
		News news = new News();

		while (true) {
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("Please select an option: ");
			System.out.println("1-Insert news");
			System.out.println("2-View list news");
			System.out.println("3-Average rate");
			System.out.println("4-Exit");
			int input = sc.nextInt();

			switch (input) {
			case 1:

				// inserting info for news1
				System.out.println("Please insert news info");

				System.out.println("1-id");
				news.setId(sc.nextInt());
				news.setPublishDate(sc.nextLine());
				System.out.println("2-create date");
				news.setPublishDate(sc.nextLine());
				System.out.println("3-author");
				news.setAuthor(sc.nextLine());
				System.out.println("4-content");
				news.setContent(sc.nextLine());

				// calling the calculate method to calculate the average rate
				// news.Calculate();
				System.out.println("Please input 3 rates");
				float rate1 = sc.nextInt();
				float rate2 = sc.nextInt();
				float rate3 = sc.nextInt();

				rates.add(rate1);
				rates.add(rate2);
				rates.add(rate3);

				listNews.add(news);
				break;

			case 2:
				System.out.println("List of news");
				for (int i = 0; i < listNews.size(); i++) {
					System.out.println(listNews.get(i).toString());
				}
				break;

			case 3:
				news.Calculate();
				for (int i = 0; i < listNews.size(); i++) {
					listNews.get(i).Display();
				}
				break;

			case 4:
				System.out.println("Program terminated");
				return;

			default:
				System.out.println("Please select a correct option");
				break;

			}
		}
	}
}
