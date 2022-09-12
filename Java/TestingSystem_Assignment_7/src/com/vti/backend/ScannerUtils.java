package com.vti.backend;

import java.util.Scanner;

public class ScannerUtils {
	static Scanner sc = new Scanner(System.in);
	static String errorMessage;

	public static int inputInt(String errorMessage) throws Exception {
		while (true) {
			try {
				// System.out.print("Please input an id: ");
				return Integer.parseInt(sc.nextLine());

			} catch (Exception e) {
				System.out.println(errorMessage);
			}

		}

	}

	public static String inputString() {
		String a = sc.nextLine();
		a = a.trim();
		System.out.println();
		return a;

	}

	public static long inputLong(String errorMessage) throws Exception {
		while (true) {
			try {
				// System.out.print("Please input an id: ");
				return Long.parseLong(sc.nextLine());

			} catch (Exception e) {
				System.out.println(errorMessage);
			}

		}

	}

	public static float inputFloat(String errorMessage) throws Exception {
		while (true) {
			try {
				// System.out.print("Please input an id: ");
				return Float.parseFloat(sc.nextLine());

			} catch (Exception e) {
				System.out.println(errorMessage);
			}

		}

	}

	public static double inputDouble(String errorMessage) throws Exception {
		while (true) {
			try {
				// System.out.print("Please input an id: ");
				return Double.parseDouble(sc.nextLine());

			} catch (Exception e) {
				System.out.println(errorMessage);
			}

		}

	}

}
