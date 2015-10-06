package invoiceapp;

import java.util.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/*
 * Bidirectional Relationships
In a bidirectional relationship, each entity has a relationship field or property that refers to the
other entity. Through the relationship field or property, an entity class’s code can access its
related object. If an entity has a related field, then the entity is said to “know” about its related
object. For example, if Order knows what LineItem instances it has and if LineItem knows
what Order it belongs to, then they have a bidirectional relationship.
Bidirectional relationships must follow these rules:
■ The inverse side of a bidirectional relationship must refer to its owning side by using the
mappedBy element of the @OneToOne, @OneToMany, or @ManyToMany annotation. The
mappedBy element designates the property or field in the entity that is the owner of the
relationship.
■ The many side of many-to-one bidirectional relationships must not define the mappedBy
element. The many side is always the owning side of the relationship.
 */
public class InvoiceApp {
	static int invoiceId = 1;
	final static double taxRate = 0.05;
	
	public InvoiceApp() {
		invoiceId++;
	}
	/*
	 * In this app the invoice Id is in each LineItem, but not the other way. So you can navigate from LineItem to invoice only.
	 */
	public static void main(String[] args) {
		double taxableTotal = 0.0, untaxableTotal = 0.0, totalTax = 0.0, grandTotal = 0.0, lineItemTotal = 0.0, lineTax = 0.0;
		int itemCount = 0;
		Scanner kb = new Scanner(System.in);	
		// creating an invoice
		InvoiceApp theInvoice = new InvoiceApp();
		DateFormat df = new SimpleDateFormat("EEE, MMM d, ' 'yy");
		Date invoiceDate = new Date();
		System.out.println("Invoice " + theInvoice.invoiceId + "  on " + df.format(invoiceDate));
		System.out.println();
		System.out.println("Product \t Quantity \t Line Total \t Line Tax");
        NumberFormat currency = NumberFormat.getCurrencyInstance();  
		//creating lineitems
		System.out.println("Enter product barcode");
		String pBarCode = kb.next(); 
        while (!pBarCode.equals("done")){
        	Product theProduct = ProductDB.getProductInstance(pBarCode);
            LineItem thisLineItem = new LineItem(theProduct, theInvoice.invoiceId);
            //LineItem created
    		System.out.println("Enter product unit price");
    		double pUnitPrice = kb.nextDouble();      
    		theProduct.setUnitPrice(pUnitPrice);
    		System.out.println("Enter the quantity purchased");
         	itemCount = kb.nextInt();
		    thisLineItem.setQuantity(itemCount); 
		    // calculate the line item total
		    lineItemTotal = thisLineItem.getQuantity() * theProduct.getUnitPrice();
		    thisLineItem.setLineItemTotal(lineItemTotal);
		    grandTotal = grandTotal + lineItemTotal;
			System.out.println("Is it taxable?");
			Boolean taxFlag = kb.nextBoolean();
			thisLineItem.setTaxable(taxFlag);
			if (taxFlag) {
				lineTax = lineItemTotal * taxRate;
				taxableTotal = taxableTotal + lineItemTotal;
				totalTax = totalTax + lineTax;
			}
			else {
				lineTax = 0.0;
				untaxableTotal = untaxableTotal + lineItemTotal;
			}
			grandTotal = grandTotal + lineTax;
			System.out.println(theProduct.getBarCode() + "\t" + itemCount + "\t" + lineItemTotal + "\t" + lineTax);
			//more LineItems?
			System.out.println("Enter product barcode");
		    pBarCode = kb.next(); 
        }	
        // All LineItem collected, complete the invoice now
       	System.out.println(" Taxable subtotal: " + taxableTotal);
       	System.out.println(" Untaxable subtotal: " + untaxableTotal);
       	System.out.println(" Tax: " + totalTax);
       	System.out.println(" Grand Total: " + grandTotal);
	}

}
