package backend;

public class Exercise1 {

	public static void question1() {
		try {
			float result = divide(7, 2);
			System.out.println("Ket qua la " + result);
		} catch (Exception e) {
			System.out.println("Cannot divide by zero");
		} finally {
			System.out.println("Divide completed!");
		}
	}

	public static float divide(int a, int b) {

		return a / b;

	}

}
