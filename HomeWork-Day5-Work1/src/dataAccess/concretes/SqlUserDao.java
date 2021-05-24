package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.Users;

public class SqlUserDao implements UserDao {
	
	public SqlUserDao() {
		
	}
	@Override
	public void addUser(Users user) {
		
		System.out.println(user.getFirstName()+ " SQL ile Sisteme eklendi.");
	}

	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Users user) {
		// TODO Auto-generated method stub
		
	}
	
}
