package carapp;

public class CarApp {

	public static void main(String[] args) {
		String model = "Porsche";
		String color = "red";
		String vType = "truck";
		
		Car myCar = new Car(model, color, vType);
//		myCar.programmedTest();
				
		System.out.println("This vehicle is a " + myCar.type);
		System.out.println("\n"+myCar.toString());
	}

}
