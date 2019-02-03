package com.naztech.model;

public class Employee {
	private int emp_id;
	private String name;
	private float salary;
	private String city;
	private String country;
	private String zipCode;
	
	public Employee() {
	}
	


	public Employee(int emp_id, String name, float salary, String city, String country, String zipCode) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.salary = salary;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
	}



	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


}
