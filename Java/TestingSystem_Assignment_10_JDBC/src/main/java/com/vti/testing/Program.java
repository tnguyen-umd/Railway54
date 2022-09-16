package com.vti.testing;

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

public class Program {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
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
		String sql1 = "INSERT INTO `group` (`name`, `author_ID`) VALUES ('Java Senior5', '4');";
		// Step 4: execute query
		int affectedRecordAmount = statement.executeUpdate(sql1);
		// handling results
		System.out.println("Affected record amount = " + affectedRecordAmount);

		// How to insert statement using scanner by user, make sure to use executeUpdate
		// instead of
		// excuteQuery
		String sql2 = "INSERT INTO `group` (`name`, `author_ID`) VALUES (?, ?);";
		PreparedStatement preparedStatement = connection.prepareStatement(sql2);

		// put scanner here
		// remember that in JDBC index start from 1 instead of zero
		String authorName = "A";// this is index 1 of sql2
		int authorID = 1;// this is index 2 of sql2
		preparedStatement.setString(1, authorName);
		preparedStatement.setInt(2, authorID);

		// Step 4: execute query
		int affectedRecordAmount1 = preparedStatement.executeUpdate();
		// handling results
		System.out.println("Affected record amount = " + affectedRecordAmount1);

		// close connection
		connection.close();

	}

}
