package TestingSystem_Assignment_2;

public class Test {

	public static void main(String[] args) {

		for (int i = 0; i <= 10; i++) {
			if (i == 5) {
				return;
			}
			System.out.print(i + "   ");
		}
		System.out.println();
		System.out.println("Test chuong trinh");

	}

}
// return: terminate from this line
//break: terminate loop from this line and jump to the next command
//continue: skip this value