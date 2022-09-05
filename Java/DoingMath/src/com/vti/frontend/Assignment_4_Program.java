package com.vti.frontend;

import com.vti.entity.Student;

//
//JAVA – Assignment 4
//Exercise 1 (Optional): Constructor
//Question 1:
//Tạo constructor cho department:
//a) không có parameters
//b) Có 1 parameter là nameDepartment và default id của
//Department = 0
//Khởi tạo 1 Object với mỗi constructor ở trên
//-------------------------------------------------------------------------------------------------------------------------------

//Question 2:
//Tạo constructor cho Account:
//a) Không có parameters
//b) Có các parameter là id, Email, Username, FirstName,
//LastName (với FullName = FirstName + LastName)
//c) Có các parameter là id, Email, Username, FirstName,
//LastName (với FullName = FirstName + LastName) và
//Position của User, default createDate = now
//d) Có các parameter là id, Email, Username, FirstName,
//LastName (với FullName = FirstName + LastName) và
//Position của User, createDate
//Khởi tạo 1 Object với mỗi constructor ở trên
//-------------------------------------------------------------------------------------------------------------------------------

//Question 3:
//Tạo constructor cho Group:
//a) không có parameters
//b) Có các parameter là GroupName, Creator, array Account[]
//accounts, CreateDate
//c) Có các parameter là GroupName, Creator, array String[]
//usernames , CreateDate
//Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin
//username, các thông tin còn lại = null).
//Khởi tạo 1 Object với mỗi constructor ở trên
//-------------------------------------------------------------------------------------------------------------------------------

//Exercise 2: Package----------DONE-----------------------------------------
//Question 1:
//Tạo các package có tên như sau:
//o com.vti.entity
//o com.vti.frontend
//o com.vti.backend
//-------------------------------------------------------------------------------------------------------------------------------

//Question 2: Package----------DONE-----------------------------------------
//Trong package entity ta sẽ copy các Object đã tạo từ bài hôm trước
//như: Department, Account, Group, …
//Trong phần backend tạo các class Excercise1, Excercise2, Excercise3,
//… Mỗi method trong mỗi Exercise là 1 question.
//Trong front-end tạo các class Program1, Program2, Program3, … để
//demo kết quả của các Excercise1, Excercise2, Excercise3, …
//-------------------------------------------------------------------------------------------------------------------------------

//Exercise 3: Access Modifier----------DONE-----------------------------------------
//Question 1: private access modifier
//Thay đổi access modifier và tạo getter/ setter của những class trong
//package entity, frontend, backend cho phù hợp
//Gợi ý:
//o Các class trong package entity thì để access modifier của
//property là private và tạo getter, setter cho từng property.
//o Các method là các question ở package back-end sẽ để là public
//để các class ở frontend có thể gọi được (không để static).
//-------------------------------------------------------------------------------------------------------------------------------

//Exercise 4 : Encapsulation
//Question 1:
//Tạo Object Student có các property id, name, hometown, điểm học lực
//a) Tất cả các property sẽ để là private để các class khác không
//chỉnh sửa hay nhìn thấy
//b) Tạo constructor cho phép khi khởi tạo mỗi student thì người
//dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
//c) Tạo 1 method cho phép set điểm vào
//d) Tạo 1 method cho phép cộng thêm điểm
//e) Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên,
//điểm học lực ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm >
//4.0 và < 6.0 thì sẽ in ra là trung bình, nếu điểm > 6.0 và < 8.0
//thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi)
//Demo các chức năng trên bằng class ở front-end.
public class Assignment_4_Program {

	public static void main(String[] args) {
		Student student1 = new Student(1, "Mr. A", "Hanoi", 2.5f);
		Student student2 = new Student(2, "Mr. B", "Hanoi", 4.5f);
		Student student3 = new Student(3, "Mr. C", "Hanoi", 6.5f);
		Student student4 = new Student(4, "Mr. D", "Hanoi", 8.5f);

		student1.printGrade();
		student2.printGrade();
		student3.printGrade();
		student4.printGrade();
	}

}
