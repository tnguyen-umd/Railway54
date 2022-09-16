package com.vti.backend;

public class MyMath {
	private final float PI = 3.14f;

	public float sum(int a) {
		return a + PI;
	}

	public float getPI() {
		return PI;
	}

	// use comparable to compare 2 values regardless of their primitive type
	public static <T extends Number> void getMax(T a, T b) {
		T number = a;
		if (a.doubleValue() < b.doubleValue()) {
			number = b;
		}
		System.out.println("Max value of the 2 number " + a + " and " + b + " = " + number);
	}

	// sum of 2 generic numbers
	public static <T extends Number> double sum(T a, T b) {

		double x = a.doubleValue() + b.doubleValue();
		System.out.println("Tong 2 so: " + a + " and " + b + " = " + x);
		return x;
	}

	// sum of 3 generic numbers
	public static <T extends Number> double sum(T a, T b, T c) {

		double x = a.doubleValue() + b.doubleValue() + c.doubleValue();
		System.out.println("Tong 3 so: " + a + " and " + b + " and " + c + " = " + x);
		return x;
	}

	// sum of 4 generic numbers
	public static <T extends Number> double sum(T a, T b, T c, T d) {

		double x = a.doubleValue() + b.doubleValue() + c.doubleValue() + d.doubleValue();
		System.out.println("Tong 4 so: " + a + " and " + b + " and " + c + " and " + d + " = " + x);
		return x;
	}

	// subtraction of 2 generic numbers
	public static <T extends Number> double subtract(T a, T b) {

		double x = a.doubleValue() - b.doubleValue();
		System.out.println("Hieu 2 so: " + a + " and " + b + " = " + x);
		return x;
	}

	// power of 2 generic numbers
	public static <T extends Number> double power(T a, T b) {

		double x = Math.pow(a.doubleValue(), b.doubleValue());
		System.out.println("mu 2 so: " + a + " and " + b + " = " + x);
		return x;
	}

}

//Exercise 2 (Optional): Final
//Question 1: final variable
//Tạo class MyMath, khai báo final variable số PI = 3.14
//Viết method sum(int a) và trả về tổng của a và PI
//Thử thay đổi số PI = 3.15 trong method xem có được ko?