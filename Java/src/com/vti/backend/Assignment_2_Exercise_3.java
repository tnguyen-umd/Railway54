package com.vti.backend;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.vti.entity.Exam;

/*Exercise 3 (Optional): Date Format

*/

//Question 1: 
//	In ra thông tin Exam thứ 1 và createDate sẽ được format theo định 
//	dạng vietnamese
public class Assignment_2_Exercise_3 {

	public void question1(Exam a) {

		// System.out.println(a.getCreateDate());

//		String patternString = "MM/dd/yyyy";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternString);
//		String date = a.getCreateDate().format(new Date());
//		System.out.println(date);

		// ASK WHY LOCALDATE CANNOT BE FORMATED TO VN DATE
		Locale locale = new Locale("vi", "VN");
		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		String date = dateformat.format(a.getCreateDate());
		System.out.println("Account " + a.getCode() + " was created on " + date);

		// LocalDate currentDate = LocalDate.now();
//		DateTimeFormatter usDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.).withLocale(Locale.US); // 2
//		String usFormattedDate = a.getCreateDate().format(usDateFormatter); // 3
//		System.out.println("Current date in en-US date format: " + usFormattedDate);
//
//		DateTimeFormatter frDateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
//				.withLocale(Locale.FRANCE); // 4
//		String frFormattedDate = a.getCreateDate().format(frDateFormatter); // 5
//		System.out.println("Current date in fr-FR date format: " + frFormattedDate);

	}

//	Question 2: 
//		In ra thông tin: Exam đã tạo ngày nào theo định dạng 
//		Năm – tháng – ngày – giờ – phút – giây
	public void question2(Exam a) {

		// LocalDate localDate = LocalDate.of(1990, Month.JULY, 20);
		String s = a.getCreateDate().format(DateTimeFormatter.ofPattern("YYYY/MM/d HH:mm:ss"));

		System.out.println(s);
	}

//	Question 3: Chỉ in ra năm của create date property trong Question 2

	public void question3(Exam a) {

		// LocalDate localDate = LocalDate.of(1990, Month.JULY, 20);
		String s = a.getCreateDate().format(DateTimeFormatter.ofPattern("YYYY"));

		System.out.println(s);
	}

//	Question 4: 
//	Chỉ in ra tháng và năm của create date property trong Question 2
	public void question4(Exam a) {

		// LocalDate localDate = LocalDate.of(1990, Month.JULY, 20);
		String s = a.getCreateDate().format(DateTimeFormatter.ofPattern("YYYY/MM"));

		System.out.println(s);
	}

	// Question 5:
	// Chỉ in ra "MM-DD" của create date trong Question 2

	public void question5(Exam a) {

		// LocalDate localDate = LocalDate.of(1990, Month.JULY, 20);
		String s = a.getCreateDate().format(DateTimeFormatter.ofPattern("MM/dd"));

		System.out.println(s);
	}

}
