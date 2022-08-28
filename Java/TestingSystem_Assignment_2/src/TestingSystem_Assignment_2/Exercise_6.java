package TestingSystem_Assignment_2;

//Exercise 6 (Optional): Method

//Question 1:
//Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10

//PRINT INTERGER SMALLER THAN 10
public class Exercise_6 {

	public static void question1() {
		for (int i = 0; i <= 10; i += 2) {
			System.out.println(i);
		}

	}

	// Question 2:
	// Tạo method để in thông tin các account
	public static void question2(Account a) {
		System.out.println(a.toString());
	}

	// Question 3:
	// Tạo method để in ra các số nguyên dương nhỏ hơn 10
	public static void question3() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}

	}

	// nhap vao so phan tu cua mang(neu la 5 thi array se co 5 phan tu 0-4), sau do
	// nhap lan luot cac ptu vao(ko theo thứ tu) a[0-4]
	// a, tìm gtri lon nhat a[0-4]
	// a1, doi cho a[0] voi a[1];
	// b, sap xep array tho thu giam dan trong a[0-4]

	public int giaiThua(int x) {
		// Giai thua

		int n = 1;
		for (int i = 1; i <= x; i++) {
			n = n * i;
		}
		// System.out.println("Giai thua = " + n);

		// sau khi chay thi method nay se tra ve gia tri n
		return n;

	}

	public static void main(String[] args) {
		Exercise_6 exercise_6 = new Exercise_6();

		System.out.println(exercise_6.tinhEx(2, 3));
	}

	public float tinhEx(int n, int x) {
		// Giai thua n
		//

		float a = 0;
		for (int i = 1; i <= n; i++) {
			a = (float) (a + Math.pow(i, x) / giaiThua(i));
		}
		// System.out.println("Giai thua = " + n);

		// sau khi chay thi method nay se tra ve gia tri n
		return a;

	}

	// get maximum number
//	public static int getMax(int x) {
//
//		// get max number in an array
//		int maxx = x;
//		for (int i = 0; i < a.length; i++) {
//			if (maxx < a[i]) {
//				maxx = a[i];
//			}
//		}
//
//		// sau khi chay thi method nay se tra ve gia tri n
//		return maxx;
//
//	}

	public static void nextQuestion() {
		// Scanner scanner = new Scanner(System.in);

		// int a = giaiThua(4);

//		System.out.println("Nhap vao so phan tu cua mang ");
//		int n = scanner.nextInt();
//		// int b = scanner.nextInt();
//
//		int a[] = new int[n];
//// nhap vao
//		for (int i = 0; i < a.length; i++) {
//			System.out.print("Nhập vao a[" + i + "] = ");
//			a[i] = scanner.nextInt();
//		}
//

//
////		System.out.println("Gias tri lon naht la: " + maxx);
////		System.out.println("trc khi doi cho " + a[0] + "    " + a[1]);
//		// a[0]=1 a[1]=4
////		int tg = 0;
////		tg = a[0];// 1
////		a[0] = a[1];// a0= 4
////		a[1] = tg; // a1 =1
//
//		System.out.println("trc khi sap xep");
//
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + "  ");
//
//		}
//
//		// System.out.println("sau khi doi cho " + a[0] + " " + a[1]);
//		for (int i = 0; i < a.length - 1; i++) {
//			for (int j = i + 1; j < a.length; j++) {
//				if (a[i] > a[j]) {
//					int tg = 0;
//					tg = a[i];// 1
//					a[i] = a[j];// a0= 4
//					a[j] = tg; // a1 =1
//				}
//			}
//		}
//
//		System.out.println("trc khi sap xep");
//
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + "  ");
//
//		}

	}

}
