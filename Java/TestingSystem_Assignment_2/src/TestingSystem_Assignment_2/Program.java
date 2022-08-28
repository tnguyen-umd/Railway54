package TestingSystem_Assignment_2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Program {
	public static void main(String[] args) {

		// SET DEPARTMENT INFO
		Department d1 = new Department(1, "Sale");
		Department d2 = new Department(2, "Marketing");
		Department d3 = new Department(3, "Technical");

		// SET GROUP INFO
		Group g4 = new Group(4, "Group 4", null);
		Group g5 = new Group(5, "Group 5", null);
		Group g6 = new Group(6, "Group 6", null);

		Group[] groups1 = {};
		Group[] groups2 = { g4 };
		Group[] groups3 = { g4, g5, g6 };

		// ASK ABOUT THIS Group g4=new Group(4,"Group 4",(2012,12,12));

		// SET POSITION INFO
		Position p1 = new Position(1, PositionName.DEV);
		Position p2 = new Position(2, PositionName.TEST);
		Position p3 = new Position(3, PositionName.PM);
		Position p4 = new Position(4, PositionName.SCRUM_MASTER);

		// SET ACCOUNT INFO
		Account a1 = new Account(1, "anguyen@gmail.com", "anguyen", "Nguyen Van A", d1, groups1, p1,
				LocalDate.of(2021, 12, 12));
		Account a2 = new Account(2, "Bnguyen@gmail.com", "Bnguyen", "Nguyen Van B", d2, groups2, p2,
				LocalDate.of(2022, 12, 12));
		Account a3 = new Account(3, "Cnguyen@gmail.com", "Cnguyen", "Nguyen Van C", d3, groups3, p3,
				LocalDate.of(2021, 1, 1));
		Account a4 = new Account(4, "Dnguyen@gmail.com", "Dnguyen", "Nguyen Van D", d1, groups3, p3,
				LocalDate.of(2021, 1, 1));
		Account a5 = new Account(5, "Enguyen@gmail.com", "Enguyen", "Nguyen Van E", d3, groups3, p3,
				LocalDate.of(2021, 1, 1));
		;
//		System.out.println(a1.toString());
//		System.out.println(d1.toString());

		// SET GROUP INFO
		Account[] g1Accounts = { a1, a2 };
		Account[] g2Accounts = { a2, a3 };
		Account[] g3Accounts = { a1, a2, a3 };
		Account[] allAccounts = { a1, a2, a3, a4, a5 };

		Group g1 = new Group(1, "Group 1", g1Accounts, LocalDate.of(2015, 10, 10));
		Group g2 = new Group(2, "Group 2", g2Accounts, LocalDate.of(2020, 10, 6));
		Group g3 = new Group(3, "Group 3", g3Accounts, LocalDate.of(2022, 10, 10));
		Group g7 = new Group(7, "Group 7", allAccounts, LocalDate.of(2022, 10, 10));
		Group[] allGroups = { g1, g2, g3, g4, g5, g6 };

		Question q1 = new Question(1, "Java question", TypeName.ESSAY, "Java", a1, LocalDate.of(2022, 11, 2));
		Question q2 = new Question(2, "Ruby question", TypeName.MULTIPLE_CHOICE, "Ruby", a2, LocalDate.of(2021, 10, 2));
		Question q3 = new Question(3, "C# question", TypeName.ESSAY, "C#", a3, LocalDate.of(2022, 11, 2));

		Question[] ex1Questions = { q1, q2 };
		Question[] ex2Questions = { q2, q3 };

		Exam ex1 = new Exam(1, "EX001", "Java Core", "Elementary", ex1Questions, 120, g3Accounts,
				LocalDateTime.of(2022, 11, 2, 11, 30));
		Exam ex2 = new Exam(2, "EX002", "Ruby Core", "Elementary", ex2Questions, 120, g3Accounts,
				LocalDateTime.of(2022, 10, 21, 12, 30));

		// CALL METHODS FROM EXERCISE 1
		Exercise_1 exercise_1 = new Exercise_1();
		Exercise_2 exercise_2 = new Exercise_2();
		Exercise_3 exercise_3 = new Exercise_3();
		Exercise_4 exercise_4 = new Exercise_4();
		Exercise_5 exercise_5 = new Exercise_5();
		Exercise_6 exercise_6 = new Exercise_6();

		Department[] departments = { d1, d2, d3 };

//		exercise_1.question1(a1);
//		exercise_1.question2(a3);
//		exercise_1.question3(a2);
//		exercise_1.question4(a2);
//		exercise_1.question5(g7);
//		exercise_1.question6(a3);
//		exercise_1.question7(a3);
//		System.out.println(a1.toString());
//		exercise_1.question8(g1Accounts);
//		exercise_1.question11(departments);
//		exercise_1.question12(departments);
//		exercise_1.question13(g3Accounts);
//		exercise_1.question14(g4Accounts);
//		exercise_1.question15(20);
//		exercise_6.question1();
		// exercise_6.question3();

		// exercise_2.question1();
		// exercise_2.question2();
		// exercise_2.question3();
		// exercise_2.question4();
		// exercise_2.question5();
		// exercise_2.question6(g3Accounts);

		// exercise_3.question1(ex1);
		// exercise_3.question2(ex1);
		// exercise_3.question3(ex1);
		// exercise_3.question4(ex1);
		// exercise_3.question5(ex1);
//		exercise_5.question8();
		// exercise_5.question9(allAccounts, allGroups);
		exercise_6.tinhEx(2, 3);

	}
}
