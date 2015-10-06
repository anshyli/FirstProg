package invoiceapp;

public class LineItem
{
	private Product theProduct;
    private int quantity;
    private double lineItemTotal;
    private int 	invoiceId; 
    private Boolean taxable = true;
    
    public LineItem(Product aProduct, int theQuantity, double lineTotal, int invoiceId, Boolean taxFlag) {
        this.theProduct = ProductDB.getProductInstance(aProduct.getBarCode());
        this.quantity = 0;
        this.lineItemTotal = 0.0;
        this.invoiceId = 0; 
        this.setTaxable(taxFlag);
    }
    public LineItem(Product aProduct, int invoiceId)
    {
        this.theProduct = ProductDB.getProductInstance(aProduct.getBarCode());
        this.invoiceId = invoiceId;
    }
    public Product getTheProduct() {
		return theProduct;
	}
	public void setTheProduct(Product theProduct) {
		this.theProduct = theProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getLineItemTotal() {
		return lineItemTotal;
	}
	public void setLineItemTotal(double lineItemTotal) {
		this.lineItemTotal = lineItemTotal;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Boolean getTaxable() {
		return taxable;
	}
	public void setTaxable(Boolean taxable) {
		this.taxable = taxable;
	}

}
