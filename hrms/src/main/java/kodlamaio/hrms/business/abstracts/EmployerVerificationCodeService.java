package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerVerificationCodeService extends VerificationCodeService{
	Result add(Employer employer);
}
