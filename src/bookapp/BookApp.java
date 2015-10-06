package bookapp;

import java.text.NumberFormat;
import java.util.Scanner;

public class BookApp {
	
		public static void main(String[] args) {
			Scanner kb = new Scanner(System.in);
			
			// Accepting book attributes from user
			System.out.println("Enter Book Title");
			String aTitle = kb.nextLine(); 
			System.out.println("Enter the Author");
			String theAuthor = kb.nextLine(); 
			System.out.println("Enter Book Description");
			String theDescription = kb.nextLine(); 		
			System.out.println("Enter Book Price");
			double thePrice = kb.nextDouble(); 
			System.out.println("Enter in stock flag");
			Boolean inFlag = kb.nextBoolean();
			
			Book aBook = BookDB.getBookInstance(aTitle, theAuthor, theDescription, thePrice, inFlag);
			System.out.println("The Book Title is: " + aBook.getBookTitle());
			System.out.println("The Book Author is: " + aBook.getAuthor());
			System.out.println("The Book Description is: " + aBook.getDescription());
            NumberFormat currency = NumberFormat.getCurrencyInstance();
			System.out.println("The Book Price is: " + currency.format(aBook.getPrice()));
			System.out.println("Is the Book in stock: " + aBook.getInStock());	
			
			System.out.println("Enter Number of Books to Purchase");
			int theCount = kb.nextInt(); 
			System.out.println("The Book Price is: " + currency.format(aBook.getTotalPrice(theCount, aBook.getInStock())));
			kb.close();
		}
	}
