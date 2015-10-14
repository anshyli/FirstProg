package dateactivity;

import java .util.Scanner;

public class DateActivityApp {

	public static void main(String[] args) {
		String inquireDate = "";
	
		Scanner sc = new Scanner(System.in);
//		System.out.println("What date do you want to inquire about? acceptable input formats:  \"dd/mm/yyyy\", \"today\", or \"\"");	
		System.out.println("What date do you want to inquire about? Input formats:  \"mm/dd/yyyy\", or use \"\" to stop run");			
		inquireDate = sc.next();	
		if (!inquireDate.equals("")) {
			 DateActivity  myDateActivity = new DateActivity(inquireDate);
			 while (!inquireDate.equals("")) {
				 //print report				 
				 System.out.println("That was a " + myDateActivity.getWhatDay(inquireDate) + ". " + myDateActivity.getWeather() +
				 	" It was " + myDateActivity.datesSince(inquireDate) + " days ago.");
					System.out.println("What date do you want to inquire about? Input formats:  \"mm/dd/yyyy\", or use \"\" to stop run");			
					inquireDate = sc.next();	
			 }
		}
		sc.close();;
	}
}