package business.abstracts;

import java.util.List;

import entities.concretes.Users;

public interface ValidateService {
	public boolean validOrNotValid(Users user,List<Users> allUsers);	
	public boolean eMailValidOrNotValid(Users user);
}
