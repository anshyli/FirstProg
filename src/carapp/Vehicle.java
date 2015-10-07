package carapp;

public abstract class Vehicle {
	String type = "car";
	
	public Vehicle() {
		System.out.println("The default abstract class Vehicle constructor.");
	}
	
	public Vehicle(String vType) {
		super();
		this.type = vType;
		System.out.println("The type abstract class Vehicle constructor.");
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
