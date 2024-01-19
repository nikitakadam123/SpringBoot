package com.demo.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
