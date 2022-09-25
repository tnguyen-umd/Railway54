import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost/testingsystem?autoReconnect=true&useSSL=false&characterEncoding=latin1";

		// "jdbc:sqlserver://localhost;user=root;password=Alger#01;";

		// String url = properties.getProperty("url");
		String username = "root";
		String password = "Alger#01";
		// register the driver class with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: get a Database Connection
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection successful");

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
		String sql1 = "INSERT INTO `group` (`name`, `author_ID`) VALUES ('Java Senior4', '4');";
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
