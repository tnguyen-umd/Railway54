package com.vti.entity;

//Exercise 4 : Encapsulation
//Question 1:
//Tạo Object Student có các property id, name, hometown, điểm học lực
//a) Tất cả các property sẽ để là private để các class khác không
//chỉnh sửa hay nhìn thấy
//b) Tạo constructor cho phép khi khởi tạo mỗi student thì người
//dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
//c) Tạo 1 method cho phép set điểm vào
//d) Tạo 1 method cho phép cộng thêm điểm
public class Student {
	private int id;
	private String name;
	private String hometown;
	private float grade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameString() {
		return name;
	}

	public void setNameString(String nameString) {
		this.name = nameString;
	}

	public String getHometownString() {
		return hometown;
	}

	public void setHometownString(String hometownString) {
		this.hometown = hometownString;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public Student(int id, String nameString, String hometownString, float grade) {
		super();
		this.id = id;
		this.name = nameString;
		this.hometown = hometownString;
		this.grade = grade;
	}

	public void printGrade() {
		if (grade <= 4.0) {
			System.out.println("Hoc sinh " + name + ", Grade = yeu");
		}
		if (grade > 4.0 && grade <= 6.0) {
			System.out.println("Hoc sinh " + name + ", Grade = trung binh");
		}
		if (grade > 6.0 && grade <= 8.0) {
			System.out.println("Hoc sinh " + name + ", Grade = kha");
		}
		if (grade > 8.0) {
			System.out.println("Hoc sinh " + name + ", Grade = gioi");
		}

	}
}

//e) Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên,
//điểm học lực ( 
//nếu điểm<4.0 thì sẽin ralà Yếu, 
//nếu điểm>4.0 và<6.0 thì sẽ in ra là trung bình,
//nếu điểm>6.0 và<8.0 thì sẽ in ra là khá, 
//nếu>8.0 thì in ra là Giỏi)
//Demo các chức năng trên bằng class ở front-end.