package com.hudson.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hudson.model.Employee;
import com.hudson.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmps() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmpById(int id) {
		return employeeRepository.findById(id);
	}
	
	public void createEmployee(Employee e) {
		employeeRepository.save(e);
	}

	public void deleteEmpById(int id) {
		employeeRepository.deleteById(id);
	}
	
	public void updateEmpById(int id, Employee e) {
		Employee emp = employeeRepository.findById(id).get();
		emp.setName(e.getName());
		emp.setDesignation(e.getDesignation());
		emp.setSalary(e.getSalary());
		employeeRepository.save(emp);
	}
	
	//update
}
