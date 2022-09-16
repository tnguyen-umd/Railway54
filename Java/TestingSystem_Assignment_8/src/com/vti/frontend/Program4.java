package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.backend.MyMath;
import com.vti.entity.Salary;
import com.vti.entity.Student;

public class Program4 {
	public static void main(String[] args) {
		Salary<Float> salary = new Salary<Float>(2.5f);

		// * Exercise 4 (Optional): Wildcard (Generic)
		// *
		// * Question 1: Tạo 1 class Salary để đại diện cho datatype là các số
		// *
		// * a) Hãy config class Salary như sau: Salary <N> với N phải được extends từ
		// * Number.class
		// *
		// * b) Tạo method để print ra salary hiện tại
		System.out.println(salary.toString());

		// * Question 3: T generic (method) Tạo method tính max của 2 số (số nhập vào có
		// * thể là float, double, int, long). Demo chương trình
		// this does not work with integer
		MyMath.getMax(2, 1.1);

//		 * Question 4: T generic (method & class) Tạo class MyMath<T> có thể làm việc
//		 * được với các số int, long, double và có chứa các method sau:
//		 * 
//		 * A) tính tổng của 2 số
//		 * 
//		 * B) tính tổng của 3 số
//		 * 
//		 * C) tính tổng của 4 số
//		 * 
//		 * D) tính hiệu của 2 số
//		 * 
//		 * E) hàm tính số mũ (a,b) Gợi ý: sử dụng optional parameter để làm câu a,b,c.
		MyMath.sum(1.1, 2);
		MyMath.sum(1.1, 2, 3);
		MyMath.sum(1.1, 2, 3, 4);
		MyMath.subtract(1.1, 2);
		MyMath.power(2, 2);
	}

}

/*
 * 
 * 
 * Question 5: Tạo 1 cursor như sau: ArrayList <Object> listWildcards. Hãy khởi
 * tạo đối tượng có chứa thông tin của khách hàng (mỗi thông tin là 1 element)
 * và thêm các giá trị vào trong ArrayList như:
 * 
 * a) Nguyễn Văn Nam
 * 
 * b) 30 tuổi
 * 
 * c) Hà đông, Hà nội
 */