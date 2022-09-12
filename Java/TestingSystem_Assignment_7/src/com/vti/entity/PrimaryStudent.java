package com.vti.entity;

public class PrimaryStudent extends Student {
	private static int PrimeCounter;

	public PrimaryStudent() throws Exception {
		super();
		PrimeCounter++;
	}

	public static int getPrimeCounter() {
		return PrimeCounter;
	}

	public final void attendConference() {
		System.out.println("Student is attending conference");

	}

}
