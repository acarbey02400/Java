package kodlamaio.hrms.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateVerificationCodeService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.senders.email.EmailSender;
import kodlamaio.hrms.dataAccess.abstracts.CandidateVerificationCodeDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateVerificationCode;
@Service 
public class CandidateVerificationCodeManager implements CandidateVerificationCodeService{
	
	CandidateVerificationCodeDao candidateVerificationCodeDao;
	VerificationService verificationService;
	
	@Autowired
	public CandidateVerificationCodeManager(CandidateVerificationCodeDao candidateVerificationCodeDao,VerificationService verificationService) {
		this.candidateVerificationCodeDao = candidateVerificationCodeDao;
		this.verificationService = verificationService;
	}
	
	
	
	public String createCode() {
		return "X52FB2KL";
	}	
	
	public Result add(Candidate candidate)
	{
		
		String code = createCode();
		CandidateVerificationCode candidateVerificationCode = new CandidateVerificationCode();
		
		candidateVerificationCode.setCode(code);
		candidateVerificationCode.setCandidateId(candidate.getId());
		candidateVerificationCodeDao.save(candidateVerificationCode);
		
		return verificationService.send(candidate.getEmail(), code);
		
		
	}
	
	public Result verify(String code) {
		List<CandidateVerificationCode> codes = candidateVerificationCodeDao.findByCode(code);
		if(!codes.isEmpty())
		{
			return new SuccessResult("Account is verified.");			
		}
		return new ErrorResult("This verification code is invalid.");
	}
	
}
