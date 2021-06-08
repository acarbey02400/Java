package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidateVerificationCodeService;
import kodlamaio.hrms.core.utilities.adapters.MernisServiceAdapter;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.senders.email.EmailSender;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateVerificationCode;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private MernisServiceAdapter mernisServiceAdapter;
	private CandidateVerificationCodeService candidateVerificationCodeService;
	private UserDao userDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisServiceAdapter mernisServiceAdapter, CandidateVerificationCodeService candidateVerificationCodeService,UserDao userDao) {
		this.candidateDao = candidateDao;
		this.mernisServiceAdapter = mernisServiceAdapter;
		this.candidateVerificationCodeService = candidateVerificationCodeService;
		this.userDao=userDao;
	}
	
	@Override
	public List<Candidate> getAll() {
		return this.candidateDao.findAll();
	}

	@Override
	public Result add(Candidate candidate) {
		List<Result> results = new ArrayList<Result>();
		boolean isFail = false;
		Result nullControl = nullControlForAdd(candidate);
		Result emailControl = emailControl(candidate, this.userDao);
		Result identitynumberControl = identitynumberControl(candidate);
		Result mernisVerify = verifyWithMernis(candidate);
		Result passwordAgainControl= passwordAgainControl(candidate);
		results.add(nullControl);
		results.add(emailControl);
		results.add(identitynumberControl);
		results.add(mernisVerify);
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
			this.candidateDao.save(candidate);
			
			Result isCodeSaved = candidateVerificationCodeService.add(candidate);
			if(!isCodeSaved.isSuccess()) {
				
			return new ErrorResult("Candidate added. Verification mail can't send.");
			}else {
				return new SuccessResult("Candidate added. Verification mail sent.");
			}
			
		}else {
			return new ErrorResult("Candidate can't added");
		}
		
	}
	
	public Result nullControlForAdd(Candidate candidate) {
        if (		candidate.getIdentityNumber() == ""
                || candidate.getFirstName() == ""
                || candidate.getLastName() == ""
                || candidate.getEmail() == ""
                || candidate.getPassword() == ""
                || candidate.getBirthYear() == 0
                )
        {
            return new ErrorResult("Fill the all required fields.");
        }
        return new SuccessResult();
	}
	
	public Result verifyWithMernis(Candidate candidate) {
		if(!mernisServiceAdapter.verify(candidate)) {
			return new ErrorResult("Identity verification is not succeed.");
		}
		return new SuccessResult();
	}

	public Result identitynumberControl(Candidate candidate) {
		List<Candidate> users = this.candidateDao.findByIdentityNumber(candidate.getIdentityNumber()); 
		if(!(users.isEmpty()))
		{
			return new ErrorResult("This identity number is already registered.");
		}
		return new SuccessResult();
	}
	public Result emailControl(User user, UserDao userDao) {
		List<User> users = userDao.findByEmail(user.getEmail()); 
		if(!(users.isEmpty()))
		{
			return new ErrorResult("This e-mail is already registered.");
		}
		return new SuccessResult();
	}
	
	public Result passwordAgainControl(Candidate candidate) {
		
		
		if(!(candidate.getPassword().intern() == candidate.getPasswordAgain().intern())) {
			return new ErrorResult("passwords do not match");
		}
		else {
			
			return new SuccessResult();
		}
	}
}
