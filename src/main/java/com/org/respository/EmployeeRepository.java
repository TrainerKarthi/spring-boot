package com.org.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
