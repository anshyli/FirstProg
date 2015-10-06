package bookapp;


public class Book {
	private String bookTitle;
	private String author;
	private String description;
	private double price;
	private Boolean inStock;

	public Book() {
	}
	
	public Book(String title) {
		this.bookTitle = title;
	}
	
	public Book (String title, String author, String description, double price, Boolean inStock) {
		this.bookTitle = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.inStock = inStock;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}

	public double getTotalPrice(int bookCount, boolean inStock) {
		double thePrice = 0.0;
		
		if (inStock) {
			thePrice = bookCount * getPrice();
		}
		else {
			System.out.println("The books are not currently in stock. Please order later.");
		}
		return thePrice;
	}
}
