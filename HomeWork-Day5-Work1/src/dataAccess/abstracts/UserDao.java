package dataAccess.abstracts;

import entities.concretes.Users;

public interface UserDao {
	public void addUser(Users user);
	public void updateUser(Users user);
	public void deleteUser(Users user);
}
