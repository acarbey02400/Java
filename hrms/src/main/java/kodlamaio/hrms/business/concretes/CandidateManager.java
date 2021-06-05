package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService  {
	CandidateDao candidateDao;
	
	@Override
	public void add(Candidate candidate ) {
		candidateDao.save(candidate);
		
	}
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		this.candidateDao =candidateDao;
	}

}
