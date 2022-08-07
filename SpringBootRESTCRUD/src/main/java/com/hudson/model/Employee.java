package com.hudson.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="emp_july_rest_assignment")
public class Employee {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // Represents as primary key
    private Integer id;
    private String name;
    private String designation;
    private double salary;
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setDesignation(String designation) {
    	this.designation = designation;
    }
    
    public void setSalary(double salary) {
    	this.salary = salary;
    }

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return designation;
	}

	public double getSalary() {
		return salary;
	}
    
    
}
