package uskbank;

public class Bank {
	private double balance;
	
	public Bank(double bal) {
		balance = bal;
	}
	
	public double deposit(double amount) {
		balance += amount;
		return balance;
	}
	
	public double withdraw(double amount) {
		if(balance < amount) {
			return 0;
		}
		
		balance -= amount;
		return balance;
	}
}
