package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.User;

public interface IUserService {
	List<Employee> getListUsers() throws ClassNotFoundException, SQLException;

	/**
	 * This method is to create new user by putting name
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 20, 2022
	 * @version: 1.0
	 * @throws Exception
	 * @modifer: TNguyen
	 * @modifer_date: Sep 20, 2022
	 */
	void createUser(String name) throws Exception;

	/**
	 * This method is to check if user exists by checking name
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 20, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 20, 2022
	 * @return
	 */
	boolean userExists(String name);

	/**
	 * This method is to check if user exists by ID
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 20, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 20, 2022
	 * @return
	 */
	boolean userIDExists(int id);

	/**
	 * This method is to find user by using his ID
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 20, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 20, 2022
	 * @return
	 */
	User getUserByID(int id);

	/**
	 * This method is to update name by his ID
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 20, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 20, 2022
	 */
	void updateUserByID(int id);

	/**
	 * This method is to delete user by name
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 20, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 20, 2022
	 */
	void deleteUser(String name);

	void deleteUser(int id);

	boolean login(String email, String password);

	boolean isValidEmailAddress(String email);

	boolean isNameValid(String name);
}
