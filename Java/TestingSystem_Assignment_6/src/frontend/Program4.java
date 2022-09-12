package frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program4 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			try {
				checkAge();
				// break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				sc.nextLine();

			}
			continue;

		}

	}

	private static int inputAge() throws Exception {

		try {
			System.out.println("------------------------------------------------------");
			System.out.print("Please input your age ");
			int age = sc.nextInt();

			return age;
		} catch (Exception e) {
			throw new InputMismatchException("Age must be integer, please try again");
		}
	}

	public static void checkAge() throws Exception {
		int b = inputAge();

		if (b < 0) {
			throw new ArithmeticException("Wrong input! Age must be greater than 0, please try again.");
		} else {
			System.out.println("Your age is " + b);
		}

	}

}
