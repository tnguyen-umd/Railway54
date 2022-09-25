//
package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vti.backend.businesslayer.UserService;
import com.vti.entity.Employee;
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

	public List<Employee> getListUsers() throws ClassNotFoundException, SQLException {
		return service.getListUsers();
	}

	public void createUser(String name) throws Exception {
		// validation
		if (name == null || name.length() <= 6 || !isNameValid(name)) {
			throw new Exception("name must be greater than 6 characters and no special characters");
		}

		// logic service
		if (service.userExists(name)) {
			throw new Exception("name exists!");
		}

		service.createUser(name);
	}

	public boolean userExists(String name) {
		return service.userExists(name);
	}

	public boolean userIDExists(int id) {
		return service.userIDExists(id);
	}

	public User getUserByID(int id) {
		return service.getUserByID(id);
	}

	public void updateUserByID(int id) {
		service.updateUserByID(id);
	}

	public void deleteUser(String name) {
		service.deleteUser(name);
	}

	public void deleteUser(int id) {
		service.deleteUser(id);
	}

	public boolean login(String email, String password) throws Exception {

		// Regex to check valid password.
		String regex = "[A-Z]";

		// Compile the ReGex
		Pattern pattern = Pattern.compile(regex);

		// Pattern class contains matcher() method
		// to find matching between given password
		// and regular expression.
		Matcher matcher = pattern.matcher(password);

		// validation
		if (password == null || password.length() <= 6 || password.length() >= 12 || matcher.matches()) {
			throw new Exception("Password must have between 6-12 characters and at least 1 uppercase letter");
		}
		if (!isValidEmailAddress(email)) {
			throw new Exception("Invalid email format!");
		}

		return service.login(email, password);

	}

	public boolean isValidEmailAddress(String email) {
		return service.isValidEmailAddress(email);

	}

	public boolean isNameValid(String name) {
		return service.isNameValid(name);

	}
}
