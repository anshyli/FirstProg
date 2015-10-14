package magicballapp;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.NullPointerException;
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
		theBall.setHistoryFileName("magicHistory");
		if (yorn.equals("Y")) {
			do {
				System.out.println("Ask any question you have in mind...");	
				question = sc.next();
				if (!theBall.checkQuestionExist(question)){
					response = theBall.shakeIt();
					System.out.println( "MAGIC 8-BALL SAYS: " + response );
					theBall.addHistoryEntry(question, response);
					System.out.println("Would you like to continue? (Y/N)");
				}else {
					System.out.println("Question already asked before. Ask another? (Y/N)");
				}
//				System.out.println("Would you like to continue? (Y/N)");
				continuePlay = sc.next();
			}while (continuePlay.equals("Y"));
			//Append history to the grandHistory file
			try {
				theBall.addGrandHistory(theBall.getHistory());
			} catch (FileNotFoundException e) {
				e.getMessage();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.getMessage();
			}
			System.out.println("Would you like to see QnA history? (Y/N)");
			seeHistory = sc.next();
			if (seeHistory.equals("Y")) theBall.displayHistory();
			System.out.println("The grand total history: ");
			try {
				theBall.showGrandHistory();
			} catch (FileNotFoundException e) {
				System.out.println("Check if the grand history file exits.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("Bye!");
		}
		sc.close();
	}

}
