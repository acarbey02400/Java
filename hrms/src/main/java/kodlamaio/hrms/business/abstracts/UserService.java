package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService {
	Result emailControl(User user);
	Result addControl(User user,String passwordAgain);
	
}
