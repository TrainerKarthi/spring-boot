package com.org.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		
		System.out.println(employee);
		
//		save the employee object
		Employee employee2 = repository.save(employee);//inserting the data as well as updating
		
		System.out.println("Data Saved");
		return new ResponseEntity<Employee>(employee2,HttpStatus.CREATED);
		
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
	public Employee getById(@PathVariable int id) {
		
		Optional<Employee> optional = repository.findById(id);
		
//		if(optional.isPresent())
//			return optional.get();
//		else
//		return null;
//		repository.deleteById(null);
		
		return optional.orElse(null);
	}
	
	@GetMapping("/fetchAll")
	public List<Employee> getAll(){
		
		List<Employee> list = repository.findAll();
		
		return list;
	}
	
	
	@GetMapping("/fetchByName/{name}")
	public List<Employee> getByName(@PathVariable String name){
		
		List<Employee> list = repository.findByName(name);
		
		return list;
		
	}
	
	@GetMapping("/fetchByEmAndPwd/{email}/{password}")
	public Employee getByEmailPassword(@PathVariable String email,@PathVariable String password) {
		
		Employee employee = repository.findByEmailAndPassword(email, password);
		
		return employee;
	}
	
	@GetMapping("/findByAgeCondition/{age}")
	public ResponseEntity<List<Employee>> getByAgeCondition(@PathVariable int age){
		
		 List<Employee> list = repository.findByAgeCondition(age);
		 
		if(list == null || list.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
}
