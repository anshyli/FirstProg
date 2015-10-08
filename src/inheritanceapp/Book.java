package inheritanceapp;


public final class Book extends Product {
	private String bookTitle;
	private String author;
//	private String description;     //already in Product
//	private double price;            //already in Product as unitPrice
	private int pages;

	private Boolean inStock;

	public Book() {
//		count++;
	}
	
	public Book(String title) {
		super();
		this.bookTitle = title;
	}
	
	public Book (String title, String author, String description, double price, Boolean inStock) {
		super();
		this.bookTitle = title;
		this.author = author;
		setDescription(description);
		setUnitPrice(price);
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

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}
	
	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public double getTotalPrice(int bookCount, boolean inStock) {
		double thePrice = 0.0;
		
		if (inStock) {
			thePrice = bookCount * getUnitPrice();
		}
		else {
			System.out.println("The books are not currently in stock. Please order later.");
		}
		return thePrice;
	}
	
	public String whoAmI() {
		return "I am a book. \n";
	}
	
	@Override 
	public boolean equals(Object o) {
			Book anObj = (Book) o;
			if (this.author.equals(anObj.author) &&
				bookTitle.equals(anObj.bookTitle) &&
				super.equals(anObj)) {
				return true;
			}
			else {
				return false;
			}
	}
	@Override
	public String toString() {
		return super.toString() + "Book Title:	 " + bookTitle + "\n" +
											 "Author: 	" + author + "\n"; 
	}
}
