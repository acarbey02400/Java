
public class UserManager {
	
	public void add(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+" ba�ar�yla kay�t edildi.");
	}
	public void signIn(User user) {
		System.out.println(user.getEmailAddress()+" ba�ar�yla  giri� yapt�.");
	}
	public void signOut(User user) {
		System.out.println(user.getEmailAddress()+" ba�ar�yla ��k�� yapt�.");
	}
	public void update(User user) {
		System.out.println(user.getEmailAddress()+" ba�ar�yla g�ncellendi.");
	}
	public void delete(User user) {
		System.out.println(user.getEmailAddress()+" ba�ar�yla silindi.");
	}
	
}
