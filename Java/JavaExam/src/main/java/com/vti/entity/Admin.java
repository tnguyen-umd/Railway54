//
package com.vti.entity;

/**
 * This class is .
 * 
 * @Description: .
 * @author: TNguyen
 * @create_date: Sep 23, 2022
 * @version: 1.0
 * @modifer: TNguyen
 * @modifer_date: Sep 23, 2022
 */
public class Admin extends User {
	private int ExpInYear;

	/**
	 * Constructor for class admin.
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 23, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 23, 2022
	 * @param id
	 * @param username
	 * @param email
	 * @param password
	 * @param expInYear
	 */
	public Admin(int id, String username, String email, String password, int expInYear) {
		super(id, username, email, password);
		ExpInYear = expInYear;
	}

}
