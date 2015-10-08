package magicballapp;
import java.util.Random;
import java.util.Scanner;

public class MagicBallApp {

	public static void main(String[] args) {

		String continuePlay = "";
		String response = "";
		String question = "";
		String seeHistory;

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to play the Magic8Ball game. Are you ready? (Y/N)");			
		String yorn = sc.next();		
		Magic8BallRemembers theBall = new Magic8BallRemembers();	
		if (yorn.equals("Y")) {
//			Magic8Ball theBall = new Magic8Ball();
			do {
				System.out.println("Ask any question you have in mind...");	
				question = sc.next();
				response = theBall.shakeIt();
				System.out.println( "MAGIC 8-BALL SAYS: " + response );
				theBall.addHistoryEntry(question, response);
				System.out.println("Would you like to continue? (Y/N)");
				continuePlay = sc.next();
			}while (continuePlay.equals("Y"));
			System.out.println("Would you like to see QnA history? (Y/N)");
			seeHistory = sc.next();
			if (seeHistory.equals("Y")) theBall.displayHistory();
			System.out.println("Bye!");
		}
	}

}
