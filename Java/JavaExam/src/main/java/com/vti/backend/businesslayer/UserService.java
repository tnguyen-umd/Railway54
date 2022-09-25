//
package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
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
public class UserService implements IUserService {

//	****************************Tạo validation & xử lý exception ở class controller, repository cho các chức năng trên.

	private IUserRepository repository;

	/**
	 * Constructor for class UserService.
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 19, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 19, 2022
	 * @param repository
	 */
	public UserService() {
		repository = new UserRepository();
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#getListUsers()
	 */
	public List<Employee> getListUsers() throws ClassNotFoundException, SQLException {
		return repository.getListUsers();
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#createUser()
	 */
	public void createUser(String name) throws Exception {
		repository.createUser(name);
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#userExists()
	 */
	public boolean userExists(String name) {
		return repository.userExists(name);
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#userIDExists()
	 */
	public boolean userIDExists(int id) {
		return repository.userIDExists(id);
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#getUserByID()
	 */
	public User getUserByID(int id) {
		return repository.getUserByID(id);
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#updateUserByID()
	 */
	public void updateUserByID(int id) {
		repository.updateUserByID(id);
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#deleteUser()
	 */
	public void deleteUser(String name) {
		repository.deleteUser(name);
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#deleteUser(int)
	 */
	public void deleteUser(int id) {
		repository.deleteUser(id);
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#login(java.lang.String,
	 * java.lang.String)
	 */
	public boolean login(String email, String password) {
		return repository.login(email, password);
	}

	public boolean isValidEmailAddress(String email) {
		return repository.isValidEmailAddress(email);

	}

	public boolean isNameValid(String name) {
		return repository.isNameValid(name);
	}

}
