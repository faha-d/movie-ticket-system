package logic;

public class Customer extends Person {

	private int customerId;
	private static int counter = 1;

	public Customer(String name) {
		super(name);
		this.customerId = counter++;
	}

	@Override
	public void displayDetails() {
		System.out.println("Customer Name: " + name);
		System.out.println("Customer ID: " + customerId);
	}

	public int getCustomerId() {
		return customerId;
	}
}
