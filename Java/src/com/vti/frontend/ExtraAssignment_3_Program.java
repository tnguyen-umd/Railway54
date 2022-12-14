package com.vti.frontend;

import java.util.Random;
import java.util.Scanner;

//program danh lo de
public class ExtraAssignment_3_Program {

	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
	static float taiKhoan = 1000;
	static int[] Giai7 = new int[4];
	static int[] Giai6 = new int[3];
	static int[] Giai5 = new int[6];
	static int[] Giai4 = new int[4];
	static int[] Giai3 = new int[6];
	static int[] Giai2 = new int[2];
	static int Giai1;
	static int GiaiDB;
	static int soDanhDe;
	static int soDanhLo;
	static boolean result;
	static float tiGiaDiemLo = 24.5f;
	static int tiGiaLo = 80;
	static int tiGiaDe = 70;
	static int soNhay;
	static int diemChoiLo;

	public static void main(String[] args) {
		System.out.println("Hello, please choose your game options");
		System.out.println("Your account has " + taiKhoan + " kVND");

		while (true) {
			System.out.println("------------------------------------------------------------------------");
			System.out.println("Please choose your options: ");
			System.out.println("1-Danh de");
			System.out.println("2-Danh lo");
			System.out.println("3-Quit program");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				danhDe();
				break;
			}
			case 2: {
				danhLo();
				break;
			}
			case 3: {
				return;
			}
			default:
				System.out.println("You chose the incorrect option, please try again");
				break;
			}
		}

	}

	public static void quaySoXo() {

//------------quay so xo giai 7--------------------------------------------------------------------------

		for (int i = 0; i < Giai7.length; i++) {
			Giai7[i] = rand.nextInt(100);
		}

		System.out.println("Giai 7 result: ");
		for (int i = 0; i < Giai7.length; i++) {
			System.out.printf("%02d \n", Giai7[i]);
		}
//------------quay so xo giai 6--------------------------------------------------------------------------
		for (int i = 0; i < Giai6.length; i++) {
			Giai6[i] = rand.nextInt(1000);
		}

		System.out.println("Giai 6 result: ");
		for (int i = 0; i < Giai6.length; i++) {
			System.out.printf("%03d \n", Giai6[i]);
		}
//------------quay so xo giai 5--------------------------------------------------------------------------

		for (int i = 0; i < Giai5.length; i++) {
			Giai5[i] = rand.nextInt(10000);
		}

		System.out.println("Giai 5 result: ");
		for (int i = 0; i < Giai5.length; i++) {
			System.out.printf("%04d \n", Giai5[i]);
		}
// ------------quay so xo giai4--------------------------------------------------------------------------

		for (int i = 0; i < Giai4.length; i++) {
			Giai4[i] = rand.nextInt(10000);
		}

		System.out.println("Giai 4 result: ");
		for (int i = 0; i < Giai4.length; i++) {
			System.out.printf("%04d \n", Giai4[i]);
		}
// ------------quay so xo giai3--------------------------------------------------------------------------

		for (int i = 0; i < Giai3.length; i++) {
			Giai3[i] = rand.nextInt(100000);
		}

		System.out.println("Giai 3 result: ");
		for (int i = 0; i < Giai3.length; i++) {
			System.out.printf("%05d \n", Giai3[i]);
		}
// ------------quay so xo giai2--------------------------------------------------------------------------

		for (int i = 0; i < Giai2.length; i++) {
			Giai2[i] = rand.nextInt(100000);
		}

		System.out.println("Giai 2 result: ");
		for (int i = 0; i < Giai2.length; i++) {
			System.out.printf("%05d \n", Giai2[i]);
		}
// ------------quay so xo giai1--------------------------------------------------------------------------
		Giai1 = rand.nextInt(100000);

		System.out.println("Giai nhat result: ");

		System.out.printf("%05d \n", Giai1);
// ------------quay so xo giai dac biet--------------------------------------------------------------------------
		GiaiDB = rand.nextInt(100000);

		System.out.println("Giai dac biet result: ");

		System.out.printf("%05d \n", GiaiDB);
	}

	public static void GiaiDB() {
		// ------------quay so xo giai dac
		// biet--------------------------------------------------------------------------
		GiaiDB = rand.nextInt(100000);

		System.out.println("Giai dac biet: ");

		System.out.printf("%05d \n", GiaiDB);

	}

	public static void danhDe() {
		System.out.println("Nhap vao so muon danh co 2 chu so: ");
		soDanhDe = sc.nextInt();
		System.out.println("Nhap vao so tien cuoc: ");
		int tienCuoc = sc.nextInt();

		// chay so so va lay ra giai dac biet
		GiaiDB();

		// lay ra 2 so cuoi cua giai dac biet
		int soTrungDe = GiaiDB % 100;

		if (soDanhDe == soTrungDe) {
			result = true;
		} else {
			result = false;
		}

		System.out.println("Ket qua de hom nay la: " + soTrungDe);

		// check xem ban trung hay truot de
		if (result) {
			System.out.println("Ban da trung");
			taiKhoan += tienCuoc * tiGiaDe;
			System.out.println("So tien thang la: " + tienCuoc * tiGiaDe);
			System.out.println("So tien trong tai khoan cua ban = " + taiKhoan);
		} else {
			System.out.println("Ban khong trung de");
			taiKhoan -= tienCuoc;
			System.out.println("So tien trong tai khoan cua ban = " + taiKhoan);
		}
	}

	public static void danhLo() {
		System.out.println("Nhap vao so lo muon danh: ");
		soDanhLo = sc.nextInt();
		System.out.println("Nhap vao so diem muon danh: ");
		diemChoiLo = sc.nextInt();

		// chay so so va lay ra giai dac biet
		quaySoXo();
		checkLo();
		System.out.println("Ban duoc " + soNhay + " nhay");
		float tienChoiLo = diemChoiLo * tiGiaDiemLo;
		System.out.println("Tien choi lo = " + tienChoiLo);
		int tienThangLo = soNhay * tiGiaLo;
		System.out.println("Tien thang lo = " + tienThangLo);
		taiKhoan += tienThangLo - tienChoiLo;
		System.out.println("Tien trong tai khoan = " + taiKhoan);
	}

	public static void checkLo() {
		soNhay = 0;
		// check giai7
		for (int i = 0; i < Giai7.length; i++) {
			if (soDanhLo == (Giai7[i] % 100)) {
				soNhay++;
			}
		}
		// check giai6
		for (int i = 0; i < Giai6.length; i++) {
			if (soDanhLo == (Giai6[i] % 100)) {
				soNhay++;
			}
		}
		// check giai5
		for (int i = 0; i < Giai5.length; i++) {
			if (soDanhLo == (Giai5[i] % 100)) {
				soNhay++;
			}
		}
		// check giai4
		for (int i = 0; i < Giai4.length; i++) {
			if (soDanhLo == (Giai4[i] % 100)) {
				soNhay++;
			}
		}
		// check giai3
		for (int i = 0; i < Giai3.length; i++) {
			if (soDanhLo == (Giai3[i] % 100)) {
				soNhay++;
			}
		}
		// check giai2
		for (int i = 0; i < Giai2.length; i++) {
			if (soDanhLo == (Giai2[i] % 100)) {
				soNhay++;
			}
		}
		// check giai1
		if (soDanhLo == (Giai1 % 100)) {
			soNhay++;
		}

		// check giai dac biet
		if (soDanhLo == (GiaiDB % 100)) {
			soNhay++;
		}
	}

}
