package com.vti.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Department;

public class DepartmentDao {

	static List<Department> departments = new ArrayList<Department>();
	static Scanner scanner = new Scanner(System.in);
	static String depName;
	static int depID;

	public static List<Department> getDepartments() throws SQLException {

		/**
		 * Question 1: read data – get list departments Tạo method để lấy ra danh sách
		 * tất cả các Department
		 * 
		 * Gợi ý: Viết method getDepartments() và return ra List<Department>, Nếu có lỗi
		 * sẽ throw Exception lên frontend để in ra Trên front-end sẽ gọi class
		 * DepartmentDao và demo method này
		 */

		// Step 3: create a statement object
		String sql = "SELECT * FROM testingsystem.departments;";
		Statement statement = JdbcUtils.connection.createStatement();

		// Step 4: execute query
		ResultSet resultSet = statement.executeQuery(sql);

		// Step 5: add info from database to arraylist
		while (resultSet.next()) {
			Department department = new Department(resultSet.getInt("department_id"),
					resultSet.getString("department_name"));
			departments.add(department);
		}

		// print department info
		for (Department department : departments) {
			System.out.println(department);
		}

		return departments;

	}

	public static void getDepartmentByID() {

//		Question 2: read data – get department by id
//		Tạo method để lấy ra Department có id = 5
//		Gợi ý: Làm tương tự câu trên
//			Nếu không có department nào có id = 5 thì sẽ in ra là "Cannot find department which has id = 5"
//			
//			Nếu có lỗi sẽ throw Exception lên front-end để in ra Trên front-end sẽ gọi class DepartmentDao và demo method 
//			này

//		Question 3: Tiếp tục Question 2 (read data – get department by id)
//		Không fix cứng id nữa mà sẽ dùng scanner để yêu cầu người dùng 
//		nhập vào id, sau đó trả về thông tin department có id như người dùng 
//		nhập vào
//		
//		Gợi ý: 
//			Trên backend sẽ viết method getDepartmentById(int id) và return ra Department
//			Nếu tìm thấy department có id = parameter thì sẽ return về department đó
//			Nếu không tìm thấy thì sẽ throw ra với message "Cannot find department which has id = " + id
//			Nếu có lỗi sẽ throw Exception lên front-end để in ra
//			Trên front-end sẽ gọi class DepartmentDao và demo method này

		int depID = 0;
		try {
			System.out.print("Input department ID: ");
			depID = scanner.nextInt();
			String sql = "SELECT * FROM testingsystem.departments where department_id=" + depID + ";";
			Statement statement = JdbcUtils.connection.createStatement();

			// Step 4: execute query

			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: add info from database to arraylist

			if (!resultSet.next()) {
				System.out.println("This department id does not exist " + depID);
			} else {

				System.out.println("Department ID: " + resultSet.getInt("department_id"));
				System.out.println("Department name: " + resultSet.getString("department_name"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static boolean depNameExists() {
//		Question 4: check data exists – check department name exists
//		Tạo method để check department name có tồn tại hay không?
//		Gợi ý: 
		//
//		Trên backend sẽ viết method isDepartmentNameExists(String name) và return ra boolean
//			Nếu tìm thấy department đã có name = name parameter thì sẽ return true
//			Nếu không tìm thấy thì sẽ return ra false
//			Nếu có lỗi sẽ throw Exception lên front-end để in ra Trên front-end sẽ gọi class DepartmentDao và demo method 
//			này
		depName = null;
		try {
			System.out.print("Input department name: ");
			depName = scanner.next();
			String sql = "SELECT * FROM testingsystem.departments where department_name='" + depName + "';";
			Statement statement = JdbcUtils.connection.createStatement();

			// Step 4: execute query

			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: add info from database to arraylist

			if (!resultSet.next()) {
				System.out.println("This department name does not exist " + depName);
				return false;
			} else {

				System.out.println("Department ID: " + resultSet.getInt("department_id"));
				System.out.println("Department name: " + resultSet.getString("department_name"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return true;

	}

	public static void createDepartment() {
//call depNameExist method to insert a department name and then return true=exists, false=not exist
		if (depNameExists()) {
			System.out.println("Department name already exists!");
		} else {
			String sql = "INSERT INTO `testingsystem`.`departments` (`department_name`) VALUES ('" + depName + "');";
			Statement statement;
			try {
				PreparedStatement preparedStatement = JdbcUtils.connection.prepareStatement(sql);
				int affectedRecordAmount1 = preparedStatement.executeUpdate();

				System.out.println("Department table is updated! " + affectedRecordAmount1);

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}

//		Question 5: create data – create department
//		Tạo method để người dùng có thể tạo được department 
//		Gợi ý: 
//			Trên backend sẽ viết method void createDepartment (String name)
//			Check xem đã có department nào có tên như parameter chưa (sử dụng method ở Question 6 để check)
//			
//			Nếu tìm đã có department có tên như parameter thì throw ra Exception "Department Name is Exists!"
//			Nếu không tìm thấy thì sẽ create department
//			Nếu có lỗi sẽ throw Exception lên front-end để in ra
//			Trên front-end sẽ gọi class DepartmentDao và demo method 
//			này (dùng scanner để nhập thông tin của department muốn 
//			create)

	}

	public static boolean depIDExists() {
		try {
			System.out.print("Input department ID: ");
			depID = scanner.nextInt();
			String sql = "SELECT * FROM testingsystem.departments where department_id=" + depID + ";";
			Statement statement = JdbcUtils.connection.createStatement();

			// Step 4: execute query

			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: add info from database to arraylist

			if (!resultSet.next()) {
				System.out.println("Cannot find this department by ID:  " + depID);
				return false;
			} else {

				System.out.println("Department ID: " + resultSet.getInt("department_id"));
				System.out.println("Department name: " + resultSet.getString("department_name"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return true;

	}

	public static void deleteDepartment() {
//		Question 7: 
//		Tạo method để người dùng có thể xóa được department theo id mà user nhập vào
//		Gợi ý: 
//			Trên backend sẽ viết method void deleteDepartment (int id)
//			Check xem đã có department nào có id như id parameter chưa (sử dụng method ở Question 6 để check)
//			Nếu không tìm thấy department có id = id parameter thì sẽ throw ra Exception có message "Cannot find department which has id = " + id
//			Nếu tìm thấy thì sẽ delete department đó
//			Nếu có lỗi sẽ throw Exception lên front-end để in ra
//			Trên front-end sẽ gọi class DepartmentDao và demo method này (dùng scanner để nhập vào id của department muốn delete)
		if (depIDExists()) {
			String sql = "DELETE FROM `testingsystem`.`departments` WHERE (`department_id` =" + depID + ");";

			PreparedStatement prepStatement;
			try {
				prepStatement = JdbcUtils.connection.prepareStatement(sql);
				int affectedRecordAmount1 = prepStatement.executeUpdate();

				System.out.println("Department table is updated! " + affectedRecordAmount1);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("Department not found");
		}

	}

	public static void updateDepartmentName() {
		/**
		 * Question 6: update data – update department Tạo method để người dùng có thể
		 * update được department name Gợi ý: Trên backend sẽ viết method void
		 * updateDepartmentName (int id, String newName) Check xem đã có department nào
		 * có id như id parameter chưa (Viết thêm method như Question 6 để check, tên
		 * method là isDepartmentIdExists(int id)) Nếu không tìm thấy department có id =
		 * id parameter thì sẽ throw ra Exception message "Cannot find department which
		 * has id = " + id
		 * 
		 * Nếu tìm thấy department có id = id parameter thì sẽ check xem tên mới của
		 * department có bị trùng không (sử dụng method ở Question 6 để check)
		 * 
		 * Nếu tìm đã có department có tên như parameter thì throw ra Exception
		 * "Department Name is Exists!" Nếu không tìm thấy thì sẽ update department Nếu
		 * có lỗi sẽ throw Exception lên front-end để in ra Trên front-end sẽ gọi class
		 * DepartmentDao và demo method này(dùng scanner để nhập thông tin của
		 * department muốn update)
		 */
		/**
		 * 1) first check by depID if depID exist-->check depName
		 * 
		 * A) if name exist--> * print "Department Name is Exists!"
		 * 
		 * B) else update dep name
		 * 
		 */

		if (!depIDExists()) {
			System.out.println("Cannot find department which has id = " + depID);

		} else {
			if (depNameExists()) {
				System.out.println("Department name already exists!");
			} else {
				String sql = "UPDATE `testingsystem`.`departments` SET `department_name` = '" + depName
						+ "' WHERE (`department_id` = '" + depID + "');";

				Statement statement;
				try {
					PreparedStatement preparedStatement = JdbcUtils.connection.prepareStatement(sql);
					int affectedRecordAmount1 = preparedStatement.executeUpdate();

					System.out.println("Department table is updated! " + affectedRecordAmount1);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

			}
		}

	}

	// delete using stored procedure SQL
	public static void deleteDepartmentUsingProcedure() {
		/**
		 * Exercise 3 (Optional): Call Procedure
		 * 
		 * Question 1: Tạo method để yêu cầu người dùng nhập vào id của department, sau
		 * đó sẽ xóa department đó. (sử dụng store procedure ở trong MySQL) Gợi ý: B1:
		 * Tạo 1 store procedure trong MySQL tên là sp_delete_department() có in
		 * parameter là id B2: Trên backend sẽ viết method void
		 * deleteDepartmentUsingProcedure(int id) Check xem đã có department nào có id
		 * như id parameter chưa (sử dụng method ở Question 6 để check) Nếu không tìm
		 * thấy department có id = id parameter thì sẽ throw ra Exception có message
		 * "Cannot find department which has id = " + id Nếu tìm thấy thì sẽ delete
		 * department đó Nếu có lỗi sẽ throw Exception lên front-end để in ra Trên
		 * front-end sẽ gọi class DepartmentDao và demo method này (dùng scanner để nhập
		 * vào id của department muốn delete)
		 */

		if (!depIDExists()) {
			System.out.println("Dept does not exist!, deletion failed");
		} else {
			String sql = "CALL testingsystem.sp_delete_department(" + depID + ");";

			PreparedStatement prepStatement;
			try {
				prepStatement = JdbcUtils.connection.prepareStatement(sql);
				int affectedRecordAmount1 = prepStatement.executeUpdate();

				System.out.println("Department table is updated! " + affectedRecordAmount1);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

	}

}
