package com.suve.dao;

import com.suve.beans.Employee;

public interface Dao {
	
	public String insertEmployeeDetails(Employee employee);
	
	public Employee getEmployeeDetailsById(int id);
	
	public Employee updateEmployeeSalary(int id, int amount);
	
	

}
