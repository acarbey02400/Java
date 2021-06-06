package kodlamaio.hrms.dataAccess.abstracts;
import java.util.List;

import kodlamaio.hrms.entities.concretes.User;
public interface UserDao {
	List<User> findByEmail(String email);
}