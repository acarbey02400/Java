package inheritance;

public class Main {

	public static void main(String[] args) {
		IndividualCustomer ibrahim = new IndividualCustomer();
		CorporateCustomer acarElektronik = new CorporateCustomer();
		UnionCustomer isciSendikasi = new UnionCustomer();
		ibrahim.customerNumber="0";
		acarElektronik.customerNumber="17";
		isciSendikasi.customerNumber="104";
		
		Customer[] customers= {ibrahim,acarElektronik,isciSendikasi};
		customerManager customermanager = new customerManager();
		customermanager.addMulti(customers);

	}

}
