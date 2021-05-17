package interfaces;

public class Main {

	public static void main(String[] args) {
		
		EmailLogger emailLogger = new EmailLogger();
		FileLogger fileLogger = new FileLogger();
		Logger[] loggers= {emailLogger,fileLogger};
		
		CustomerManager customerManager = new CustomerManager(loggers);
		Customer customer = new Customer(0,"�brahim","Acar");
		
		customerManager.add(customer);

	}

}
