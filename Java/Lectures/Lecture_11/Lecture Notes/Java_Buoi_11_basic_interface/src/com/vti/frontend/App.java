//
package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.utils.JDBCUtils;

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
public class App {

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: TNguyen
	 * @create_date: Sep 19, 2022
	 * @version: 1.0
	 * @modifer: TNguyen
	 * @modifer_date: Sep 19, 2022
	 * @param args
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		JDBCUtils jdbcUtils = new JDBCUtils();
		jdbcUtils.getConnection();

	}

}
