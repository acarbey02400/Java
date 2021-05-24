
public abstract class Users {
	private int id;
	private String firstName;
	private String lastName;
	private long nationalIdentityId;
	private int dateOfBirth;
	private double balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getNationalIdentityId() {
		return nationalIdentityId;
	}
	public void setNationalIdentityId(long nationalIdentityId) {
		this.nationalIdentityId = nationalIdentityId;
	}
	public int getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
