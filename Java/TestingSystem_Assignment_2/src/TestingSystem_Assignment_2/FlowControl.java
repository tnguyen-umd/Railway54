package TestingSystem_Assignment_2;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class FlowControl {

	public static void main(String[] args) {

		Department department1=new Department();
		department1.id=1;
		department1.name="Sale";
		
		Department department2=new Department();
		department2.id=2;
		department2.name="Marketing";
		
		Department department3=new Department();
		department3.id=3;
		department3.name="Phong Cho";
		
		Position position1=new Position();
		position1.id=1;
		position1.isPosition=PositionName.DEV;
		
		Position position2=new Position();
		position2.id=2;
		position2.isPosition=PositionName.TEST;
		
		Position position3=new Position();
		position3.id=3;
		position3.isPosition=PositionName.PM;
		
		Group group1=new Group();
		group1.id=1;
		group1.name="Travelers";
		group1.createDate=LocalDate.now();
		
		Group group2=new Group();
		group2.id=2;
		group2.name="Musicians";
		group2.createDate=LocalDate.now();
		
		Group group3=new Group();
		group3.id=3;
		group3.name="Drummers";
		group3.createDate=LocalDate.now();
		
		Account account1=new Account();
		account1.id=1;
		account1.Email="anguyen@gmail.com";
		account1.userName="anguyen";
		account1.fullName="Nguyen Van A";
		account1.department=department1;
		
		//assign 2 groups to account a1 using ARRAY
		Group[] a1Group= {group1,group2};
		account1.groups=a1Group;
		
		account1.position=position1;
		account1.createDate=LocalDate.of(2020,1,13);
		
		Account account2=new Account();
		account2.id=2;
		account2.Email="bnguyen@gmail.com";
		account2.userName="bnguyen";
		account2.fullName="Nguyen Van B";
		account2.department=department2;
		
		//assign 2 groups to account a1 using ARRAY
		Group[] a2Group= {group2,group3};
		account2.groups=a2Group;
		
		account2.position=position2;
		account2.createDate=LocalDate.of(2021,11,13);

		Account account3=new Account();
		account3.id=3;
		account3.Email="cnguyen@gmail.com";
		account3.userName="cnguyen";
		account3.fullName="Nguyen Van C";
		account3.department=department3;
		
		//assign 2 groups to account a1 using ARRAY
		Group[] a3Group= {group2,group3};
		account3.groups=a3Group;
		
		account3.position=position3;
		account3.createDate=LocalDate.of(2022,11,13);
		
		Question question1=new Question();
		question1.id=1;
		question1.content="Java question";
		question1.category="Java";
		question1.isQuestionType=TypeName.ESSAY;
		question1.account=account1;
		question1.createDate=LocalDate.now();
		
		Question question2=new Question();
		question2.id=2;
		question2.content="Ruby question";
		question2.category="Ruby";
		question2.isQuestionType=TypeName.MULTIPLE_CHOICE;
		question2.account=account2;
		question2.createDate=LocalDate.of(2021,10,23);
		
		Question question3=new Question();
		question3.id=2;
		question3.content="SQL question";
		question3.category="SQL";
		question3.isQuestionType=TypeName.MULTIPLE_CHOICE;
		question3.account=account3;
		question3.createDate=LocalDate.of(2022,1,23);
		
		Answer an1=new Answer();
		an1.id=1;
		an1.content="Java answer 1";
		an1.question=question1;
		an1.isCorrect=true;
		
		Answer an2=new Answer();
		an2.id=2;
		an2.content="Ruby answer 1";
		an2.question=question2;
		an2.isCorrect=false;
		
		Answer an3=new Answer();
		an3.id=3;
		an3.content="SQL answer 1";
		an3.question=question3;
		an3.isCorrect=true;
		
		
		Exam ex1=new Exam();
		ex1.id=1;
		ex1.code="EX001";
		ex1.title="First exam";
		ex1.category="First level";
		
		//exam1 has 2 questions q1 and q2
		Question[]	ex1Question= {question1,question2};
		ex1.questions=ex1Question;
		
		ex1.duration=120;
		
		//exam1 has 3 users a1, a2, a3
		Account[]	ex1Account= {account1,account2,account3};
		ex1.accounts=ex1Account;

		ex1.createDate=LocalDate.of(2021, 12, 31);
		
		//Question 1:
			//Kiểm tra account thứ 2
			//Nếu không có phòng ban (tức là department == null) thì sẽ in ra text 
			//"Nhân viên này chưa có phòng ban"
			//Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"		
		
		if(account2.department==null) {
			System.out.println("this account does not have a department");
		} else {
			System.out.println("The department of this account is: " + account2.department.name);
		}
		
		/*
		 * System.out.println(g1.createDate); Locale locale = new Locale("vi","VN");
		 * DateFormat dateformat=DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
		 * String date = dateformat.format(g1.createDate);
		 * System.out.println("Group g1 was created on " + date);
		 */
		
		/*
		 * //Question 2: // Kiểm tra account thứ 2 //Nếu không có group thì sẽ in ra
		 * text "Nhân viên này chưa có group"
		 * 
		 * //Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text
		 * "Group của nhân viên này là Java Fresher, C# Fresher" //Nếu có mặt trong 3
		 * Group thì sẽ in ra text
		 * "Nhân viên này là người quan trọng, tham gia nhiều group" //Nếu có mặt trong
		 * 4 group trở lên thì sẽ in ra text
		 * "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
		 */	
				
	

	
	}

}
