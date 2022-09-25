package TestingSystem_Assignment_1;

import java.time.LocalDate;

public class Program {
public static void main(String[]args) {
	System.out.println();
	//logic
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
	
	Group g1=new Group();
	g1.id=1;
	g1.name="Travelers";
	g1.createDate=LocalDate.now();
	
	Group g2=new Group();
	g2.id=2;
	g2.name="Musicians";
	g2.createDate=LocalDate.now();
	
	Group g3=new Group();
	g3.id=3;
	g3.name="Drummers";
	g3.createDate=LocalDate.now();
	
	Account a1=new Account();
	a1.id=1;
	a1.Email="anguyen@gmail.com";
	a1.userName="anguyen";
	a1.fullName="Nguyen Van A";
	a1.department=department1;
	
	//assign 2 groups to account a1 using ARRAY
	Group[] a1Group= {g1,g2};
	a1.groups=a1Group;
	
	a1.position=position1;
	a1.createDate=LocalDate.of(2020,1,13);
	
	Account a2=new Account();
	a2.id=2;
	a2.Email="bnguyen@gmail.com";
	a2.userName="bnguyen";
	a2.fullName="Nguyen Van B";
	a2.department=department2;
	
	//assign 2 groups to account a1 using ARRAY
	Group[] a2Group= {g2,g3};
	a2.groups=a2Group;
	
	a2.position=position2;
	a2.createDate=LocalDate.of(2021,11,13);

	Account a3=new Account();
	a3.id=3;
	a3.Email="cnguyen@gmail.com";
	a3.userName="cnguyen";
	a3.fullName="Nguyen Van C";
	a3.department=department3;
	
	//assign 2 groups to account a1 using ARRAY
	Group[] a3Group= {g2,g3};
	a3.groups=a3Group;
	
	a3.position=position3;
	a3.createDate=LocalDate.of(2022,11,13);
	
	Question q1=new Question();
	q1.id=1;
	q1.content="Java question";
	q1.category="Java";
	q1.isQuestionType=TypeName.ESSAY;
	q1.account=a1;
	q1.createDate=LocalDate.now();
	
	Question q2=new Question();
	q2.id=2;
	q2.content="Ruby question";
	q2.category="Ruby";
	q2.isQuestionType=TypeName.MULTIPLE_CHOICE;
	q2.account=a2;
	q2.createDate=LocalDate.of(2021,10,23);
	
	Question q3=new Question();
	q3.id=2;
	q3.content="SQL question";
	q3.category="SQL";
	q3.isQuestionType=TypeName.MULTIPLE_CHOICE;
	q3.account=a3;
	q3.createDate=LocalDate.of(2022,1,23);
	
	Answer an1=new Answer();
	an1.id=1;
	an1.content="Java answer 1";
	an1.question=q1;
	an1.isCorrect=true;
	
	Answer an2=new Answer();
	an2.id=2;
	an2.content="Ruby answer 1";
	an2.question=q2;
	an2.isCorrect=false;
	
	Answer an3=new Answer();
	an3.id=3;
	an3.content="SQL answer 1";
	an3.question=q3;
	an3.isCorrect=true;
	
	
	Exam ex1=new Exam();
	ex1.id=1;
	ex1.code="EX001";
	ex1.title="First exam";
	ex1.category="First level";
	
	//exam1 has 2 questions q1 and q2
	Question[]	ex1Question= {q1,q2};
	ex1.questions=ex1Question;
	
	ex1.duration=120;
	
	//exam1 has 3 users a1, a2, a3
	Account[]	ex1Account= {a1,a2,a3};
	ex1.accounts=ex1Account;

	ex1.createDate=LocalDate.of(2021, 12, 31);
	
	System.out.println("Thong tin phong ban 1");
	System.out.println("name: " + department1.name);
	System.out.println("id: " + department1.id);
	System.out.println("\n");
	
	System.out.println("Thong tin account 1");
	System.out.println("id: " + a1.id);
	System.out.println("Email: " + a1.Email);
	System.out.println("Fullname: " + a1.fullName);
	System.out.println("Department: " + a1.department);
	System.out.println("Group: " + a1.groups);
	System.out.println("Position: " + a1.position);
	System.out.println("Join date: " + a1.createDate);
	System.out.println("\n");
	
	System.out.println("Thong tin group 1");
	System.out.println("id: " + g1.id);
	System.out.println("Name: " + g1.name);
	System.out.println("Created on: " + g1.createDate);
	System.out.println("\n");
	
	System.out.println("Thong tin question 1");
	System.out.println("id: " + q1.id);
	System.out.println("Content: " + q1.content);
	System.out.println("Question type: " + q1.isQuestionType);
	System.out.println("Category: " + q1.category);
	System.out.println("Created by: " + q1.account);
	System.out.println("Created on: " + q1.createDate);
	System.out.println("\n");
	
	System.out.println("Thong tin answer 1");
	System.out.println("id: " + an1.id);
	System.out.println("Content: " + an1.content);
	System.out.println("Which question: " + an1.question);
	System.out.println("Answer is correct: " + an1.isCorrect);
	System.out.println("\n");
	
	System.out.println("Thong tin exam 1");
	System.out.println("id: " + ex1.id);
	System.out.println("Content: " + ex1.code);
	System.out.println("Questions on this exam: " + ex1.questions);// need to change to print array
	System.out.println("Question type: " + ex1.title);
	System.out.println("Category: " + ex1.category);
	System.out.println("Created by: " + ex1.duration);
	System.out.println("Exam taken by: " + ex1.accounts);// need to change to print array
	System.out.println("Created on: " + ex1.createDate);
	System.out.println("\n");

}}



