package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemEmployeeConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeeConfirmEmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.SystemEmployeeConfirmEmployer;
@Service
public class SystemEmployeeConfirmEmployerManager implements SystemEmployeeConfirmEmployerService {
	
	SystemEmployeeConfirmEmployerDao systemEmployeeConfirmEmployerDao;
	
	@Autowired
	public SystemEmployeeConfirmEmployerManager(SystemEmployeeConfirmEmployerDao systemEmployeeConfirmEmployerDao) {
		this.systemEmployeeConfirmEmployerDao= systemEmployeeConfirmEmployerDao;
	}
//	@Override
//	public Result add(SystemEmployeeConfirmEmployer systemEmployeeConfirmEmployer) {
//		 this.systemEmployeeConfirmEmployerDao.save(systemEmployeeConfirmEmployer); 
//		 return new SuccessResult("System employee confirm employer added");
//	}
	
	@Override
	public Result employerConfirm(SystemEmployeeConfirmEmployer systemEmployeeConfirmEmployer) {
		
		systemEmployeeConfirmEmployer.setConfirmDate(Date.valueOf(LocalDate.now()));
		systemEmployeeConfirmEmployer.setConfirmed(true);
		systemEmployeeConfirmEmployerDao.save(systemEmployeeConfirmEmployer);
		
		return new SuccessResult("Employer is confirmed.");
	}
}
