//
package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vti.entity.Employee;
import com.vti.utils.JDBCUtils;

/**
 * This class is .
 * 
 * @Description: .
 * @author: TNguyen
 * @create_date: Sep 19, 2022
 * @version: 1.0
 * @modifer: TNguyen
 * @modifer_date: Sep 19, 2022
 */
public class UserRepository implements IUserRepository {

	private Scanner scanner = new Scanner(System.in);
	private List<Employee> employees;

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#getListUsers()
	 */
	public List<Employee> getListUsers() throws ClassNotFoundException, SQLException {
		employees = new ArrayList<Employee>();

		// get database connection
		Connection connection = JDBCUtils.connectDatabase();

		// Create a statement object
		String sql = "SELECT * FROM `user`";
		Statement statement = connection.createStatement();

		// execute query
		ResultSet resultSet = statement.executeQuery(sql);

		// handling result set
		while (resultSet.next()) {
			Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
					resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("ProSkill"));

			employees.add(employee);

		}

		for (Employee employee : employees) {
			System.out.println(employee);
		}
		// disconnect database
		JDBCUtils.disconnectDatabase();

		return employees;
	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#createUser()
	 */
	public void createUser(String name) throws Exception {
		// call depNameExist method to insert a department name and then return
		// true=exists, false=not exist

		System.out.print("Please input new user's email address: ");
		String email = scanner.next();

		// validate email format
		if (!isValidEmailAddress(email)) {
			throw new Exception("Invalid email format");
		}

		String sql = "INSERT INTO `javaexam`.`user` (`name`, `email`) VALUES ('" + name + "', '" + email + "');";

		Statement statement;
		try {
			Connection connection = JDBCUtils.connectDatabase();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			int affectedRecordAmount1 = preparedStatement.executeUpdate();

			System.out.println("Number of new user added: " + affectedRecordAmount1);

			connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#userExists(java.lang.String)
	 */
	public boolean userExists(String name) {

		try {

			String sql = "SELECT * FROM javaexam.user where name='" + name + "';";
			Connection connection = JDBCUtils.connectDatabase();
			Statement statement = connection.createStatement();

			// Step 4: execute query

			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: add info from database to arraylist

			if (!resultSet.next()) {
				System.out.println("This name does not exist " + name);
				return false;
			} else {

				System.out.println("Existing user ID: " + resultSet.getInt("id"));
				System.out.println("Existing name: " + resultSet.getString("name"));
				System.out.println("Existing name: " + resultSet.getString("email"));

			}
			connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return true;

	}

	public boolean userIDExists(int id) {
		try {

			String sql = "SELECT * FROM javaexam.user where id=" + id + ";";

			Connection connection = JDBCUtils.connectDatabase();
			Statement statement = connection.createStatement();

			// Step 4: execute query

			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: add info from database to arraylist

			if (!resultSet.next()) {
				System.out.println("Cannot find this user by ID:  " + id);
				return false;
			} else {

				System.out.println("User ID: " + resultSet.getInt("id"));
				System.out.println("name: " + resultSet.getString("name"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return true;

	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#getUserByID()
	 */
	public Employee getUserByID(int id) {
		Employee employee = null;
		try {

			String sql = "SELECT * FROM javaexam.user where id=" + id + ";";

			Connection connection = JDBCUtils.connectDatabase();
			Statement statement = connection.createStatement();

			// Step 4: execute query

			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: add info from database to arraylist

			if (!resultSet.next()) {
				System.out.println("Cannot find this user by ID:  " + id);
			} else {
				employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("ProSkill"));
				System.out.println(employee);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return employee;

	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#updateUserByID()
	 */
	public void updateUserByID(int id) {
		Employee employee = getUserByID(id);
		if (employee == null) {
			System.out.println("Cannot find this user id");
		} else {
			String name = scanner.next();
			if (userExists(name)) {
				System.out.println("name already exists!");
			} else {

				String sql = "UPDATE `javaexam`.`user` SET `name` = '" + name + "' WHERE (`id` = '" + employee.getId()
						+ "');";

				Statement statement;
				try {
					Connection connection = JDBCUtils.connectDatabase();
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					int affectedRecordAmount1 = preparedStatement.executeUpdate();

					System.out.println("name is updated! " + affectedRecordAmount1);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

			}
		}
	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#deleteUser()
	 */
	public void deleteUser(String name) {
		if (userExists(name)) {
			String sql = "DELETE FROM `javaexam`.`user` WHERE (`name` ='" + name + "');";

			PreparedStatement prepStatement;
			try {
				Connection connection = JDBCUtils.connectDatabase();
				prepStatement = connection.prepareStatement(sql);
				int affectedRecordAmount1 = prepStatement.executeUpdate();

				System.out.println("Number of user deleted: " + affectedRecordAmount1);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("name not found");
		}
	}

	public void deleteUser(int id) {
		if (userIDExists(id)) {
			String sql = "DELETE FROM `javaexam`.`user` WHERE (`id` ='" + id + "');";

			PreparedStatement prepStatement;
			try {
				Connection connection = JDBCUtils.connectDatabase();
				prepStatement = connection.prepareStatement(sql);
				int affectedRecordAmount1 = prepStatement.executeUpdate();

				System.out.println("Number of user deleted: " + affectedRecordAmount1);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("name not found");
		}
	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#login(java.lang.String,
	 * java.lang.String)
	 */
	public boolean login(String email, String password) {
		try {

			String sql = "SELECT * FROM javaexam.user where email='" + email + "';";
			Connection connection = JDBCUtils.connectDatabase();
			Statement statement = connection.createStatement();

			// Step 4: execute query

			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: add info from database to arraylist

			if (!resultSet.next()) {
				System.out.println("This email does not exist " + email);
				return false;
			} else if (password.equals(resultSet.getString("password"))) {
				System.out.println("Login success!");

			} else {
				System.out.println("Email and password did not match!");
				return false;
			}
			connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return true;

	}

	public boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		Pattern p = Pattern.compile(ePattern);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#isValidName(java.lang.String)
	 */
	public boolean isNameValid(String name) {
		String regex = "^[a-zA-Z]\\w{5,50}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		return m.matches();

	}

}
