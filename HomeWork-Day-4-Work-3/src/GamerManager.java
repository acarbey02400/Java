
public class GamerManager {
	
	ILogerService _iLogerService;
	UserValidate _userValidate;
	
	public GamerManager(ILogerService iLogerService,UserValidate userValidate){
		_iLogerService= iLogerService;
		_userValidate=userValidate;
	}
	
	
	
	public void add(Gamer gamer) {
		if(_userValidate.validOrNotValid(gamer)) {
		System.out.println(gamer.getId()+" id numaralý Kullanýcý eklendi.");
		_iLogerService.log();
		}
		else {
			System.out.println("Lütfen kimlik bilgilerinizi doðru giriniz.");
		}
	}
	
	
	public void update(Gamer gamer) {
		System.out.println(gamer.getId()+" id numaralý Kullanýcý güncellendi.");
		_iLogerService.log();
	}
	
	
	public void remove(Gamer gamer) {
		System.out.println(gamer.getId()+" id numaralý Kullanýcý çýkarýldý.");
		_iLogerService.log();
	}
}
