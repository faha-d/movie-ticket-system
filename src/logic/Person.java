package logic;

public abstract class Person {
	protected String name;

	public Person(String name) {
		this.name = name;
	}

	public abstract void displayDetails();

	public String getName() {
		return name;
	}
}