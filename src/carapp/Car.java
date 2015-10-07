package carapp;

import java.text.NumberFormat;

public class Car extends Vehicle {
	String model;
	String color;
	double speed;
	double unitPrice = 10000.00;
	String status;
	
	public Car() {
		
	}
	public Car(String model, String color, String type) {
		super(type);
		this.model = model;
		this.color = color;		
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public void programmedTest() {
		System.out.println("This is a " + color + " " + model);
		this.setStatus("starting");
		System.out.println("The car is " + this.getStatus() + ".");
		this.setStatus("accelerating.");
		System.out.println("The car is " + this.getStatus());
		this.setSpeed(50);	
		System.out.format("The car is going %3.0f mpg.\n", speed);
		this.setStatus("slowing down.");
		System.out.println("The car is " + this.getStatus());
		this.setStatus("stopped.");
		System.out.println("The car has " + this.getStatus());		
	}

	@Override
	public String toString() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return  " Type: 		" + type + "\n" +
					"Model:			" + model + "\n" +
					"Color:		" + color + "\n" +
					"Unit Price: 		" + currency.format(unitPrice) + "\n";
	}

}
