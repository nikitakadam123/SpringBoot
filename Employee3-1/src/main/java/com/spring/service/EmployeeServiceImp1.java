package com.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.*;
import com.spring.repository.*;

@Service
public class EmployeeServiceImp1 implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int Id) {
		Employee employee=null;
		employee=employeeRepository.findById(Id);
		return employee;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Employee employee2=employeeRepository.save(employee);
		return employee2;
	}

	@Override
	public Employee updateEmployeeId(Employee employee, int id) {
		employee.setEmpId(id);
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
	}

	
}

