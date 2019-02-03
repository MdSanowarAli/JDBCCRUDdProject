package com.naztech.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naztech.dao.IEmployeeDao;
import com.naztech.dbUtil.JDBCConnection;
import com.naztech.model.Employee;

public class EmployeeDaoImpl implements IEmployeeDao<Employee> {
	// JDBC Connection
	JDBCConnection jdbcConnection = new JDBCConnection();

	PreparedStatement pstm = null;

	// Create
	public boolean save(Employee sql) throws ClassNotFoundException, SQLException {
		pstm = jdbcConnection.con.prepareStatement("Insert into dbo.T_Sanowar_Employee values(?,?,?,?,?)");
		pstm.setString(1, sql.getName());
		pstm.setFloat(2, sql.getSalary());
		pstm.setString(3, sql.getCity());
		pstm.setString(4, sql.getZipCode());
		pstm.setString(5, sql.getCountry());
		pstm.execute();
		pstm.close();
		return true;
	}

	// Update
	public boolean update(Employee sql) throws ClassNotFoundException, SQLException {
		pstm = jdbcConnection.con.prepareStatement(
				"Update dbo.T_Sanowar_Employee SET name=?, salary=?, city=?, zip_code=?, country=? WHERE emp_id=? ");
		pstm.setString(1, sql.getName());
		pstm.setFloat(2, sql.getSalary());
		pstm.setString(3, sql.getCity());
		pstm.setString(4, sql.getZipCode());
		pstm.setString(5, sql.getCountry());
		pstm.setInt(6, sql.getEmp_id());
		pstm.executeUpdate();
		pstm.close();
		return true;
	}

	// Delete
	public boolean delete(Employee sql) throws ClassNotFoundException, SQLException {
		pstm = jdbcConnection.con.prepareStatement("Delete from dbo.T_Sanowar_Employee where emp_id=?");
		pstm.setInt(1, sql.getEmp_id());
		pstm.executeUpdate();
		return true;
	}

	// Retrieve All
	public List<Employee> getAll() throws ClassNotFoundException, SQLException {

		ArrayList<Employee> employees = new ArrayList<Employee>();
		try {
			pstm = jdbcConnection.con.prepareStatement("Select * from dbo.T_Sanowar_Employee");

			ResultSet resultSet = pstm.executeQuery();

			Employee employee = null;

			while (resultSet.next()) {

				employee = new Employee();

				employee.setEmp_id(resultSet.getInt("emp_id"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getFloat("salary"));
				employee.setCity(resultSet.getString("city"));
				employee.setZipCode(resultSet.getString("zip_code"));
				employee.setCountry(resultSet.getString("country"));

				// System.out.println(employee.toString());

				// Sysout use korle ai code gula akhane korbo but Test ba onno framework a
				// output er khetre aikhane declare korbo na
				System.out.print(employee.getEmp_id());
				System.out.print(employee.getName());
				System.out.print(employee.getSalary());
				System.out.print(employee.getCity());
				System.out.print(employee.getZipCode());
				System.out.print(employee.getCountry());
				System.out.println("");

				employees.add(employee);
			}
			resultSet.close();
			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return employees;
	}

	// Retrieve by ID
	public Employee find(int id) throws ClassNotFoundException, SQLException {
		Employee employee = null;

		try {
			pstm = jdbcConnection.con.prepareStatement("SELECT * FROM dbo.T_Sanowar_Employee WHERE emp_id=?");
			pstm.setInt(1, id); // Set 1st WHERE to int

			ResultSet resultSet = pstm.executeQuery();

			if (resultSet.next()) {
				employee = new Employee();

				employee.setEmp_id(resultSet.getInt("emp_id"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getFloat("salary"));
				employee.setCity(resultSet.getString("city"));
				employee.setZipCode(resultSet.getString("zip_code"));
				employee.setCountry(resultSet.getString("country"));

				// Sysout use korle ai code gula akhane korbo but Test ba onno framework a
				// output er khetre aikhane declare korbo na
				System.out.println("Find By ID");
				System.out.print(employee.getEmp_id());
				System.out.print(employee.getName());
				System.out.print(employee.getSalary());
				System.out.print(employee.getCity());
				System.out.print(employee.getZipCode());
				System.out.print(employee.getCountry());
				System.out.println("");
			}
			resultSet.close();
			pstm.close();
		} catch (SQLException e) { // e.printStackTrace(); throw new
		}
		return employee;
	}

	
	//Retrieve by Max Salary using WILDCARD
	public int max() throws ClassNotFoundException, SQLException {
		Employee employee = null;
		int id = 0;
		pstm = jdbcConnection.con.prepareStatement("Select MAX(salary) from dbo.T_Sanowar_Employee WHERE country LIKE 'u%'");
		ResultSet resultSet = pstm.executeQuery();

		if (resultSet.next()) {
			id = resultSet.getInt(1);
			
			  employee = new Employee(); 
			  employee.setSalary(id);
			  System.out.println("MAX SALARY: " + employee.getSalary());	 
		}
		return id;
	}

	
	//Retrieve by Min Salary using IN
	public int min() throws SQLException {
		int id = 0;
		pstm = jdbcConnection.con.prepareStatement("Select MIN(salary) from dbo.T_Sanowar_Employee WHERE country IN ('bangladesh', 'america')");
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			id = rs.getInt(1);
		}
		return id;
	}

	
	//Retrieve by Avg Salary using BETWEEN
	public int avg() throws SQLException {
		int id = 0;
		pstm = jdbcConnection.con.prepareStatement("Select AVG(salary) from dbo.T_Sanowar_Employee WHERE salary BETWEEN 6000 AND 20000;");
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			id = rs.getInt(1);
		}
		return id;
	}

	//Retrieve by COUNT Total row of Salary Column
	public int count() throws SQLException {
		int id = 0;
		pstm = jdbcConnection.con.prepareStatement("Select COUNT(salary) from dbo.T_Sanowar_Employee");
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			id = rs.getInt(1);
		}
		return id;
	}
	
	//Retrieve by COUNT Salary by using GROUP BY & ORDER BY & HAVING in a LIST
	public List<Employee> countGroupBy_OrderBy_List() throws ClassNotFoundException, SQLException {
		Employee employee = null;
		//int id = 0;
		pstm = jdbcConnection.con.prepareStatement("SELECT Count(salary),country FROM dbo.T_Sanowar_Employee GROUP BY country HAVING COUNT(emp_id) > 5 ORDER BY country DESC;");
		ResultSet rs = pstm.executeQuery();

		List <Employee> topList = new ArrayList<Employee>();
				
		while (rs.next()) {
			//id = rs.getInt(1);
			employee = new Employee(); 
			employee.setSalary(rs.getInt(1));
			topList.add(employee);
			System.out.println("Count Group By SALARY: " + employee.getSalary());
		}
			return topList;
		}
	
	//Retrieve by TOP of Salary
	public int top() throws SQLException {
		int id = 0;
		pstm = jdbcConnection.con.prepareStatement("Select TOP 1 salary from dbo.T_Sanowar_Employee");
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			id = rs.getInt(1);
		}
		return id;
	}
	
			
}
