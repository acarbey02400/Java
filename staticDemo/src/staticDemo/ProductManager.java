package staticDemo;

public class ProductManager {
	
	
	public void add(Product product) {
		if(ProductValidator.isValid(product)) {
			System.out.println("Ekleme iþlemi gerçekleþtirildi.");
		}
		else {
			System.out.println("Lütfen doðru bilgiler giriniz.");
		}
	}
}
