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
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
@Service
public class SystemEmployeeManager implements SystemEmployeeService {
 
SystemEmployeeDao systemEmployeeDao;
    
    @Autowired
    public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao) {
    this.systemEmployeeDao=systemEmployeeDao;
    }
    @Override
    public List<SystemEmployee> getAll() {
        
        return this.systemEmployeeDao.findAll();
    }

    @Override
    public Result add(SystemEmployee systemEmployee) {
        List<Result> results = new ArrayList<Result>();
        boolean isFail = false;
        Result nullControl = nullControlForAdd(systemEmployee);
        Result passwordAgainControl= passwordAgainControl(systemEmployee);
        
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
    public Result passwordAgainControl(SystemEmployee systemEmployee) {
		if(!(systemEmployee.getPassword().intern() == systemEmployee.getPasswordAgain().intern())) {
			return new ErrorResult("passwords do not match");
		}
		else {
			return new SuccessResult();
		}
	}
}
