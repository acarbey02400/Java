
public class ProductManager {
	ILogerService _iLogerService;
	ICampaingsService _iCampaingsService;
	public ProductManager(ILogerService iLogerService) {
		_iLogerService=iLogerService;
	}
	public ProductManager(ILogerService iLogerService,ICampaingsService iCampaingsService) {
		_iLogerService=iLogerService;
		_iCampaingsService=iCampaingsService;
	}
	public void order(Users user,Product product) {
		if(user.getBalance()>=product.getPriceAfterDiscount()) {
			System.out.println(product.getName()+ " Sat�n alma i�lemi ba�ar�yla ger�ekle�tirildi.");
			_iLogerService.log();
		}
	}
	public void campaingsOrder(Users user, Product product,Product campaignProduct) {
		_iCampaingsService.add(campaignProduct);
		order(user,product);
	}
}
