package kodlamaio.hrms.business.concretes;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.senders.email.EmailSender;
@Service
public class EmailVerificationManager implements VerificationService{
	
	EmailSender emailSender = new EmailSender();
	public Result send(String email,String code)
	{ 
		
		boolean sendEmail = emailSender.sendVerificationCode(email, code);
		if(sendEmail == false)
		{
			return new ErrorResult();

		}else {
			return new SuccessResult();
		}
		
	}
	
	public boolean verify() {
		return true;
	}
}