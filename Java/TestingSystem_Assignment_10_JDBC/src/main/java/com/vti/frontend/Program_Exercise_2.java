package com.vti.frontend;

import java.sql.SQLException;

import com.vti.backend.DepartmentDao;
import com.vti.backend.JdbcUtils;

public class Program_Exercise_2 {

	public static void main(String[] args) throws SQLException {

		JdbcUtils.connectDatabase();
//		DepartmentDao.getDepartments();
		// DepartmentDao.getDepartmentByID();
		// JdbcUtils.disconnectDatabase();
		// DepartmentDao.depNameExists();
		// DepartmentDao.createDepartment();
		// DepartmentDao.depIDExists();
		// DepartmentDao.deleteDepartment();
		// DepartmentDao.updateDepartmentName();
		DepartmentDao.deleteDepartmentUsingProcedure();

	}
}
