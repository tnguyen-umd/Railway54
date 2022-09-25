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

import com.vti.entity.User;
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

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#getListUsers()
	 */
	public List<User> getListUsers() throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<User>();

		// get database connection
		Connection connection = JDBCUtils.connectDatabase();

		// Create a statement object
		String sql = "SELECT id, username, email FROM `user`";
		Statement statement = connection.createStatement();

		// execute query
		ResultSet resultSet = statement.executeQuery(sql);

		// handling result set
		while (resultSet.next()) {
			User user = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"));

			users.add(user);

		}

		// disconnect database
		JDBCUtils.disconnectDatabase();

		return users;
	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#createUser()
	 */
	public void createUser(String username) throws Exception {
		// call depNameExist method to insert a department name and then return
		// true=exists, false=not exist

		System.out.print("Please input new user's email address: ");
		String email = scanner.next();
		String sql = "INSERT INTO `testingsystem`.`user` (`username`, `email`) VALUES ('" + username + "', '" + email
				+ "');";

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
	public boolean userExists(String username) {

		try {

			String sql = "SELECT * FROM testingsystem.user where username='" + username + "';";
			Connection connection = JDBCUtils.connectDatabase();
			Statement statement = connection.createStatement();

			// Step 4: execute query

			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: add info from database to arraylist

			if (!resultSet.next()) {
				System.out.println("This username does not exist " + username);
				return false;
			} else {

				System.out.println("Existing user ID: " + resultSet.getInt("id"));
				System.out.println("Existing username: " + resultSet.getString("username"));

			}
			connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return true;

	}

	public boolean userIDExists() {
		try {
			System.out.print("Input user ID: ");
			int userID = scanner.nextInt();
			String sql = "SELECT * FROM testingsystem.user where id=" + userID + ";";

			Connection connection = JDBCUtils.connectDatabase();
			Statement statement = connection.createStatement();

			// Step 4: execute query

			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: add info from database to arraylist

			if (!resultSet.next()) {
				System.out.println("Cannot find this user by ID:  " + userID);
				return false;
			} else {

				System.out.println("User ID: " + resultSet.getInt("id"));
				System.out.println("Username: " + resultSet.getString("username"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return true;

	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#getUserByID()
	 */
	public User getUserByID() {
		User user = null;
		try {

			System.out.print("Input user ID: ");
			int userID = scanner.nextInt();
			String sql = "SELECT * FROM testingsystem.user where id=" + userID + ";";

			Connection connection = JDBCUtils.connectDatabase();
			Statement statement = connection.createStatement();

			// Step 4: execute query

			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: add info from database to arraylist

			if (!resultSet.next()) {
				System.out.println("Cannot find this user by ID:  " + userID);
			} else {
				user = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"));
				System.out.println(user);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;

	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#updateUserByID()
	 */
	public void updateUserByID() {
		User user = getUserByID();
		if (user == null) {
			System.out.println("Cannot find this user id");
		} else {
			String username = scanner.next();
			if (userExists(username)) {
				System.out.println("Username already exists!");
			} else {

				String sql = "UPDATE `testingsystem`.`user` SET `username` = '" + username + "' WHERE (`id` = '"
						+ user.getId() + "');";

				Statement statement;
				try {
					Connection connection = JDBCUtils.connectDatabase();
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					int affectedRecordAmount1 = preparedStatement.executeUpdate();

					System.out.println("Username is updated! " + affectedRecordAmount1);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

			}
		}
	}

	/*
	 * @see com.vti.backend.datalayer.IUserRepository#deleteUser()
	 */
	public void deleteUser(String username) {
		if (userExists(username)) {
			String sql = "DELETE FROM `testingsystem`.`user` WHERE (`username` ='" + username + "');";

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
			System.out.println("Username not found");
		}
	}

}
