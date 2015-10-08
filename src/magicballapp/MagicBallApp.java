package magicballapp;
import java.util.Random;
import java.util.Scanner;

public class MagicBallApp {

	public static void main(String[] args) {

		String continuePlay = "";
		String response = "";

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to play the Magic8Ball game. Are you ready? (Y/N)");			
		String yorn = sc.next();		
	
		if (yorn.equals("Y")) {

			Magic8Ball theBall = new Magic8Ball();
			do {
				System.out.println("Ask any question you have in mind...");	
				sc.next();
				response = theBall.shakeIt();
				System.out.println( "MAGIC 8-BALL SAYS: " + response );
				System.out.println("Would you like to continue? (Y/N)");
				continuePlay = sc.next();
			}while (continuePlay.equals("Y"));
		}
		else
		System.out.println("Bye!");
	}

}
