package SortAccounts;

public class AccountSorting {

	//arranging array by account's age
	public void orderByAge(Account[] a) {

		System.out.println("trc khi sap xep");

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");

		}
		System.out.println();

		// System.out.println("sau khi doi cho " + a[0] + " " + a[1]);
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i].getAge() > a[j].getAge()) {
					Account tg = new Account("test",0);
					tg = a[i];// 1
					a[i] = a[j];// a0= 4
					a[j] = tg;

				}
			}
		}

		System.out.println("sau khi sap xep");

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");

		}
	}
	
}
