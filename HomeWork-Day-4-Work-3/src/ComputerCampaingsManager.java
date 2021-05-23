
public class ComputerCampaingsManager implements ICampaingsService{

	Product _product;
	public ComputerCampaingsManager(Product product) {
		_product=product;
	}
	@Override
	public void add() {
		
		System.out.println("Bilgisayar alana Mouse hediye kampanyasýndan yararlandýnýz."+_product.getName()+" sepete eklendi.");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
}
