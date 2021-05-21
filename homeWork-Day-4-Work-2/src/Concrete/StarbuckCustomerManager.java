package Concrete;
import Abstract.ICustomerCheckService;
import Abstract.BaseCustomerManager;
import Abstract.ICustomerService;
import Entities.Customer;

public class StarbuckCustomerManager extends BaseCustomerManager  {
	ICustomerCheckService _checkService;
	public StarbuckCustomerManager(ICustomerCheckService checkService) {
		this._checkService=checkService;
	}
	
	private Customer _customer;
	public void save(Customer customer) {
		this._customer=customer;
		if(_checkService.checkIfRealPerson(customer)) {
			System.out.println("Save to db... "+_customer.getFirstName());
		}
		else {
			System.out.println("Not a valid person...");
		}
	}
	

}
