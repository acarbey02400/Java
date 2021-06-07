package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;


public interface CandidateDao extends JpaRepository<Candidate, Integer> {

	List<Candidate> findByIdentityNumber(String identityNumber);
	List<Candidate> findByEmail(String email);
}