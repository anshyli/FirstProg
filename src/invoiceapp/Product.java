package invoiceapp;

public class Product {


	public Product() {
	}
	
	public Product(String barCode) {
		this.barCode = barCode;
	}
	
	public Product (String barCode, String category, String description, double unitPrice, Boolean inStock) {
		this.barCode = barCode;
		this.category = category;
		this.description = description;
		this.unitPrice = unitPrice;
		this.inStock = inStock;
	}
	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}

	private String barCode;
	private String category;
	private String description;
	private double unitPrice;
	private Boolean inStock;
}