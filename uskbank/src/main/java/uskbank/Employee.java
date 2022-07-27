package uskbank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		
		//Problem 1, males and females in organization
		int mCounter = testList.stream().filter(employee -> employee.getGender() == 'M')
				.collect(Collectors.toList()).size();
		int fCounter = testList.size() - mCounter;
		
		System.out.println("Problem 1");
		System.out.println("Males in organization: " + mCounter);
		System.out.println("Females in organization: " + fCounter + "\n");
		
		
		//Problem 2, average age of male and female employees
		int mAveAge = testList.stream().filter(employee -> employee.getGender() == 'M')
				.collect(Collectors.averagingDouble(Employee::getAge)).intValue();
		
		int fAveAge = testList.stream().filter(employee -> employee.getGender() == 'F')
				.collect(Collectors.averagingInt(Employee::getAge)).intValue();
		
		System.out.println("Problem 2");
		System.out.println("Average male age: " + mAveAge);
		System.out.println("Average female age: " + fAveAge + "\n");
		
		
		//Problem 3, highest paid employee
		Employee highest = testList.stream().max(Comparator.comparing(employee -> employee.getSalary())).get();
		
		System.out.println("Problem 3");
		System.out.println("Highest paid employee: " + highest.getName() +", " + highest.getSalary() + "\n");
		
		
		//Problem 4, employees who joined after 2015
		List<Employee> after2015 = testList.stream().filter(employee -> employee.getYear() > 2015)
				.collect(Collectors.toList());
		
		System.out.println("Problem 4");
		System.out.print("Employees who joined after 2015: ");
		after2015.forEach((employee) -> {
			System.out.print(employee.getName() + ", ");
		});
		
		
		//Problem 5, senior most employee
		Employee senior = testList.stream().max(Comparator.comparing(employee -> employee.getAge())).get();
		
		System.out.println("\n");
		System.out.println("Problem 5");
		System.out.println("Seniormost employee: " + senior.getName() + ", " + senior.getAge() + "\n ");
		
		
		//Problem 6, # of employees in each department
		Map<String, List<Employee>> deptList = testList.stream()
				.collect(Collectors.groupingBy(Employee::getDept));
		
		System.out.println("Problem 6");
		System.out.println("Number of employees per department");
		deptList.forEach((key, value) -> System.out.println(key + ": " +  value.size()));
		
		
		//Problem 7, male and female employees in maintenance department
		Long mMaintCounter = testList.stream().
				filter(employee -> (employee.getGender() == 'M') && (employee.getDept().equals("Maintenance")))
				.collect(Collectors.counting());
		Long fMaintCounter = testList.stream().
				filter(employee -> (employee.getGender() == 'F') && (employee.getDept().equals("Maintenance")))
				.collect(Collectors.counting());
		
		System.out.println();
		System.out.println("Problem 7");
		System.out.println("Male employees in maint: " + mMaintCounter);
		System.out.println("Female employees in maint: " + fMaintCounter + "\n");
		
		
		//Problem 8, average salary of male and female employees
		int mAveSalary = testList.stream().filter(employee -> employee.getGender() == 'M')
				.collect(Collectors.averagingInt(employee -> employee.getSalary())).intValue();
		int fAveSalary = testList.stream().filter(employee -> employee.getGender() == 'F')
				.collect(Collectors.averagingInt(employee -> employee.getSalary())).intValue();
		
		System.out.println("Problem 8");
		System.out.println("Average male salary: " + mAveSalary);
		System.out.println("Average female salary: " + fAveSalary + "\n");
		
		
		//Problem 9, employees younger or equal to 30, employees older than 25
		List<Employee> youngerThan31 = testList.stream().filter(employee -> employee.getAge() > 31)
				.collect(Collectors.toList());
		List<Employee> olderThan25 = testList.stream().filter(employee -> employee.getAge() < 25)
				.collect(Collectors.toList());
		
		System.out.println("Problem 9");
		System.out.print("Employees younger than or equal to 30: ");
		youngerThan31.forEach((employee) -> {
			System.out.print(employee.getName() + ", ");
		});
		
		System.out.println();
		System.out.print("Employees older than 25: ");
		olderThan25.forEach((employee) -> {
			System.out.print(employee.getName() + ", ");
		});
		
		
		//Problem 10, employees in each department
		//Using the already created deptList from problem 6
		System.out.println("\n");
		System.out.println("Problem 10");
		System.out.println("Employees in each department");
		for(String dept: deptList.keySet()) {
			System.out.print(dept +": ");
			for(Employee employeeP10: deptList.get(dept)) {
				System.out.print(employeeP10.getName() + ", ");
			}
			System.out.println();
		}
	}
}
