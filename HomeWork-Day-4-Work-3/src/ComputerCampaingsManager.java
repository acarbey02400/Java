
public class ComputerCampaingsManager implements ICampaingsService{
	
	public ComputerCampaingsManager() {
		
	}

	@Override
	public void add(Product product) {
		
		System.out.println("Bilgisayar alana Mouse hediye kampanyasýndan yararlandýnýz."+product.getName()+" sepete eklendi.");
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
