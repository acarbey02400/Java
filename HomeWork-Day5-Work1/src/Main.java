import java.util.List;

import business.abstracts.UsersService;
import business.concretes.UsersManager;
import business.concretes.UsersValidateManager;
import core.concretes.GoogleAuthManagerAdapter;
import dataAccess.concretes.SqlUserDao;

import java.util.ArrayList;
import entities.concretes.Users;

public class Main {

	public static void main(String[] args) {
		
		
		Users user = new Users();
		user.seteMail("acarwoody01@gmail.com");
		user.setFirstName("Ýbrahim Halil");
		user.setLastName("Acar");
		user.setPassword("123456");
		
		Users user2 = new Users();
		user2.seteMail("acarwoody00@gmail.com");
		user2.setFirstName("halil ibrahim");
		user2.setLastName("Acar");
		user2.setPassword("123456");
		
		UsersManager usersManager = new UsersManager();
		usersManager.add(user, new UsersValidateManager(),new SqlUserDao());
		usersManager.add(user2,new UsersValidateManager(),new SqlUserDao());
		
		UsersService usersService = new GoogleAuthManagerAdapter();
		usersService.add(new Users(), new UsersValidateManager(),new SqlUserDao());
		
		System.out.println();
		usersManager.signIn("acarwoody01@gmail.com", "123456");
		
	}

}
