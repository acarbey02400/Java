package kodlamaio.hrms.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateVerificationCode;
public interface CandidateVerificationCodeDao extends JpaRepository<CandidateVerificationCode, Integer>, VerificationCodeDao {

	List<CandidateVerificationCode> findByCode(String code);

}
