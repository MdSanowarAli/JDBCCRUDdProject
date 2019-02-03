package com.naztech.main;

import java.sql.SQLException;

import com.naztech.dbUtil.JDBCConnection;
import com.naztech.model.Employee;
import com.naztech.service.EmployeeDaoImpl;

public class MainOperation {

	public static void main(String[] args) throws ClassNotFoundException {

		JDBCConnection jdbcConnection = new JDBCConnection(); // JDBC Connection JDBCConnection

		EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(); // Repository EmployeeDaoImpl

		Employee employee = new Employee(); // Create instance of Employee object

		jdbcConnection.getConnection();

		
		// For SAVING data into Employee Table Done
		/*try {
			employee.setName("Masum");
			employee.setSalary(15000);
			employee.setCity("Dhaka");
			employee.setZipCode("1216");
			employee.setCountry("USA");

			employeeDao.save(employee); // Save user in DB

			// System.out.println("Saving");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		
		
		// For UPDATING data into Employee Table Done
		/*try {
			employee.setEmp_id(1);
			employee.setName("Raz");
			employee.setSalary(5000);
			employee.setCity("Dhaka");
			employee.setZipCode("1216");
			employee.setCountry("America");

			employeeDao.update(employee); // Update user in DB

			// System.out.println("Updating");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		
		
		//Deleting Employee Table Data Done
		/*try {
			employee.setEmp_id(12);
			employeeDao.delete(employee); // Delete user in DB

			// System.out.println("Deleting");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}*/

		
		
		// Display all Employees
		/*try {
			employeeDao.getAll();
			System.out.println("Get ALL Completed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		
		// Display of Employee with ID = 1
		/*try {
			employeeDao.find(17);
	
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}*/
		
		
		
		//Max Salary using WILDCARD
		try {
			  //Dao Implementation class a jodi Set get kore Print dile sudhu method call korlei cholbe
			  employeeDao.max();
			  
			  //Main Class theke print dite hole ai System Flow korte hobe
			/*
			 * employee.setSalary(employeeDao.max()); 
			 * System.out.print("MAX SALARY: " + employee.getSalary());
			 */
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		//Min Salary using IN
		try {
				//employeeDao.min();
					  
				employee.setSalary(employeeDao.min()); 
				System.out.println("MIN SALARY: " + employee.getSalary());
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		//Avg Salary using BETWEEN
		try {
				//employeeDao.min();
					  
				employee.setSalary(employeeDao.avg()); 
				System.out.println("AVG SALARY: " + employee.getSalary());
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		//COUNT Total row of Salary Column
		try {
				//employeeDao.min();
							  
				employee.setSalary(employeeDao.count()); 
				System.out.println("Count SALARY: " + employee.getSalary());
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		//COUNT Salary by using GROUP BY & ORDER BY & HAVING in a LIST
		try {
				employeeDao.countGroupBy_OrderBy_List();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		
		
		//TOP of Salary
				try {
						//employeeDao.min();
									  
						employee.setSalary(employeeDao.top()); 
						System.out.println("TOP SALARY: " + employee.getSalary());
								
				} catch (SQLException e) {
					e.printStackTrace();
				}		
		

	}

}
