//
package com.vti.entity;

/**
 * This class is to create an user class matching with database
 * 
 * @Description: .
 * @author: TNguyen
 * @create_date: Sep 19, 2022
 * @version: 1.0
 * @modifer: TNguyen
 * @modifer_date: Sep 19, 2022
 */
public class User {
	private int id;
	private String username;
	private String email;

	/**
	 * Constructor for class User.
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 19, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 19, 2022
	 * @param id
	 * @param name
	 * @param email
	 */
	public User(int id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getUserName() {
		return username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User id=" + id + ", username=" + username + ", email=" + email;
	}

}
