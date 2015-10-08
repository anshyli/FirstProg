package inheritanceapp;

public class InherritanceApp {

	public static void main(String[] args) {
		Book myBook = new Book();
		Software mySoftware = new Software();
//		Product myProduct = new Product();
		
		System.out.println(myBook.whoAmI());
		System.out.println(mySoftware.whoAmI());
//		System.out.println(myProduct.whoAmI());

		System.out.println(myBook.count);
		System.out.println(mySoftware.count);	
//		System.out.println(myProduct.count);

		System.out.println(myBook.count);
//		System.out.println(mySoftware.count);	
		}

}
