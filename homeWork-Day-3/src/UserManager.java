
public class UserManager {
	
	public void add(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+" baþarýyla kayýt edildi.");
	}
	public void signIn(User user) {
		System.out.println(user.getEmailAddress()+" baþarýyla  giriþ yaptý.");
	}
	public void signOut(User user) {
		System.out.println(user.getEmailAddress()+" baþarýyla çýkýþ yaptý.");
	}
	public void update(User user) {
		System.out.println(user.getEmailAddress()+" baþarýyla güncellendi.");
	}
	public void delete(User user) {
		System.out.println(user.getEmailAddress()+" baþarýyla silindi.");
	}
	
}
