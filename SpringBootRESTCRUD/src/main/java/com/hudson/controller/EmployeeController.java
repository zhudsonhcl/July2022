package com.hudson.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hudson.model.Employee;
import com.hudson.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> listAllEmployees() {
		return employeeService.getAllEmps();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmpId(@PathVariable Integer id) {
		return employeeService.getEmpById(id);
	}
	
	@PostMapping("/employees")
	public void addEmp(@RequestBody Employee emp) {
		employeeService.createEmployee(emp);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmpById(@PathVariable Integer id) {
		employeeService.deleteEmpById(id);
	}
	
	@PutMapping("employees/{id}")
	public void updateEmpById(@PathVariable Integer id, @RequestBody Employee emp) {
		employeeService.updateEmpById(id, emp);
	}
}
