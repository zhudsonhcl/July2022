package uskbank;

public class BookstoreCustomer {
	String customerId;
	//woah plaintext password
	String password;
	
	String billingAddress;
	String shippingAddress;
	
	public BookstoreCustomer(String id, String pass, String billAdd, String shipAdd) {
		customerId = id;
		password = pass;
		
		billingAddress = billAdd;
		shippingAddress = shipAdd;
	}
	
	public String getId() {
		return customerId;
	}
	
	public void setPassword(String newPass) {
		password = newPass;
	}
	
	
}
