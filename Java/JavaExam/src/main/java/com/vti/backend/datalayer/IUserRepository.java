package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.User;

/**
 * This class is to add new user
 * 
 * @Description: .
 * @author: TNguyen
 * @create_date: Sep 20, 2022
 * @version: 1.0
 * @modifer: TNguyen
 * @modifer_date: Sep 20, 2022
 */
public interface IUserRepository {
	List<Employee> getListUsers() throws ClassNotFoundException, SQLException;

	/**
	 * This method is to create new user by putting username
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
	 * This method is to check if user exists by checking username
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
	 * This method is to check if user exists by checking id
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
	 * This method is to find user by his id
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
	 * This method is to update username by his ID
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
	 * This method is to delete user by username
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 20, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 20, 2022
	 */
	void deleteUser(String name);

	/**
	 * This method is TO DELETE USER BY id
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 23, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 23, 2022
	 * @param id
	 */
	void deleteUser(int id);

	/**
	 * This method is for login
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 23, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 23, 2022
	 * @param email
	 * @param password
	 */
	boolean login(String email, String password);

	/**
	 * This method is to validate email format
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 23, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 23, 2022
	 * @param email
	 * @return
	 */
	boolean isValidEmailAddress(String email);

	/**
	 * This method is to validate name without special characters
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 23, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 23, 2022
	 * @param name
	 * @return
	 */
	boolean isNameValid(String name);
}
