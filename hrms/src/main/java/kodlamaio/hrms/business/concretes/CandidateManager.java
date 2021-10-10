package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidateVerificationCodeService;
import kodlamaio.hrms.core.utilities.adapters.MernisServiceAdapter;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager extends UserManager implements CandidateService{

	private CandidateDao candidateDao;
	private MernisServiceAdapter mernisServiceAdapter;
	private CandidateVerificationCodeService candidateVerificationCodeService;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisServiceAdapter mernisServiceAdapter, CandidateVerificationCodeService candidateVerificationCodeService,UserDao userDao) {
		super(userDao);
		this.candidateDao = candidateDao;
		this.mernisServiceAdapter = mernisServiceAdapter;
		this.candidateVerificationCodeService = candidateVerificationCodeService;
		
	}
	
	@Override
	public List<Candidate> getAll() {
		return this.candidateDao.findAll();
	}

	@Override
	public Result add(Candidate candidate,String passwordAgain) {
		List<Result> results = new ArrayList<Result>();
		boolean isFail = false;
		Result nullControl = nullControlForAdd(candidate);
		Result emailControl = emailControl(candidate);
		Result identitynumberControl = identitynumberControl(candidate);
		Result mernisVerify = verifyWithMernis(candidate);
		Result passwordAgainControl= addControl(candidate,passwordAgain);
		Result emailRegexControl = emailRegexControl(candidate);
		results.add(nullControl);
		results.add(emailRegexControl);
		results.add(passwordAgainControl);
		results.add(emailControl);
		results.add(identitynumberControl);
		results.add(mernisVerify);
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
	public Result emailRegexControl(Candidate candidate) {
		
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(candidate.getEmail());
			if(!(matcher.find())) {
				return new ErrorResult("Please enter a valid e-mail address.");
			}
			else {
				return new SuccessResult();
			}
		
		
	}
	public Result identitynumberControl(Candidate candidate) {
		List<Candidate> users = this.candidateDao.findByIdentityNumber(candidate.getIdentityNumber()); 
		if(!(users.isEmpty()))
		{
			return new ErrorResult("This identity number is already registered.");
		}
		return new SuccessResult();
	}
	
	
}
