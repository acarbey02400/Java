package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.SystemEmployeeConfirm;

public interface SystemEmployeeConfirmDao extends JpaRepository<SystemEmployeeConfirm, Integer> {

}
