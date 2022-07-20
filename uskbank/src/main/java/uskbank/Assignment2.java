package uskbank;

import java.util.Scanner;

public class Assignment2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Which program to run? (1-5)");
		System.out.println("1: Fibonacci");
		System.out.println("2: Check prime");
		System.out.println("3: Swap variable");
		System.out.println("4: Equals sum");
		System.out.println("5: Reverse word");
		
		int program = scanner.nextInt();
		
		switch(program) {
		case 1:{
			fibonacci();
			break;
		}
		case 2:{
			checkPrime();
			break;
		}
		case 3:{
			swap();
			break;
		}
		case 4:{
			sum();
			break;
		}
		case 5:{
			reverseWord();
			break;
		}
		default:{
			System.out.println("Invalid input");
		}
		}
	}
	
	public static void fibonacci() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input a number: ");
		
		int num = scanner.nextInt();
		
		int first = 0;
		int second = 1;
		
		System.out.println();
		
		if(num == 1) {
			System.out.print(first);
		}
		else if(num == 2) {
			System.out.print(first + ", " + second);
		}
		
		else {
			System.out.print(first + ", " + second);
			
			for(int i = 2; i < num; i++) {
				int temp = first + second;
				System.out.print(", " + temp);
				first = second;
				second = temp;
			}
		}
		
	}
	
	public static void checkPrime() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input a number: ");
		
		int counter = scanner.nextInt();
		
		if(counter < 2 ) {
			System.out.println("Not prime");
		}
		else {
			boolean prime = true;
			
			for(int i = 2; i < counter; i++) {
				if(counter%i == 0) {
					prime = false;
				}
			}
			
			if(prime) {
				System.out.println(counter + " is prime");
			}
			else {
				System.out.println(counter + " is NOT prime");
			}
		}
		
	}
	
	public static void swap() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the first variable: ");
		
		String first = scanner.nextLine();
		
		System.out.println("Input the second variable: ");
		
		String second = scanner.nextLine();
		
		System.out.println("Started with a: " + first +",   b: " + second);
		String temp = first;
		first = second;
		second = temp;
		
		System.out.println("After swapping, a: " + first +",   b: " + second);
	}
	
	public static void sum() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the first number: ");
		
		int firstNum = scanner.nextInt();
		
		System.out.println("Input the second number: ");
		
		int secondNum = scanner.nextInt();
		
		System.out.println("Input the sum to check: ");
		
		int sum = scanner.nextInt();
		
		if(firstNum + secondNum == sum) {
			System.out.println(firstNum + " + " + secondNum + " is equal to " + sum);
		}
		else {
			System.out.println(firstNum + " + " + secondNum + " is NOT equal to " + sum);
		}
	}
	
	public static void reverseWord() {
		System.out.println("Input a word: ");
		Scanner scanner = new Scanner(System.in);
		
		String word = scanner.next();
		StringBuilder wordReverse = new StringBuilder();
		
		wordReverse.append(word);
		wordReverse.reverse();
		
		System.out.println(wordReverse);
	}
}
