
public class GamerManager {
	
	ILogerService _iLogerService;
	UserValidate _userValidate;
	
	public GamerManager(ILogerService iLogerService,UserValidate userValidate){
		_iLogerService= iLogerService;
		_userValidate=userValidate;
	}
	
	
	
	public void add(Gamer gamer) {
		if(_userValidate.validOrNotValid(gamer)) {
		System.out.println(gamer.getId()+" id numaral� Kullan�c� eklendi.");
		_iLogerService.log();
		}
		else {
			System.out.println("L�tfen kimlik bilgilerinizi do�ru giriniz.");
		}
	}
	
	
	public void update(Gamer gamer) {
		System.out.println(gamer.getId()+" id numaral� Kullan�c� g�ncellendi.");
		_iLogerService.log();
	}
	
	
	public void remove(Gamer gamer) {
		System.out.println(gamer.getId()+" id numaral� Kullan�c� ��kar�ld�.");
		_iLogerService.log();
	}
}
