package frontend;

import java.util.ArrayList;
import java.util.List;

import entity.Department;

public class Program3 {

	static List<Department> departments = new ArrayList<>();

	public static void main(String[] args) {
		Department d1 = new Department(1, "Marketing", "Hanoi");
		Department d2 = new Department(2, "Sale", "Hanoi");
		Department d3 = new Department(3, "Security", "Hanoi");

		departments.add(d1);
		departments.add(d2);
		departments.add(d3);
		try {
			System.out.println(departments.get(3));

		} catch (Exception e) {
			System.out.println("Cannot find department");
		}

	}

}
