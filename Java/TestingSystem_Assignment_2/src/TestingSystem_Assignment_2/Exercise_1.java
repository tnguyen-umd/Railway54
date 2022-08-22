package TestingSystem_Assignment_2;

import java.time.LocalDate;

/*Exercise 1 (Optional): Flow Control
IF


Question 3:
	Sử dụng toán tử ternary để làm Question 1
Question 4:
	Sử dụng toán tử ternary để làm yêu cầu sau:
	Kiểm tra Position của account thứ 1
	Nếu Position = Dev thì in ra text "Đây là Developer"
	Nếu không phải thì in ra text "Người này không phải là Developer"
SWITCH CASE
Question 5:
	Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
	Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
	Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
	Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
	Còn lại in ra "Nhóm có nhiều thành viên"

Question 6: 
	Sử dụng switch case để làm lại Question 2
Question 7: 
	Sử dụng switch case để làm lại Question 4
	FOREACH
Question 8: 
	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của 	họ
Question 9: 
	In ra thông tin các phòng ban bao gồm: id và name
FOR
Question 10: 
	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của 
	họ theo định dạng như sau:
	Thông tin account thứ 1 là: 
	Email: NguyenVanA@gmail.com
	Full name: Nguyễn Văn A
	Phòng ban: Sale
	Thông tin account thứ 2 là: 
	Email: NguyenVanB@gmail.com
	Full name: Nguyễn Văn B
	Phòng ban: Marketting
	Question 11: 
	In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau: 
	Thông tin department thứ 1 là: 
	Id: 1
	Name: Sale
	Thông tin department thứ 2 là: 
	Id: 2
	Name: Marketing
Question 12: 
	Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
	Question 13: 
	In ra thông tin tất cả các account ngoại trừ account thứ 2
Question 14: 
	In ra thông tin tất cả các account có id < 4
	Question 15: 
	In ra các số chẵn nhỏ hơn hoặc bằng 20

WHILE
Question 16:
	Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với 
	lệnh break, continue
	DO-WHILE
Question 17:
	Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với 
	lệnh break, continue*/




public class Exercise_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//SET DEPARTMENT INFO
		Department d1=new Department();
		d1.setID(1);
		d1.setName("Sale");
		
		Department d2=new Department();
		d2.setID(2);
		d2.setName("Marketing");
		
		Department d3=new Department();
		d3.setID(3);
		d3.setName("Technical");
		
		//SET POSITION INFO		
		Position p1=new Position();
		p1.setID(1);
		p1.setPositionName(PositionName.DEV);
		
		Position p2=new Position();
		p2.setID(2);
		p2.setPositionName(PositionName.TEST);
		
		Position p3=new Position();
		p3.setID(3);
		p3.setPositionName(PositionName.PM);
		
		Position p4=new Position();
		p4.setID(4);
		p4.setPositionName(PositionName.SCRUM_MASTER);
		
		//SET GROUP INFO
		Group g1=new Group();
		g1.setID(1);
		g1.setName("Group 1");
		
		Group g2=new Group();
		g2.setID(2);
		g2.setName("Group 2");
		
		Group g3=new Group();
		g3.setID(3);
		g3.setName("Group 3");

		//SET ACCOUNT INFO
		Account account1=new Account();
		account1.setID(1);
		account1.setName("Nguyen Van A");
		account1.setDepartment(d1);
		account1.setEmail("anguyen@gmail.com");
		account1.setUserName("anguyen");
		account1.setPosition(p1);
		//account1.setCreateDate.parse(2021,11,13);
		
		Group[] account1Groups=
		account1.setGroups{g1,g2};
		
		Account account2=new Account();
		account2.setID(2);
		account2.setName("Nguyen Van B");
		account2.setDepartment(d2);
		account2.setEmail("bnguyen@gmail.com");
		account2.setUserName("bnguyen");
		account2.setPosition(p2);
		//account1.setCreateDate(2021,11,13);
		
		Account account3=new Account();
		account3.setID(2);
		account3.setName("Nguyen Van C");
		account3.setDepartment(d2);
		account3.setEmail("cnguyen@gmail.com");
		account3.setUserName("cnguyen");
		account3.setPosition(p3);
		//account1.setCreateDate(2021,11,13);
		
		//System.out.println(account3.getName());
		//System.out.println(account3.getDepartment().getName());

		

		/*Question 1:
		Kiểm tra account thứ 2
		Nếu không có phòng ban (tức là department == null) thì sẽ in ra text 
		"Nhân viên này chưa có phòng ban"
		Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"*/
		
		
			if (account2.getDepartment().getName()==null) {
				System.out.println("Nhân viên này chưa có phòng ban");
			} else {
				System.out.println("Phòng ban của nhân viên này là : " + account2.getDepartment().getName());
			}
		
		
			/*
			 * Question 2: Kiểm tra account thứ 2 Nếu không có group thì sẽ in ra text
			 * "Nhân viên này chưa có group" Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra
			 * text "Group của nhân viên này là Java Fresher, C# Fresher" Nếu có mặt trong 3
			 * Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều
			 * group" Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
			 * người hóng chuyện, tham gia tất cả các group"
			 */
			
			/*
			 * if (account2.groups.length==0) {
			 * System.out.println("Nhân viên này chưa có group"); } else if
			 * (account2.groups.length==1 || account2.groups.length==2){
			 * System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			 * 
			 * 
			 * //this is how to print out the values of array a2Group that belongs to the
			 * Group for (Group group : a2Group) { System.out.println(group.name); }
			 * 
			 * } else if (account2.groups.length==3 ) {
			 * System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group"
			 * ); } else { System.out.
			 * println("Nhân viên này là người hóng chuyện, tham gia tất cả các group"); }
			 */
	
	}

}
