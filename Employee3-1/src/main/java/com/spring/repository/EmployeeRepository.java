package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.*;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findById(int Id);

}
