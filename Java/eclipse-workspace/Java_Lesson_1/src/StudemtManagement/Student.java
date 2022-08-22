package StudemtManagement;

import java.time.LocalDate;

public class Student {
	short		id;
	byte		age;
	String		birthPlace;
	LocalDate	birthDate;
	Level 		level;
	Duration	duration;//3 or 4 years
	int			credit; // 210 or 150 credits
	Course[]	courses;//student takes courses
	
}
