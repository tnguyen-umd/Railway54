package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

	private Connection connection;

	public Connection getConnection() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {

		Properties properties = new Properties();

		if (connection == null || connection.isClosed()) {

			properties.load(new FileInputStream("resources/database.properties"));
			properties.load(new FileInputStream("resources/message.properties"));

			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			// Step 1* register the driver class with DriverManager
			Class.forName(properties.getProperty("driver"));

			// Step 2: get a Database Connection

			connection = DriverManager.getConnection(url, username, password);
		}

		return connection;
	}

	public void disconnect() throws SQLException {
		if (connection != null && connection.isClosed()) {
			connection.close();
		}
	}
}
