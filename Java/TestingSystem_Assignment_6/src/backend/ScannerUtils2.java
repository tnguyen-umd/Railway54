package backend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils2 {
	static Scanner sc = new Scanner(System.in);
	static String errorMessage;

	public static int inputInt(String errorMessage) throws Exception {
		while (true) {
			try {
				System.out.print("Please input an integer: ");
				int a = sc.nextInt();
				System.out.print("You entered:  " + a);
				System.out.println();

				return a;

			} catch (Exception e) {
				throw new InputMismatchException(errorMessage);
			}

		}

	}

	public static float inputFloat() throws Exception {

		try {
			System.out.println("------------------------------------------------------");
			System.out.print("Please input a float number: ");
			float a = sc.nextFloat();
			System.out.print("You entered:  " + a);

			return a;

		} catch (Exception e) {
			throw new InputMismatchException("Error, input must be a real number");
		}
	}

	public static double inputDouble() throws Exception {

		try {
			System.out.println("------------------------------------------------------");
			System.out.print("Please input a real number: ");
			double a = sc.nextDouble();
			System.out.print("You entered:  " + a);

			return a;

		} catch (Exception e) {
			throw new InputMismatchException("Error, input must be a real number");
		}
	}

	public static String inputString() {
		System.out.print("Please input a string: ");
		String a = sc.nextLine();
		System.out.print("You entered:  " + a);
		System.out.println();

		return a;
	}

	public static void main(String[] args) {
		try {
			inputInt("Incorrect input, please use a real number");

			// inputString();
			// inputFloat();
			// inputDouble();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
