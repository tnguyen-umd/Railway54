package com.vti.backend;

public class MyMath {
	private final float PI = 3.14f;

	public float sum(int a) {
		return a + PI;
	}

	public float getPI() {
		return PI;
	}

}

//Exercise 2 (Optional): Final
//Question 1: final variable
//Tạo class MyMath, khai báo final variable số PI = 3.14
//Viết method sum(int a) và trả về tổng của a và PI
//Thử thay đổi số PI = 3.15 trong method xem có được ko?