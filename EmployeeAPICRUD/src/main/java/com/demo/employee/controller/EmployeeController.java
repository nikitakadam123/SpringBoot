package com.demo.employee.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee.model.Employee;
import com.demo.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/employees")              //insert data into table
	public String createNewEmployee (@RequestBody Employee employee){
		employeeRepository.save(employee);
		return "Employee Created in database";
	}
	
	@PostMapping("/employees/{empid}")    //insertElement at any postion
	public String insertEmployee(@PathVariable Long empid, @RequestBody Employee employee) {
	    Optional<Employee> existingEmployeeOptional = employeeRepository.findById(empid);

	    if (existingEmployeeOptional.isPresent()) {
	        // Employee with the given ID already exists, you might want to handle this case
	        return "Employee with ID " + empid + " already exists.";
	    } else {
	        // Save the new employee
	        employeeRepository.save(employee);
	        return "Employee created in the database.";
	    }
	}
	
	@GetMapping("/employees")              //Display All Data from Table
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> empList=new ArrayList<>();
	    employeeRepository.findAll().forEach(empList::add);
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK); 
		
	}
	
	@GetMapping("/employees/{empid}")               //Retrive PERTICULER data useing user id
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long empid){
		Optional<Employee> emp = employeeRepository.findById(empid);       //optinal is an interface use of this is to avoid null pointer exception if id is not present
		if(emp.isPresent()) {
			return new ResponseEntity <Employee>(emp.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity <Employee>(HttpStatus.NOT_FOUND);

		}
	}
	
	//Update emp data by id return in string msg
	@PutMapping("/employees/{empid}")
	public String updateEmployeeById(@PathVariable long empid, @RequestBody Employee employee) {
		Optional<Employee> emp=employeeRepository.findById(empid);
		if(emp.isPresent())
		{
			Employee existEmp = emp.get();
			existEmp.setEmp_age(employee.getEmp_age());
			existEmp.setEmp_city(employee.getEmp_city());
			existEmp.setEmp_name(employee.getEmp_name());
			existEmp.setEmp_salary(employee.getEmp_salary());
			employeeRepository.save(existEmp);
			return "Employee Details against Id "+empid+" Updated";
		}else {
			
			return "Employee Details does not exist for empid"+empid;
		}
		}
	
	//delete perticuler data using empid
	@DeleteMapping("/employees/{empid}")
	public String deleteEmployeeById(@PathVariable Long empid) {
		employeeRepository.deleteById(empid);
		return "Employee Deleted Successfully";
	}
	
	//delete all data
	@DeleteMapping("/employees")
	public String deleteAllEmployee() {
		employeeRepository.deleteAll();
		return "Employee Deleted Successfully";
	}

}
