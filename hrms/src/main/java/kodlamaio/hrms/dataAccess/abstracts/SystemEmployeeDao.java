package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SystemEmployee;


public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer> {
	List<SystemEmployee> findByUser_Email(String email);
}
