package com.org.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.Employee;

@RestController
public class EmployeeController {
	
	@RequestMapping("/get_employee")
	public Employee getEmployee() {
		
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Karthik");
		employee.setAge(10);
		
		return employee;
	}
	
	@PostMapping("/save_emp")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		System.out.println(employee);
		
		return employee;
		
	}
	
	@GetMapping("/sample")
	public String getById(@RequestParam String name) {
		
		System.out.println(name);
		
		return "data received";
	}
	
	
	@GetMapping("/get_by_age/{age}")
	public String getByAge(@PathVariable int age) {
		
		System.out.println(age);
		
		return "data received";
	}
}
