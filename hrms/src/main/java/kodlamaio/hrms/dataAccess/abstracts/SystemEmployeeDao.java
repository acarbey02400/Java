package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SystemEmployee;
import kodlamaio.hrms.entities.concretes.User;


public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer> {
	
}
