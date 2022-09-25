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
public class Employee extends User {
	private String ProSkill;// dev, test, java, sql, …)

	/**
	 * Constructor for class Employee.
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
	 * @param proSkill
	 */
	public Employee(int id, String username, String email, String password, String proSkill) {
		super(id, username, email, password);
		ProSkill = proSkill;
	}

}
