package uskbank;

public class Truck extends Vehicle{
	private int loadCap;
	
	public Truck(String vehicleNo, String model, String manufacturer, String color,
			int loadCap){
		super(vehicleNo, model, manufacturer, color);
		this.loadCap = loadCap;
	}
	
	public void changeCap(int newCap) {
		loadCap = newCap;
	}
	
	public int getCap() {
		return loadCap;
	}
	
	
	//Test truck
	public static void main(String[] args) {
		Truck truck = new Truck("", "", "", "", 100);
		truck.changeColor("black");
		
		System.out.println("Truck color: " + truck.getColor());
		System.out.println("Truck cap: " + truck.getCap());
	}
}

