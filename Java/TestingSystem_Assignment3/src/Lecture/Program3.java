package Lecture;

public class Program3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account[] account = new Account[5];

		for (int i = 0; i < account.length; i++) {
			account[i] = new Account("username" + i, i);
		}

		for (int i = 0; i < account.length; i++) {
			System.out.println("User name is :" + account[i].getName() + " ,and the age is " + account[i].getAge());
		}

	}

}
