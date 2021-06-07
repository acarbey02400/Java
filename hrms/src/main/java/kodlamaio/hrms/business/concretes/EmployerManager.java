package kodlamaio.hrms.business.concretes;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateVerificationCodeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.EmployerVerificationCodeService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;
@Service
public class EmployerManager implements EmployerService {

	EmployerDao employerDao;
	EmployerVerificationCodeService employerVerificationCodeService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmployerVerificationCodeService employerVerificationCodeService) {
		this.employerDao = employerDao;
		this.employerVerificationCodeService = employerVerificationCodeService;
	}
	
	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

	@Override
	public Result add(Employer employer) {
		List<Result> results = new ArrayList<Result>();
		boolean isFail = false;
		
		Result nullControl = nullControlForAdd(employer);
		Result emailControl = emailControl(employer, this.employerDao);

		results.add(nullControl);
		results.add(emailControl);
		
		for (var result : results) {
			if(!result.isSuccess())
			{
				isFail = true;
				return result;
			}
		}
		
		if(isFail == false)
		{
			this.employerDao.save(employer);
			Result isCodeSaved = employerVerificationCodeService.add(employer);
			if(!isCodeSaved.isSuccess()) {
				
			return new ErrorResult("Employer added. Verification mail can't send.");
			}else {
				return new SuccessResult("Employer added. Verification mail sent.");
			}
				
		}else {
			return new ErrorResult();
		}
		
	}

	private Result nullControlForAdd(Employer employer) {
        if (	employer.getCompanyName() == ""
                || employer.getWebAdress() == ""
                || employer.getPhoneNumber() == ""
                || employer.getEmail() == ""
                || employer.getPassword() == ""
                || employer.getPasswordAgain() == ""
                )
        {
            return new ErrorResult("Fill the all required fields.");
        }
        return new SuccessResult();
	}
	public Result emailControl(User user, EmployerDao employerDao) {
		List<Employer> users = employerDao.findByEmail(user.getEmail()); 
		if(!(users.isEmpty()))
		{
			return new ErrorResult("This e-mail is already registered.");
		}
		return new SuccessResult();
	}
}