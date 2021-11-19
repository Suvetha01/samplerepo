package com.suve.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.suve.beans.Employee;
import com.suve.dao.Dao;


@Controller
public class MyController {
	
	@Autowired
	private Dao dao;
	
	
	
	@GetMapping("/")
	public String homeHandler() {
		
		return "home";
	}
	
	
	
	
	
	@GetMapping("/employeeRegistration")
	public String employeeHandler() {
		
		return "employeeRegistration";
	}
	
	@GetMapping("/getemployee")
	public String getEmployee() {
		
		return "getemployee";
	}
	

	
	@PostMapping("/EmployeeRegister")
	public ModelAndView employeeRegisterHandler(Employee employee) {
	
		String result = dao.insertEmployeeDetails(employee);

		ModelAndView mv =new ModelAndView("employeeRegisterSuccess");
		
		mv.addObject("resultData",result);
		
		
		return mv;
		
	}
	
	
	
	@PostMapping("/searchemployee")
	public ModelAndView searchemployee(int id) {
		
		 Employee employee = dao.getEmployeeDetailsById(id);
		 
		 System.out.println(employee.getName());
		 
		 ModelAndView mv= new ModelAndView("getemployeeResult");
		 
		 mv.addObject("resultEmp",employee);
		
		
		return mv;
		
	}
	

}
