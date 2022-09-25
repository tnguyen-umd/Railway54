package com.vti.backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	static Connection connection;

	// =======================ESTABLISH DATABASE CONNECTION=========================
	public static void connectDatabase() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src/main/resources/database.properties"));
			properties.load(new FileInputStream("src/main/resources/message.properties"));

			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			// register the driver class with DriverManager
			try {
				Class.forName(properties.getProperty("driver"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("SQL driver incorrect");
			}

			// Step 2: get a Database Connection
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQL login failed!");
			}
			System.out.println(properties.getProperty("connection.success"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection failed!");
		}

	}
	// =============================================================================

	public static void disconnectDatabase() {
		try {
			connection.close();
			System.out.println("Successfully disconnected database!");
		} catch (SQLException e) {
			System.out.println("Disconnection failed!");
		}
	}

}
