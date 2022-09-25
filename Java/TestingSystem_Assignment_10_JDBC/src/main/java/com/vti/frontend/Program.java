package com.vti.frontend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Program {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		// =======================ESTABLISH DATABASE CONNECTION=========================
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/main/resources/database.properties"));
		properties.load(new FileInputStream("src/main/resources/message.properties"));

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		// register the driver class with DriverManager
		Class.forName(properties.getProperty("driver"));

		// Step 2: get a Database Connection
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println(properties.getProperty("connection.success"));
		// =============================================================================

		// Step 3: create a statement object
		String sql = "select id, username, email from `user`";
		Statement statement = connection.createStatement();

		// Step 4: execute query
		ResultSet resultSet = statement.executeQuery(sql);

		// Step 5: handling results
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString("username"));
			System.out.println(resultSet.getString("email"));

		}

		// How to insert statement, make sure to use executeUpdate instead of
		// excuteQuery
//		String sql1 = "INSERT INTO `group` (`name`, `author_ID`) VALUES ('Java Senior5', '4');";
//		// Step 4: execute query
//		int affectedRecordAmount = statement.executeUpdate(sql1);
//		// handling results
//		System.out.println("Affected record amount = " + affectedRecordAmount);

		// How to insert statement using scanner by user, make sure to use executeUpdate
		// instead of
		// excuteQuery
		String sql2 = "INSERT INTO `group` (`name`, `author_ID`) VALUES (?, ?);";
		PreparedStatement preparedStatement = connection.prepareStatement(sql2);

		// put scanner here
		// remember that in JDBC index start from 1 instead of zero
		System.out.print("Insert author name into database: ");
		String authorName = scanner.nextLine();// this is index 1 of sql2
		int authorID = 1;// this is index 2 of sql2
		preparedStatement.setString(1, authorName);
		preparedStatement.setInt(2, authorID);

		// Step 4: execute query
		int affectedRecordAmount1 = preparedStatement.executeUpdate();
		// handling results
		System.out.println("Number of inserted record = " + affectedRecordAmount1);

//	Question 4: Tạo method để update tên của position gồm có id = 5 thành "Dev".
		String sql4 = "INSERT INTO `testingsystem`.`position` (`name`) VALUES (?);";
		PreparedStatement prepStatement = connection.prepareStatement(sql4);
		System.out.println("Insert position name into position table: ");
		String positionName = scanner.nextLine();
		prepStatement.setString(1, positionName);
		int affectedRecord = prepStatement.executeUpdate();

		System.out.println("Number of inserted record into position table: " + affectedRecord);

//		Question 5: 
//		Tạo method để delete của position theo id và user sẽ nhập vào id
		// delete record using scanner
		System.out.println("Insert group id that you want to delete: ");
		int groupID = scanner.nextInt();
		String sql5 = "DELETE FROM `testingsystem`.`group` WHERE (`id` =" + groupID + ");";
		PreparedStatement prepStatement1 = connection.prepareStatement(sql5);

		// prepStatement.setInt(1, groupID);

		System.out.println("Number of deleted record: " + prepStatement1.executeUpdate());

		// close connection
		connection.close();

	}

}
