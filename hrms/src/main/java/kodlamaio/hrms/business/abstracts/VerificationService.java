package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface VerificationService {
	Result send(String email,String code);
}
