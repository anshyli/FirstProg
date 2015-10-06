package invoiceapp;

public class ProductDB {
	public static Product getProductInstance(String barCode) {
		return new Product(barCode);
	}
	public static Product getProductInstance(String barCode, String category, String description, double unitPrice, Boolean inStock) {
		return new Product(barCode, category, description, unitPrice, inStock);
	}
}
