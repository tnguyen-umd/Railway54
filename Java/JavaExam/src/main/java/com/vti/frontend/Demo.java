//
package com.vti.frontend;

import java.sql.SQLException;
import java.util.Scanner;

import com.vti.backend.presentationlayer.UserController;
import com.vti.utils.JDBCUtils;

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
public class Demo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		UserController controller = new UserController();

		JDBCUtils.connectDatabase();

		while (true) {
			System.out.println("-------------------------MAIN MENU----------------------------------------");
			System.out.println("Please select an option: ");
			System.out.println("1-List all users");
			System.out.println("2-Get user info by ID");
			System.out.println("3-Delete user");
			System.out.println("4-Login");
			System.out.println("5-Exit");
			int input = scanner.nextInt();

			switch (input) {
			case 1:
				try {
					controller.getListUsers();
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				break;

			case 2:
				System.out.print("Please input an user ID to show info: ");
				int id1 = scanner.nextInt();
				controller.getUserByID(id1);

				break;

			case 3:
				System.out.print("Please input an user ID to delete: ");
				int id2 = scanner.nextInt();
				controller.deleteUser(id2);

				break;

			case 4:
				System.out.println("Login process");
				System.out.println("Please provide your email address and password: ");
				System.out.print("Email: ");
				String email = scanner.next();
				System.out.print("Password: ");
				String password = scanner.next();

				boolean status;
				try {
					status = controller.login(email, password);

					if (!status) {
						System.out.println("Login failed");
						break;
					}

					if (status && email.equals("admin@gmail.com")) {
						System.out.println("Logged in as administrator");

						System.out.println("**********ADMIN OPTIONS*****************");
						System.out.println("Option 1: create new employee profile");
						System.out.println("Option 2: return to main menu");
						int input2 = scanner.nextInt();

						switch (input2) {
						case 1:
							System.out.print("Please input new employee name: ");
							String name = scanner.next();
							try {
								controller.createUser(name);
								break;
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						default:
							break;

						}
					} else if (status && !email.equals("admin@gmail.com")) {
						System.out.println("Logged in as employee");
						break;

					}

				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				break;

			case 5:
				System.out.println("Program terminated");
				return;

			default:
				System.out.println("Please select a correct option");
				break;

			}
		}

	}
}
