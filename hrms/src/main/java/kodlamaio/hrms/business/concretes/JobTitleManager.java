package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	
	@Override
	public List<JobTitle> getAll() {
		return this.jobTitleDao.findAll();
	}


	@Override
	public Result add(JobTitle jobTitle) {
		List<Result> results = new ArrayList<Result>();
		Result jobTitleNameControl= jobTitleNameControl(jobTitle);
		results.add(jobTitleNameControl);
		boolean isFail = false;
		for (var result : results) {
			if(!result.isSuccess())
			{
				isFail = true;
				return result;
			}
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Job title added.");
	}
	public Result jobTitleNameControl(JobTitle jobTitle) {
		List<JobTitle> titles = this.jobTitleDao.findByTitle(jobTitle.getTitle()); 
		if(!(titles.isEmpty()))
		{
			return new ErrorResult("This title has already exists.");
		}
		return new SuccessResult();
	}
}
