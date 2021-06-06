package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.EmployerVerificationCode;

public interface EmployerVerificationCodeDao extends JpaRepository<EmployerVerificationCode, Integer>, VerificationCodeDao{
	List<EmployerVerificationCode> findByCode(String code);
}
