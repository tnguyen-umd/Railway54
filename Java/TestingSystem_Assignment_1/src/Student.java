package TestingSystem_Assignment_1;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Student {
	byte 	age;
	float 	salary;
	char	firstCharacter;// char only has 1 character
	String	fullName;
	String	firstName;
	String	description;
	boolean	isMale; // true or false,use isName...
	Date	birthday;
	Calendar  	createDate;
	Gender	Gender;//enum must be have its own class
	String[] fullNames; // this is an array of strings
	byte[] 	Points; //array of numbers
}
