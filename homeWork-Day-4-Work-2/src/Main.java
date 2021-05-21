import Abstract.BaseCustomerManager;
import Abstract.ICustomerCheckService;
import Abstract.ICustomerService;
import Concrete.CustomerCheckManager;
import Concrete.NeroCustomerManager;
import Concrete.StarbuckCustomerManager;
import Entities.Customer;
import Adapters.MernisServiceAdapter;

public class Main {

	public static void main(String[] args) {
		
		ICustomerCheckService iCustomerCheckService = new MernisServiceAdapter();
		BaseCustomerManager baseCustomerManager= new StarbuckCustomerManager(iCustomerCheckService);
		Customer customer = new Customer();
		customer.setFirstName("ÝBRAHÝM HALÝL");
		customer.setLastName("ACAR");
		customer.setDateOfBirth(2000);
		customer.setNationalityId("21019132100");
		customer.setId(0);
		baseCustomerManager.save(customer);
		
		
	}

}
