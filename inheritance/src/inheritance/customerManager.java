package inheritance;

public class customerManager {
	
	public void add(Customer customer) {
		System.out.println(customer.customerNumber+" kaydedildi.");
	}
	
	public void addMulti(Customer[] customers) {
		for(Customer customer : customers) {
			add(customer);
		}
	}
}
