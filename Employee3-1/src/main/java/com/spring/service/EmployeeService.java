package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.model.*;
@Service
public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int Id);
	public Employee addEmployee(Employee employee);
	public Employee updateEmployeeId(Employee employee,int id);
	public void deleteEmployee(int id);
}
