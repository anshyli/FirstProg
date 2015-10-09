package magicballapp;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Monte3Cards {
	protected final static String[] cover = {"##  ##  ##",
											 "AA  ##  ##",
											 "##  AA  ##",
											 "##  ##  AA"  	};
	protected final static String dcover = "1   2   3";
    protected final static double miniBet = 5.0;
    protected final static double maxWin = 500.0;
    protected final static double miniLose = 0.0;
    protected static final String lostWord = "Ha! Fast Eddie wins again! The ace was card number ";
    protected static final String winWord =  "You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.";
    private double currentCash = 100.0;
    
	public double getCurrentCash() {
		return currentCash;
	}

	public void setCurrentCash(double currentCash) {
		this.currentCash = currentCash;
	}

	HashMap<Integer, Integer> history = new HashMap<Integer, Integer>();
	int historyCount = 0;
	
	public HashMap<Integer, Integer> getHistory() {
		return history;
	}

	public void setHistory(HashMap<Integer, Integer> history) {
		this.history = history;
	}

	public int getHistoryCount() {
		return historyCount;
	}

	public void setHistoryCount(int historyCount) {
		this.historyCount = historyCount;
	}

	public void addHistoryEntry(int acePosition, int guessPosition) {
		history.put(acePosition,  guessPosition);
		historyCount++;
	}
		
	public void displayHistory() {
		int i = 0;
		for (Entry<Integer, Integer> entry : history.entrySet()) {
			i++;
			System.out.println("The " + i + "th Ace Position was:  " + entry.getKey() + 
									   " and your guess was:    " + entry.getValue());
		}
	}
	public void displayCover(int acePosition) {
		// Position 0, 1, 2, 3
		switch (acePosition) {
		case 0: 		System.out.println(cover[0]);
						System.out.println(cover[0]);
						System.out.println(dcover);
						break;
		case 1: 		System.out.println(cover[1]);
						System.out.println(cover[1]);
						System.out.println(dcover);
						break;
		case 2: 		System.out.println(cover[2]);
						System.out.println(cover[2]);
						System.out.println(dcover);
						break;
		case 3: 		System.out.println(cover[3]);
						System.out.println(cover[3]);
						System.out.println(dcover);
						break;
		}
	}
	
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
					System.out.println("Put down your bet. The minimum bet is: " + currency.format(miniBet) + 
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
