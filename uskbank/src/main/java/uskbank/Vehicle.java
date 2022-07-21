package uskbank;

public class Vehicle {
	String vehicleNo;
	String model;
	String manufacturer;
	String color;
	
	public Vehicle(String vehicleNo, String model, String manufacturer, String color) {
		this.vehicleNo = vehicleNo;
		this.model = model;
		this.manufacturer = manufacturer;
		this.color = color;
	}
	
	public void changeColor(String newColor) {
		color = newColor;
	}
	
	public String getColor() {
		return color;
	}
}
