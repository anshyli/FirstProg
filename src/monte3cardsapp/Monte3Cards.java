package monte3cardsapp;

import java.util.HashMap;
import java.util.Map.Entry;

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
}
