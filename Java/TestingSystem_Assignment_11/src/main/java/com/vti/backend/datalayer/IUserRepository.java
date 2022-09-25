package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

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
	List<User> getListUsers() throws ClassNotFoundException, SQLException;

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
	void createUser(String username) throws Exception;

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
	boolean userExists(String username);

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
	boolean userIDExists();

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
	User getUserByID();

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
	void updateUserByID();

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
	void deleteUser(String username);

}
