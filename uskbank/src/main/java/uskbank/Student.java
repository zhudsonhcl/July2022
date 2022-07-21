package uskbank;

import java.util.Scanner;

public class Student {
	public Student() {
		
	}
	
	public boolean average(int firstScore, int secondScore, int thirdScore) {
		if((firstScore+secondScore+thirdScore)/3 >= 50) {
			return true;
		}
		return false;
	}
	
	public String input() {
		Scanner scanner = new Scanner(System.in);
		
		String name = scanner.nextLine();
		
		return name;
	}
}
