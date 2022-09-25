//
package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
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
	public List<User> getListUsers() throws ClassNotFoundException, SQLException {
		return repository.getListUsers();
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#createUser()
	 */
	public void createUser(String username) throws Exception {
		repository.createUser(username);
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#userExists()
	 */
	public boolean userExists(String username) {
		return repository.userExists(username);
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#userIDExists()
	 */
	public boolean userIDExists() {
		return repository.userIDExists();
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#getUserByID()
	 */
	public User getUserByID() {
		return repository.getUserByID();
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#updateUserByID()
	 */
	public void updateUserByID() {
		repository.updateUserByID();
	}

	/*
	 * @see com.vti.backend.businesslayer.IUserService#deleteUser()
	 */
	public void deleteUser(String username) {
		repository.deleteUser(username);
	}

}
