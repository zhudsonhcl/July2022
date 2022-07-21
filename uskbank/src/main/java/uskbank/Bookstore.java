package uskbank;

public class Bookstore {
	
	BookstoreCart cart = new BookstoreCart();
	
	public void confirmOrder() {
		//Confirm order, addresses
	}
	
	public void sendOrder() {
		//Send order and items to address after payment
	}
	
	public void receipt() {
		System.out.println("Your total is " + cart.getTotal());
	}
}
