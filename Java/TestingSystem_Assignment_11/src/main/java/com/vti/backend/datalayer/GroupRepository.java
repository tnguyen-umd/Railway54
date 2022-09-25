package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Group;
import com.vti.utils.JDBCUtils;

public class GroupRepository implements IGroupRepository {

	private JDBCUtils jdbcUtils;

	public GroupRepository() {
		jdbcUtils = new JDBCUtils();
	}

	public List<Group> getListGroups() throws SQLException {

		List<Group> groups = new ArrayList<Group>();

		// get connection
		Connection connection = jdbcUtils.connectDatabase();

		// Create a statement object
		String sql = "SELECT id, name FROM `Group`";
		Statement statement = connection.createStatement();

		// execute query
		ResultSet resultSet = statement.executeQuery(sql);

		// handling result set
		while (resultSet.next()) {
			Group group = new Group(resultSet.getInt("id"), resultSet.getString("name"));

			groups.add(group);

		}

		jdbcUtils.disconnectDatabase();

		return groups;
	}
}
