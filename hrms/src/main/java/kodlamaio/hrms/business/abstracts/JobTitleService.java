package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
 Result add(JobTitle JobTitle);
}
