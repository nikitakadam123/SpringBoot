package com.spring.controller;

import java.util.List;

import com.spring.model.Employee;
import com.spring.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class EmployeeController 
{	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/emp")
	public  String getAllEmp(Model model)
	{
		List<Employee> list=employeeService.getAllEmployees();
		model.addAttribute("employee",list);
		return "employee_list";
	}
	
	@GetMapping("/emp/{id}")
	public String getEmployee(@PathVariable int Id,Model model)
	{
		Employee employee=employeeService.getEmployeeById(Id);
		model.addAttribute("employee", employee);
		//return employeeService.getEmployeeById(Id);
		return "employee_view";
	}
	
	
	
	@GetMapping("emp/new")
	public String newEmployeeForm(Model model)
	{
		System.out.println("Third");
		model.addAttribute("employee", new Employee());
		return "employee_form";
	}
	
	@PostMapping("/emp/save")
	public String addEmployee(@ModelAttribute Employee employee)
	{
		System.out.println("Four");
		employeeService.addEmployee(employee);
		return "redirect:/emp";
	}
		
	
	@GetMapping("/emp/edit/{id}")
	public String updateEmployeeId(@PathVariable int id,Model model)
	{
		Employee employee=employeeService.getEmployeeById(id);
		return "employee_form";
	}
	
	@GetMapping("/emp/delete/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		employeeService.deleteEmployee(id);
		return "redirect:/emp";
	}
	

}