package uskbank;

import java.util.ArrayList;

public class BookstoreCart {
	private ArrayList<BookstoreItem> cart = new ArrayList();
	
	public BookstoreCart() {
		
	}
	
	public void addItem(BookstoreItem newItem) {
		cart.add(newItem);
	}
	
	public void removeItem(BookstoreItem newItem) {
		cart.remove(newItem);
	}
	
	public double getTotal() {
		double total = 0;
		for(BookstoreItem item: cart) {
			total += item.cost;
		}
		
		return total;
	}
}
