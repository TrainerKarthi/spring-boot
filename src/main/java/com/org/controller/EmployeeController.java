package com.org.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.Employee;
import com.org.respository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
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
		
//		save the employee object
		repository.save(employee);//inserting the data as well as updating
		
		System.out.println("Data Saved");
		return employee;
		
	}
	
	@PutMapping("/updating_emp")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
//		Optional<Employee> optional = repository.findById(employee.getId());
		
//		Employee empFromDB = optional.orElse(null);
//		
//		if(empFromDB != null) {
//			empFromDB.setName(employee.getName());
//			empFromDB.setAge(employee.getAge());
//		}
//		else {
//			return null;
//		}
//		
//		repository.save(empFromDB);
		
		repository.save(employee);
		
		return employee;
	}
	
	@GetMapping("/sample")
	public String getById(@RequestParam String name) {
		
		System.out.println(name);
		
		return "data received";
	}
	
	
	@GetMapping("/get_by_id/{id}")
	public Employee getByAge(@PathVariable int id) {
		
		Optional<Employee> optional = repository.findById(id);
		
//		if(optional.isPresent())
//			return optional.get();
//		else
//		return null;
		
		return optional.orElse(null);
	}
}
