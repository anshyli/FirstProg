package monte3cardsapp;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class Monte3CardsApp {
	public static void main(String[] args) {
		int acePosition = 0;
		int guessPosition = 0;
		double yourBet = 0.0;
		
		Monte3Cards myGame = new Monte3Cards();
		Scanner sc = new Scanner(System.in);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		// create random object
		Random r = new Random();
		while (myGame.getCurrentCash() < Monte3Cards.maxWin && myGame.getCurrentCash() > Monte3Cards.miniLose) {
				// Roll it
				do {
					System.out.println("Put down your bet. The minimum bet is: " + currency.format(Monte3Cards.miniBet) + 
											"\nYou can not bet more than your have either. Your current cash amount is: " + 
											 myGame.getCurrentCash());
					yourBet = sc.nextDouble();
				} while (yourBet < Monte3Cards.miniBet || yourBet > myGame.getCurrentCash());
				// action
				acePosition = 1 + r.nextInt(3);
				System.out.println("Which one is the ace?");
				myGame.displayCover(0);
				System.out.println("> ");
				guessPosition = sc.nextInt();
				myGame.addHistoryEntry(acePosition, guessPosition);
				if (acePosition==guessPosition) {
					//You win
				    System.out.println(Monte3Cards.winWord);
					myGame.displayCover(acePosition);
					myGame.setCurrentCash( myGame.getCurrentCash() + yourBet); 
				}
				else {
					//you lost
				    System.out.println(Monte3Cards.lostWord + acePosition + ".\n");
					myGame.displayCover(acePosition);
					myGame.setCurrentCash( myGame.getCurrentCash() - yourBet); 
				}
		}
		System.out.println("Game over and here i your play history: \n");
		myGame.displayHistory();
		sc.close();
	}
}
