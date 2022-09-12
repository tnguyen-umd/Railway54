package com.vti.entity;

public class SecondaryStudent extends Student {
	private static int SecondCounter;

	public SecondaryStudent() throws Exception {
		super();
		SecondCounter++;
	}

	public static int getSecondCounter() {
		return SecondCounter;
	}

	public final void retakeClass() {
		System.out.println("Student is retaking a class");

	}
}
