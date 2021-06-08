package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.SystemEmployeeConfirmEmployer;

public interface SystemEmployeeConfirmEmployerService {
	Result employerConfirm(SystemEmployeeConfirmEmployer systemEmployeeConfirm);
	//Result add(SystemEmployeeConfirmEmployer systemEmployeeConfirmEmployer);
}
