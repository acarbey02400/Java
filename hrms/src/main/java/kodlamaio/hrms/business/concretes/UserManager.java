package kodlamaio.hrms.business.concretes;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
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
	@Override
	public Result addControl(User user,String passwordAgain) {
		List<Result> results = new ArrayList<Result>();
        boolean isFail = false;
      
        Result passwordAgainControl=passwordAgainControl(user,passwordAgain);
        results.add(passwordAgainControl);
        for (var result : results) {
			if(!result.isSuccess())
			{
				isFail = true;
				return result;
			}

		}
       
        return new SuccessResult();
		
       
	}
      
        public Result passwordAgainControl(User user,String passwordAgain) {
    		if(!(user.getPassword().intern() == passwordAgain.intern())) {
    			return new ErrorResult("passwords do not match");
    		}
    		
    			return new SuccessResult();
    		
    	}

}