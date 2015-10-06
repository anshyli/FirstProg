package bookapp;

public class BookDB {
	public static Book getBookInstance(String bookTitle) {
		return new Book(bookTitle);
	}
	public static Book getBookInstance(String bookTitle, String author, String description, double price, Boolean inFlag) {
		return new Book(bookTitle, author, description, price, inFlag);
	}
}
