
public class CustomerManager {
	private BaseDatabaseManager databaseManager;
	
	public CustomerManager(BaseDatabaseManager databaseManager) {
		this.databaseManager=databaseManager;
	}
	public CustomerManager() {
		
	}
	public void getCustomers() {
		
		databaseManager.getData();
		
		
	}
}
