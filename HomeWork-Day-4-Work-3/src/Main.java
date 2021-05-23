
public class Main {

	public static void main(String[] args) {
		
		Gamer gamer = new Gamer();
		 gamer.setFirstName("Ýbrahim");
		 gamer.setLastName("Halil");
		 gamer.setId(1);
		 gamer.setDateOfBirth(2000);
		 gamer.setNationalIdentityId(1111111111);
		 gamer.setUserName("acarbey02400");
		 gamer.setBalance(9000);
		
		 //////////////////////////////////////////////////////////////////////
		 
		 GamerManager gamerManager =new GamerManager(new DatabaseLoggerManager(), new UserValidate());
		 gamerManager.add(gamer);
		 
		 //////////////////////////////////////////////////////////////////////
		 Product computer = new Product();
		 computer.setId(0);
		 computer.setName("Computer");
		 computer.setPrice(10000);
		 computer.setDiscount(10);
		 
		 Product mouse = new Product();
		 mouse.setId(1);
		 mouse.setName("Mouse");
		 mouse.setPrice(150);
		 mouse.setDiscount(12);
		 
		 //////////////////////////////////////////////////////////////////////
		 
		 ProductManager productManager = new ProductManager(new FileLoggerManager());
		 productManager.order(gamer, computer);
		 
		 //////////////////////////////////////////////////////////////////////
		 
		 ProductManager productManager1 = new ProductManager(new FileLoggerManager(), new ComputerCampaingsManager(mouse));
		 productManager1.campaingsOrder(gamer, computer);
	}

}
