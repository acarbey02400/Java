package staticDemo;

public class ProductManager {
	
	
	public void add(Product product) {
		if(ProductValidator.isValid(product)) {
			System.out.println("Ekleme i�lemi ger�ekle�tirildi.");
		}
		else {
			System.out.println("L�tfen do�ru bilgiler giriniz.");
		}
	}
}
