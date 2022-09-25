package com.vti.frontend;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.GroupController;
import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Group;
import com.vti.entity.User;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		GroupController controller = new GroupController();

		// create an array and get info from calling businesslayer-->datalayer
		List<Group> groups = controller.getListGroups();

		// print out groups array
		for (Group group : groups) {
			System.out.println(group);
		}

		// create an array and get info from calling businesslayer-->datalayer
		UserController userController = new UserController();
		List<User> users = userController.getListUsers();

		// print out users array
		for (User user : users) {
			System.out.println(user.toString());
		}
	}
}
