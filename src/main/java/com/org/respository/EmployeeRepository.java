package com.org.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	List<Employee> findByName(String name);
	
	List<Employee> findByAge(int age);
	
	Employee findByEmailAndPassword(String email, String password);
	
	@Query("SELECT e  FROM Employee e WHERE e.age>=?1")
	List<Employee> findByAgeCondition(int age);
}
