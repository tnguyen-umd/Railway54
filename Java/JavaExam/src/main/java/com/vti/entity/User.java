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
public abstract class User {
	private int id;
	private String name;
	private String email;
	private String password;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Constructor for class User.
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 23, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 23, 2022
	 * @param id
	 * @param name
	 * @param email
	 * @param password
	 */
	public User(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User information: id=" + id + ", name=" + name + ", email=" + email;
	}

}
