//
package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.presentationlayer.UserController;

/**
 * This class is to use as demo
 * 
 * @Description: .
 * @author: TNguyen
 * @create_date: Sep 20, 2022
 * @version: 1.0
 * @modifer: TNguyen
 * @modifer_date: Sep 20, 2022
 */
public class Demo {

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 20, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 20, 2022
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		UserController controller = new UserController();

		// create user by using scanner to get a string input
		System.out.print("Input username: ");
		Scanner scanner = new Scanner(System.in);

		/**
		 * this username will be used to input at UserController.createUser(String
		 * username)-->UserService.createUser(String
		 * username)-->UserRepository.createUser(String username)
		 */
		String username = scanner.next();

		try {
			controller.createUser(username);
			System.out.println("Create success!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("create fail!");
		}

		// create an array and get info from calling businesslayer-->datalayer
		// controller.userIDExists();
		// controller.getUserByID();
		// controller.updateUserByID();
		// controller.deleteUser();

	}

}
