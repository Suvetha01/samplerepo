package com.suve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.suve.beans.Employee;
import com.suve.utility.DBUtil;

@Repository
public class DaoImpl implements Dao{
	
	
	@Override
	public String insertEmployeeDetails(Employee employee) {
		
		
		
        String result = "Not inserted....";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?)");
			
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setInt(3, employee.getSalary());
			
			int x = ps.executeUpdate();
			
			if(x>0) 
				result = "Record inserted successfully...";
			
			
		}catch(Exception e) {
			
			result = e.getMessage();
			e.printStackTrace();
			
		}
		
		return result;
		


	}
	
	
	

	@Override
	public Employee getEmployeeDetailsById(int id) {
		
        Employee eb = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where id = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int i = rs.getInt("id");
				String n = rs.getString("name");
				int s = rs.getInt("salary");
				
				eb = new Employee(i, n, s);
				
				
			}	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		return eb;
	}

	@Override
	public Employee updateEmployeeSalary(int id, int amount) {
               
		
        Employee eb = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("update employee set salary = salary+? where id = ?");
			
			ps.setInt(1, amount);
			ps.setInt(2,  id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Salary Incremented");
			}

			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return eb;

		
	}

}
