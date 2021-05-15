package oopIntro;

public class Main {

	public static void main(String[] args) 
	{
		Product product1 = new Product();
		product1.id=0;
		product1.name="Lenovo ideapad 3";
		product1.detail="Yeni nesil iþlemci";
		product1.unitPrice=5000;
		
		
		Product product2 = new Product();
		product2.id=1;
		product2.name="Lenovo ideapad 4";
		product2.detail="Ultra güçlü ekran kartý";
		product2.unitPrice=6500;
		
		
		Product product3 = new Product();
		product3.id=2;
		product3.name="Lenovo ideapad 5";
		product3.detail="Yeni nesil iþlemci ve ultra güçlü ekran kartý";
		product3.unitPrice=8000;
		
		Product[] products = {product1,product2,product3};
		
		for(var product:products)
		{
		System.out.println(product.id+"\n"+product.name+"\n"+
		product.detail+"\n"+product.unitPrice+"\n"+"-------------------");
		
		}
		
		
		Category category1 = new Category();
		category1.id=0;
		category1.name="Bilgisayar";
		
		Category category2 = new Category();
		category2.id=2;
		category2.name="Bilgisayar bileþenleri";
		
		Category[] categorys= {category1,category2};
		
		for(var category:categorys)
		{
			System.out.println(category.id+"\t"+category.name+"\n");
			
		}
				
		ProductManager productManager = new ProductManager();
		productManager.addToCart(product3);
	}

}
