package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.SystemEmployeeConfirmEmployerService;
import kodlamaio.hrms.business.concretes.SystemEmployeeConfirmEmployerManager;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.SystemEmployeeConfirmEmployer;

@RestController
@RequestMapping("/api/confirmwithsystememployee")
public class SystemEmployeeConfirmController {
	private SystemEmployeeConfirmEmployerService systemEmployeeConfirmEmployerService;
	
	@Autowired
	public SystemEmployeeConfirmController(SystemEmployeeConfirmEmployerService systemEmployeeConfirmEmployerService) {
		super();
		this.systemEmployeeConfirmEmployerService = systemEmployeeConfirmEmployerService;
	
	}
	@PostMapping("/employerconfirm")
	public Result confirm(@RequestBody SystemEmployeeConfirmEmployer systemEmployeeConfirmEmployer,@RequestBody Employer employer) {
		return this.systemEmployeeConfirmEmployerService.employerConfirm(employer, systemEmployeeConfirmEmployer);
	}
}
