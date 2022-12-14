package com.vti.frontend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.Assignment_2_Exercise_1;
import com.vti.backend.Assignment_2_Exercise_2;
import com.vti.backend.Assignment_2_Exercise_3;
import com.vti.backend.Assignment_2_Exercise_4;
import com.vti.backend.Assignment_2_Exercise_5;
import com.vti.backend.Assignment_2_Exercise_6;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.PositionName;
import com.vti.entity.Question;
import com.vti.entity.TypeName;

public class Assignment_2_Program {
	public static void main(String[] args) {

		// SET DEPARTMENT INFO
		Department d1 = new Department(1, "Sale");
		Department d2 = new Department(2, "Marketing");
		Department d3 = new Department(3, "Technical");

		// SET GROUP INFO
		Group g4 = new Group(4, "Group 4", null);
		Group g5 = new Group(5, "Group 5", null);
		Group g6 = new Group(6, "Group 6", null);

		List<Group> groups1 = new ArrayList<>();
		List<Group> groups2 = new ArrayList<>();
		groups2.add(g4);
		groups2.add(g5);

		List<Group> groups3 = new ArrayList<>();
		groups3.add(g4);
		groups3.add(g5);
		groups3.add(g6);

		// ASK ABOUT THIS Group g4=new Group(4,"Group 4",(2012,12,12));

		// SET POSITION INFO
		Position p1 = new Position(1, PositionName.DEV);
		Position p2 = new Position(2, PositionName.TEST);
		Position p3 = new Position(3, PositionName.PM);
		Position p4 = new Position(4, PositionName.SCRUM_MASTER);

		// SET ACCOUNT INFO
		Account a1 = new Account(1, " 1@gmail.com", "usser1", "name1", d3, groups1, p4, LocalDate.of(2022, 12, 12));
		Account a2 = new Account(2, " 1@gmail.com", "usser2", "name1", d3, groups1, p4, LocalDate.of(2022, 12, 12));
		Account a3 = new Account(3, " 1@gmail.com", "usser3", "name1", d3, groups1, p4, LocalDate.of(2022, 12, 12));
		Account a4 = new Account(4, " 1@gmail.com", "usser4", "name1", d3, groups1, p4, LocalDate.of(2022, 12, 12));
		Account a5 = new Account(5, " 1@gmail.com", "usser5", "name1", d3, groups1, p4, LocalDate.of(2022, 12, 12));

//		System.out.println(a1.toString());
//		System.out.println(d1.toString());

		// SET GROUP INFO
		List<Account> g1Accounts = new ArrayList<>();
		g1Accounts.add(a1);
		g1Accounts.add(a2);

		List<Account> g2Accounts = new ArrayList<>();
		g2Accounts.add(a2);
		g2Accounts.add(a3);

		List<Account> g3Accounts = new ArrayList<>();
		g3Accounts.add(a1);
		g3Accounts.add(a2);
		g3Accounts.add(a3);

		List<Account> allAccounts = new ArrayList<>();
		allAccounts.add(a1);
		allAccounts.add(a2);
		allAccounts.add(a3);
		allAccounts.add(a4);
		allAccounts.add(a5);

		Group g1 = new Group(1, "Group 1", LocalDate.of(2020, 10, 6), g1Accounts);
		Group g2 = new Group(2, "Group 2", LocalDate.of(2020, 10, 6), g2Accounts);
		Group g3 = new Group(3, "Group 3", LocalDate.of(2020, 10, 6), g3Accounts);
		Group g7 = new Group(7, "Group 7", LocalDate.of(2020, 10, 6), allAccounts);

		List<Group> groups = new ArrayList<>();
		groups.add(g1);
		groups.add(g2);
		groups.add(g3);
		groups.add(g4);
		groups.add(g5);
		groups.add(g6);
		groups.add(g7);

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
		com.vti.backend.Assignment_2_Exercise_1 exercise_1 = new Assignment_2_Exercise_1();
		com.vti.backend.Assignment_2_Exercise_2 exercise_2 = new Assignment_2_Exercise_2();
		com.vti.backend.Assignment_2_Exercise_3 exercise_3 = new Assignment_2_Exercise_3();
		com.vti.backend.Assignment_2_Exercise_4 exercise_4 = new Assignment_2_Exercise_4();
		com.vti.backend.Assignment_2_Exercise_5 exercise_5 = new Assignment_2_Exercise_5();
		com.vti.backend.Assignment_2_Exercise_6 exercise_6 = new Assignment_2_Exercise_6();

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
		exercise_5.question8();
		// exercise_5.question9(allAccounts, allGroups);
		// exercise_6.tinhEx(2, 3);

	}
}
