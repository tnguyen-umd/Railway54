package com.vti.frontend;

import java.util.Scanner;

import com.vti.entity.Student;

public class Program2 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Chuyen truong
		changeCollege();
		System.out.println("Ten truong vua chuyen = " + Student.getCollege());
	}

	public static void changeCollege() {
		System.out.println("Nhap vao ten truong ban muon chuyen");
		String a = scanner.nextLine();
		Student.setCollege(a);
	}

}
