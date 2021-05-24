package core.concretes;

import GoogleAuthPackage.GoogleAuthManager;
import business.abstracts.UsersService;
import business.abstracts.ValidateService;
import dataAccess.abstracts.UserDao;
import entities.concretes.Users;

public class GoogleAuthManagerAdapter implements UsersService {

	@Override
	public void add(Users user, ValidateService validateService,UserDao userDao) {
		
		GoogleAuthManager authManager = new GoogleAuthManager();
		authManager.googleAuthUserOperation();
	}

	@Override
	public void update(Users user, ValidateService validateService,UserDao userDao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Users user,UserDao userDao) {
		// TODO Auto-generated method stub
		
	}
	public void signIn(String eMail,String password) {
		
	}

}
