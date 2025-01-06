package es.ua.dlsi.prog3.problema1;

import java.util.Date;

/**
 * This class just checks the interface of the classes to ensure it compiles given the UML.
 * The execution is expected to generate IllegalArgument exceptions
 */
public class Main {
	@SuppressWarnings("unused")
	public static final void main(String [] args) {
		// customer
		Customer c = new Customer(1, "Liskov");
		Customer c2 = new Customer(c);
		c.add((Order)null); 
		int customerId = c.getId();
		String customerName = c.getName();
		Order [] customerOrders = c.getOrders();
		
		// EmptyInputException
		Exception e = new EmptyInputException();
				
		// Item
		Item item = new Item("Item name", 25.3);
		Item item2 = new Item(item);
		Item item3 = item2.clone();
		int r = item.compareTo(item2);
				
		// Order
		Order order = null;
		try {
			order = new Order(new Date(), c, new Item[] {item, item2});
		} catch (EmptyInputException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Order order2 = new Order(order);
		
		Meal meal = null;
		try {
			meal = new Meal("Meal 1", 23.3, new Item[] {item2, item3});
		} catch (EmptyInputException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Meal meal2 = new Meal(meal);
		Meal meal3 = meal2.clone();		
	}
}
