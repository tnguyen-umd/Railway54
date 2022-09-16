package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.GenericStudent;
import com.vti.entity.Student;

public class Program3 {

	public static void main(String[] args) {
		GenericStudent<Integer> student1 = new GenericStudent<Integer>(1, "A");
		GenericStudent<Float> student2 = new GenericStudent<Float>(2.0f, "B");
		GenericStudent<Double> student3 = new GenericStudent<Double>(3.0d, "C");

		List<Integer> integerArray = new ArrayList<Integer>();
		List<Float> floatArray = new ArrayList<Float>();
		List<Double> doubleArray = new ArrayList<Double>();

		Student student4 = new Student("A");
		Student student5 = new Student("B");
		Student student6 = new Student("C");

		integerArray.add(1);
		integerArray.add(2);
		integerArray.add(3);
		floatArray.add(1.1f);
		floatArray.add(1.2f);
		floatArray.add(1.3f);
		doubleArray.add(2.1);
		doubleArray.add(2.2);
		doubleArray.add(2.3);

		/*
		 * Exercise 3: Generic
		 * 
		 * Question 1: T generic (class) Tạo class student có property id, name (trong
		 * đó id của student có thể là int, long, float) a) Tạo đối tượng student có id
		 * là int b) Tạo đối tượng student có id là float c) Tạo đối tượng student có id
		 * là double
		 * 
		 * Question 2: T generic (method) Tạo method để in ra thông tin nhập vào
		 * (parameter) (parameter có thể là họ và tên, hoặc student, hoặc int) Gợi ý:
		 * tạo method print(T a) và cài đặt system out (a) ra Demo chương trình với
		 * print(student), print(4), print(4.0)
		 */
		print(student3);

//		 * Question 4: E generic Tạo 1 array int, 1 array float, 1 array long, 1 array
//		 * double Tạo 1 method có parameter là array và in ra các số trong array đó
		printArray(doubleArray);

		// create employee with name and salaries array
		Employee<Double> employee1 = new Employee<>("A", doubleArray);
		// print out last index of an array
		System.out.println(doubleArray.get(doubleArray.size() - 1));

	}

//	 * Question 5: E generic 3 Tạo 1 class Employee có property id, name, salaries
//	 * với salaries là lương các tháng của Employee đó và là 1 array có data type có
//	 * thể là int, long, float. Viết method trong Employee để in ra thông tin của
//	 * Employee bao gồm id, name, salaris. Viết method trong Employee để in ra thông
//	 * tin tháng lương cuối cùng của Employee
//	 * 
//	 * a) Hãy tạo chương trình demo vớis Employee có salaries là datatype int
//	 * 
//	 * b) Hãy tạo chương trình demo với Employee có salaries là datatype float
//	 * 
//	 * c) Hãy tạo chương trình demo với Employee có salaries là datatype double
	// create a generic method to print student with different number types
	static <T> void print(GenericStudent student1) {
		System.out.println(student1.toString());
	}

	// create a generic method to print arrays with different number types
	static <E> void printArray(List<E> array) {
		for (E e : array) {
			System.out.println(e);
		}
	}
}

/*
 * Exercise 3 Question 6: K & V generic
 * 
 * Tạo 1 class có tên là MyMap, lưu dữ liệu theo dạng key, value Tạo các method
 * a) GetValue() b) getKey () Viết chương trình demo: tạo 1 object Student có
 * key là Mã sinh viên và value là tên của sinh viên đó
 * 
 * Question 7: K & V generic Tạo 1 class có tên là Phone, lưu dữ liệu theo dạng
 * key, value (extends MyMap) Với key là email hoặc là số thứ tự hoặc là tên
 * người sử dụng Với value là số điện thoại Tạo các method a) GetPhoneNumber()
 * b) getKey () Viết chương trình demo với a) key là email b) key là số thứ tự
 * c) key là tên của người sử dụng
 * 
 * Question 8: K & V generic Tạo 1 class có tên là Staff, lưu dữ liệu theo dạng
 * key, value (extends MyMap) Với key là id của Staff (ID có thể là int, long)
 * Với value là tên của Staff Tạo các method a) GetId () b) getName () Viết
 * chương trình demo 4
 * 
 * 
 * =========================SKIP===========================================
 * Question 2: Tạo 1 class MyNumber để đại diện cho datatype là các số Hãy
 * config class MyNumber như sau: MyNumber<N> với N phải được extends từ
 * Number.class
 */
