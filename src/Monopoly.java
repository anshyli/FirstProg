import java.util.Random;

public class Monopoly {

	public static void main(String[] args) {
		
		int nDouble = 0;
		boolean rollDouble = false;
		
		// create random object
		Random r = new Random();

		do {
			// Roll the dices
			int dice1 = 1 + r.nextInt(6);
			int dice2 = 1 + r.nextInt(6);
			
			System.out.println("Your roll:  ");
			System.out.println("Dice 1: " + dice1);			
			System.out.println("Dice 2: " + dice2);
			
			if (dice1 == dice2) { 
				rollDouble = true;
				nDouble++;	
			} else {
				rollDouble = false;
			}
		} while (nDouble <3 && rollDouble );
		
		if (nDouble == 3)
		System.out.println("You had too much fun, so go to jail!");
	}

}
