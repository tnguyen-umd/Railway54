package TestingSystem_Assignment_2;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*Exercise 4 (Optional): Random Number

*/

public class Exercise_4 {

	public static void main(String args[]) {
		Random rand = new Random(); // instance of random class
//		Question 1: In ngẫu nhiên ra 1 số nguyên + Question 2: In ngẫu nhiên ra 1 số thực 
		System.out.println("Question 1: random interger " + rand.nextInt());
		System.out.println("Question 2: random float: " + rand.nextFloat());

//		Question 3:Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
		String[] studentNameStrings = { "Mr. A", "Mr. B", "Mr. C", "Mr. D", "Mr. E" };
		int s1 = rand.nextInt(studentNameStrings.length);
		System.out.println("Question 3: random student name in class " + studentNameStrings[s1]);

//		Question 4:Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995
		long startDate = LocalDate.of(1995, 07, 24).toEpochDay(); // start date
		long endDate = LocalDate.of(1995, 12, 20).toEpochDay(); // end date

		long random = ThreadLocalRandom.current().nextLong(startDate, endDate);
		System.out.println(
				"Question 4: a random date between 24-07-1995 and 20-12-1995: " + LocalDate.ofEpochDay(random));

//		Question 5: 	Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
		long lastYearDate = LocalDate.now().minusDays(365).toEpochDay(); // today minus 365 days
		long currentDate = LocalDate.now().toEpochDay(); //

		long random1 = ThreadLocalRandom.current().nextLong(lastYearDate, currentDate);
		System.out.println("Question 5: a random date within last year: " + LocalDate.ofEpochDay(random1));

		// Question 6:Lấy ngẫu nhiên 1 ngày trong quá khứ
		long beginOfTime = LocalDate.of(0001, 01, 01).toEpochDay(); // day of beginning
		long curDate = LocalDate.now().toEpochDay(); //

		long random2 = ThreadLocalRandom.current().nextLong(beginOfTime, curDate);
		System.out.println("Question 6: a random date in the past: " + LocalDate.ofEpochDay(random2));

		// Question 7: Lấy ngẫu nhiên 1 số có 3 chữ số
		// generate a random integer from 0 to 899, then add 100
		int x = rand.nextInt(900) + 100;
		System.out.println("Question 7: a random number with 3 digits: " + x);

	}
}
