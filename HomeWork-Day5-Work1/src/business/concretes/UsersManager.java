package business.concretes;

import java.util.ArrayList;
import java.util.List;

import business.abstracts.UsersService;
import business.abstracts.ValidateService;
import dataAccess.abstracts.UserDao;
import entities.concretes.Users;

public class UsersManager implements UsersService{
	List<Users> allUsers= new ArrayList<Users>();
	
	
	public UsersManager() {
		
		
	}
	@Override
	public void add(Users user,ValidateService validateService,UserDao userDao) {
		if(validateService.validOrNotValid(user,allUsers)) {
			allUsers.add(user);
			}
		if(validateService.eMailValidOrNotValid(user)) {
			userDao.addUser(user);
			System.out.println("Mail adresiniz doðrulandý. Üyeliðiniz tamamlandý.");
		}
		}
		
		
	

	@Override
	public void update(Users user,ValidateService validateService,UserDao userDao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Users user,UserDao userDao) {
		// TODO Auto-generated method stub
		
	}
	
	public void signIn(String eMail,String password) {
		for(var user:allUsers) {
			if(eMail==user.geteMail()) {
				if(password==user.getPassword()) {
					System.out.println("Giriþ baþarýlý.");
				}
			}
		}
	}
	
}
