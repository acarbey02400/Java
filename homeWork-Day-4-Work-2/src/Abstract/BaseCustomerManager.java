package Abstract;

import Entities.Customer;
import Concrete.NeroCustomerManager;
import Concrete.StarbuckCustomerManager;

public abstract class BaseCustomerManager implements ICustomerService {
	
	
	public void save(Customer customer) {
		System.out.println("Save to db... "+customer.getFirstName());
	}
}
