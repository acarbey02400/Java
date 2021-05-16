package oopIntro;

public class Main {

	public static void main(String[] args) 
	{
		Product product1 = new Product();
		product1.set_id(0);
		product1.set_name("Lenovo ideapad 3");
		product1.set_detail("Yeni nesil iþlemci");
		product1.set_unitPrice(5000);
		product1.set_discount(15);
		
		
		Product product2 = new Product();
		product2.set_id(1);
		product2.set_name("Lenovo ideapad 4");
		product2.set_detail("Ultra güçlü ekran kartý");
		product2.set_unitPrice(6500);
		product2.set_discount(12);
		
		Product product3 = new Product(2,"Lenovo ideapad 5","Yeni nesil iþlemci ve ultra güçlü ekran kartý",8000,10);
		
		
		Product[] products = {product1,product2,product3};
		
		for(var product:products)
		{
		System.out.println(product.get_id()+"\n"+product.get_name()+"\n"+
		product.get_detail()+"\n"+product.get_unitPrice()+"\n"+"Ýndirimli ücret: "+product.get_unitPriceAfterDiscount()+"\n"+"-------------------");
		
		}
		
		
		Category category1 = new Category();
		category1.set_id(0);
		category1.set_name("Bilgisayar");
		
		Category category2 = new Category();
		category2.set_id(2);
		category2.set_name("Bilgisayar bileþenleri");
		
		Category[] categorys= {category1,category2};
		
		for(var category:categorys)
		{
			System.out.println(category.get_id()+"\t"+category.get_name()+"\n");
			
		}
				
		ProductManager productManager = new ProductManager();
		productManager.addToCart(product2);
	}

}
