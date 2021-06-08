package kodlamaio.hrms.business.concretes;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
	UserDao userDao;
	public UserManager(UserDao userDao) {
		this.userDao=userDao;
	}
	@Override
	public Result emailControl(User user) {
		List<User> users = this.userDao.findByEmail(user.getEmail()); 
		if(!(users.isEmpty()))
		{
			return new ErrorResult("This e-mail is already registered.");
		}
		return new SuccessResult();
	}

}