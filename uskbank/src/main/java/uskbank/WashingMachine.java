package uskbank;

public class WashingMachine {
	private boolean isOn = false;
	
	public WashingMachine() {
	}
	
	public void switchOn() {
		isOn = true;
	}
	
	public void switchOff() {
		isOn = false;
	}
	
	public void acceptDetergent() {
		System.out.println("Detergent accepted");
	}
	
	public int acceptClothes(int numOfClothes) {
		return numOfClothes;
	}
	
}
