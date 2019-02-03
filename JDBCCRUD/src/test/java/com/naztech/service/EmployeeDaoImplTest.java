package com.naztech.service;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.naztech.dbUtil.JDBCConnection;
import com.naztech.model.Employee;

public class EmployeeDaoImplTest {

	/*JDBCConnection jdbcConnection= new JDBCConnection();
	EmployeeDaoImpl employeeDao= new EmployeeDaoImpl();
	
	@Test
	public void testSave() throws ClassNotFoundException, SQLException {
		//System 1 (ai System kora jai but not good...2nd system a kora hoyeche saita best)
		//Employee employee= new Employee(0, "Dil", 13000, "Newyork", "USA", "2025");
		
		//System 2
		Employee employee= new Employee();
		employee.setName("Mr. Omuk");
		employee.setSalary(50000);
		employee.setCity("Dhaka");
		employee.setCountry("BD");
		jdbcConnection.getConnection();
		//assertTrue(employeeDao.save(employee));
	}

	@Test
	public void testUpdate() throws ClassNotFoundException, SQLException {
		Employee employee= new Employee();
		employee.setEmp_id(5);
		employee.setName("Mr. Omuk");
		employee.setSalary(50000);
		employee.setCity("Dhaka");
		employee.setCountry("BD");
		jdbcConnection.getConnection();
		assertTrue(employeeDao.update(employee));
	}

	@Test
	public void testDelete() throws ClassNotFoundException, SQLException {
		Employee employee= new Employee();
		employee.setEmp_id(2);
		jdbcConnection.getConnection();
		//assertTrue(employeeDao.delete(employee));
	}

	@Test
	public void testGetAll() throws ClassNotFoundException, SQLException {
		Employee employee= new Employee();
		List<Employee> emp= new ArrayList<Employee>();
		emp = employeeDao.getAll();
		assertEquals(emp.size(), 23);
		//equals(emp);
	}

	@Test
	public void testFind() throws ClassNotFoundException, SQLException {
		Employee employee= new Employee();
		employee = employeeDao.find(10);
		//assertNotNull(employee.getEmp_id());
	}*/

	 

}
