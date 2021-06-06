package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateVerificationCodeService {
	Result add(Candidate candidate);
	String createCode();
}
