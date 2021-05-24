package business.abstracts;

import dataAccess.abstracts.UserDao;
import entities.concretes.Users;

public interface UsersService {
	public void add(Users user,ValidateService validateService,UserDao userDao);
	public void update(Users user,ValidateService validateService,UserDao userDao);
	public void delete(Users user,UserDao userDao);
	public void signIn(String eMail,String password);
}
