//
package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;

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
public class UserController {

	private UserService service;

	public UserController() {
		service = new UserService();
	}

	public List<User> getListUsers() throws ClassNotFoundException, SQLException {
		return service.getListUsers();
	}

	public void createUser(String username) throws Exception {
		// validation
		if (username == null || username.length() < 6) {
			throw new Exception("Username must be greater than 6 characters");
		}

		// logic service
		if (service.userExists(username)) {
			throw new Exception("Username exists!");
		}

		service.createUser(username);
	}

	public boolean userExists(String username) {
		return service.userExists(username);
	}

	public boolean userIDExists() {
		return service.userIDExists();
	}

	public User getUserByID() {
		return service.getUserByID();
	}

	public void updateUserByID() {
		service.updateUserByID();
	}

	public void deleteUser(String username) {
		service.deleteUser(username);
	}
}
