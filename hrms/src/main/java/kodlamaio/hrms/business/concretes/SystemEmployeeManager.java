package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
@Service
public class SystemEmployeeManager extends UserManager implements SystemEmployeeService  {
 
SystemEmployeeDao systemEmployeeDao;
    
    @Autowired
    public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao,UserDao userDao) {
    	super(userDao);
    	this.systemEmployeeDao=systemEmployeeDao;
    }
    @Override
    public List<SystemEmployee> getAll() {
        
        return this.systemEmployeeDao.findAll();
    }

    @Override
    public Result add(SystemEmployee systemEmployee,String passwordAgain) {
        List<Result> results = new ArrayList<Result>();
        boolean isFail = false;
        Result nullControl = nullControlForAdd(systemEmployee);
        Result passwordAgainControl= addControl(systemEmployee,passwordAgain);
        
        results.add(nullControl);
        results.add(passwordAgainControl);
        
        for (var result : results) {
            if(!result.isSuccess())
            {
                isFail = true;
                return result;
            }
        }
        if(isFail == false)
        {
            this.systemEmployeeDao.save(systemEmployee);
            return new SuccessResult("System Employee added.");
            
        }
        return new ErrorResult();
        
    }
    public Result nullControlForAdd(SystemEmployee systemEmployee) {
        if (    
                 systemEmployee.getFirstName() == ""
                || systemEmployee.getLastName() == ""
                || systemEmployee.getEmail() == ""
                || systemEmployee.getPassword() == ""
                
                )
        {
            return new ErrorResult("Fill the all required fields.");
        }
        return new SuccessResult();
    }
    
}
