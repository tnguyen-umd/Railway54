package StudemtManagement;

import java.time.LocalDate;

public class MAIN {
public static void main(String[]args) {
	Homework hw1=new Homework();
	hw1.id=1;
	hw1.name="Homework 1";
	hw1.isType=Type.ESSAY;
	hw1.createDate=LocalDate.of(2021, 10, 12);
	hw1.dueDate=LocalDate.of(2021, 10, 31);

	Homework hw2=new Homework();
	hw2.id=2;
	hw2.name="Homework 2";
	hw2.isType=Type.MULTIPLE_CHOICE;
	hw2.createDate=LocalDate.of(2021, 11, 12);
	hw2.dueDate=LocalDate.of(2021, 11, 31);
	
	Homework hw3=new Homework();
	hw3.id=3;
	hw3.name="Homework 3";
	hw3.isType=Type.MULTIPLE_CHOICE;
	hw3.createDate=LocalDate.of(2021, 12, 12);
	hw3.dueDate=LocalDate.of(2021, 12, 31);
//--------------------------------------------------------------------
	Exam exam1=new Exam();
	exam1.id=1;
	exam1.name="Mid-term";
	exam1.isType=Type.ESSAY;
	exam1.date=LocalDate.of(2021, 11, 15);
	
	Exam exam2=new Exam();
	exam2.id=2;
	exam2.name="Final";
	exam2.isType=Type.ESSAY;
	exam2.date=LocalDate.of(2021, 12, 15);
	//--------------------------------------------------------------------
	
	Course course1=new Course();
	course1.id=1;
	course1.maxStudent=20;
	course1.name="Database";
	course1.duration=9; // number of weeks
	Homework[]	course1Homework= {hw1,hw2,hw3};//assign 3 homeworks to course 1 array
	course1.homeworks=course1Homework;
	
	Exam[]	course1Exam= {exam1,exam2};//assign 2 exams to course 1 array
	course1.exams=course1Exam;
	
	Course course2=new Course();
	course2.id=2;
	course2.maxStudent=25;
	course2.name="Database";
	course2.duration=9; // number of weeks
	Homework[]	course2Homework= {hw1,hw2,hw3};//assign 3 homeworks to course 1 array
	course2.homeworks=course2Homework;
	
	Exam[]	course2Exam= {exam1,exam2};//assign 2 exams to course 1 array
	course2.exams=course2Exam;
	
//------------------------------------------------------------------------------------------------
	
	
	//PRINT OUT INFO
	//System.out.println("Thong tin exam 1");
	//System.out.println("id: " + ex1.id);
	//System.out.println("Content: " + ex1.code);
	//System.out.println("Questions on this exam: " + ex1.questions);// need to change to print array
	//System.out.println("Question type: " + ex1.title);
	//System.out.println("Category: " + ex1.category);
	////System.out.println("Created by: " + ex1.duration);
	//System.out.println("Exam taken by: " + ex1.accounts);// need to change to print array
	//System.out.println("Created on: " + ex1.createDate);
	//System.out.println("\n");

}}








