package uskbank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Employee {
	private String id;
	private String name;
	private int age;
	private char gender;
	private String dept;
	private int yearOfJoining;
	private int salary;
	
	public Employee(String id, String name, int age, char gender, String dept, int yearOfJoining, int salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dept = dept;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public String getDept() {
		return dept;
	}
	
	public int getYear() {
		return yearOfJoining;
	}
	
	public int getSalary() {
		return salary;
	}
	
	
	//Test data
	public static void main(String[] args) {
		//Add test data to an ArrayList
		ArrayList<Employee> testList = new ArrayList<Employee>();
		testList.add(new Employee("001", "Jeff", 29, 'M', "Maintenance", 2010, 40000));
		testList.add(new Employee("072", "Sandra", 22, 'F', "Programming", 2015, 60000));
		testList.add(new Employee("620", "Bob", 41, 'M', "Sales", 2018, 45000));
		testList.add(new Employee("563", "Jane", 35, 'F', "Programming", 2019, 75000));
		testList.add(new Employee("219", "Martha", 40, 'F', "Maintenance", 2009, 50000));
		testList.add(new Employee("462", "Mark", 25, 'M', "Management", 2019, 65000));
		testList.add(new Employee("918", "Sue", 28, 'F', "Sales", 2016, 42000));
		testList.add(new Employee("045", "Theo", 37, 'M', "Management", 2011, 72000));
		testList.add(new Employee("312", "Ruth", 49, 'F', "Maintenance", 2018, 65000));
		
		//Create variables to track data for each problem
		int mCounter = 0;
		int fCounter = 0;
		int mAveAge = 0;
		int fAveAge = 0;
		String highestSalaryName = "DEFAULT";
		int highestSalary = -1;
		ArrayList<Employee> joinedAfter2015 = new ArrayList<Employee>();
		int highestAge = 0;
		String highestAgeName = "DEFAULT";
		HashMap<String, ArrayList<Employee>> deptList = new HashMap<String, ArrayList<Employee>>();
		int mMaintCounter = 0;
		int fMaintCounter = 0;
		int mAveSalary = 0;
		int fAveSalary = 0;
		ArrayList<Employee> youngerThan31 = new ArrayList<Employee>();
		ArrayList<Employee> olderThan25 = new ArrayList<Employee>();
		
		//Iterate through list and find correct data for each problem
		for(Employee iCount: testList) {
			if(iCount.getGender() == 'F') {
				fCounter++;
				fAveAge += iCount.getAge();
				if(iCount.getDept().equals("Maintenance")) {
					fMaintCounter++;
				}
				fAveSalary += iCount.getSalary();
			}
			else {
				mCounter++;
				mAveAge += iCount.getAge();
				if(iCount.getDept().equals("Maintenance")) {
					mMaintCounter++;
				}
				mAveSalary += iCount.getSalary();
			}
			
			if(iCount.getSalary() > highestSalary) {
				highestSalary = iCount.getSalary();
				highestSalaryName = iCount.getName();
			}
			
			if(iCount.getYear() > 2015) {
				joinedAfter2015.add(iCount);
			}
			
			if(iCount.getAge() > highestAge) {
				highestAge = iCount.getAge();
				highestAgeName = iCount.getName();
			}
			
			deptList.putIfAbsent(iCount.getDept(), new ArrayList<Employee>());
			
			deptList.get(iCount.getDept()).add(iCount);
			
			
			if(iCount.getAge() <= 30) {
				youngerThan31.add(iCount);
			}
			
			if(iCount.getAge() > 25) {
				olderThan25.add(iCount);
			}
		}
		
		//Calculate the averages of each gender
		mAveAge /= mCounter;
		mAveSalary /= mCounter;
		
		fAveAge /= fCounter;
		fAveSalary /= fCounter;
		
		
		System.out.println("Problem 1");
		System.out.println("Male employees: " + mCounter + ",   Female employees: " + fCounter);
		
		System.out.println();
		System.out.println("Problem 2");
		System.out.println("Male average age: " + mAveAge + ",   Female average age: " + fAveAge);
		
		System.out.println();
		System.out.println("Problem 3");
		System.out.println("Highest paid employee: " + highestSalaryName + ", $" + highestSalary);
		
		System.out.println();
		System.out.println("Problem 4");
		System.out.print("Joined after 2015: ");
		for(Employee employeeP4: joinedAfter2015) {
			System.out.print(employeeP4.getName() + ", ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Problem 5");
		System.out.println("Senior-most employee: " + highestAgeName + ", " + highestAge);
	
		System.out.println();
		System.out.println("Problem 6");
		System.out.println("Number of employees per department");
		System.out.println();
		deptList.forEach((key, value) -> System.out.println(key + ": " +  value.size()));
	
		System.out.println();
		System.out.println("Problem 7");
		System.out.println("Count of males and females in maintenance");
		System.out.println("Males: " + mMaintCounter);
		System.out.println("Females: " + fMaintCounter);
		
		System.out.println();
		System.out.println("Problem 8");
		System.out.println("Average salary for males and females");
		System.out.println("Males: " + mAveSalary);
		System.out.println("Females: " + fAveSalary);
		
		System.out.println();
		System.out.println("Problem 9");
		System.out.print("Employees younger than or equal to 30: ");
		for(Employee employeeP9one: youngerThan31) {
			System.out.print(employeeP9one.getName() + ", ");
		}
		
		System.out.println();
		System.out.print("Employees older than 25: ");
		for(Employee employeeP9two: olderThan25) {
			System.out.print(employeeP9two.getName() + ", ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Problem 10");
		System.out.println("Employees in each department");
		System.out.println();
		for(String dept: deptList.keySet()) {
			System.out.print(dept +": ");
			for(Employee employeeP10: deptList.get(dept)) {
				System.out.print(employeeP10.getName() + ", ");
			}
			System.out.println();
		}
	}
}
