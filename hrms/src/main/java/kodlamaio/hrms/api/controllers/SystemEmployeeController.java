package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

@RestController
@RequestMapping("/api/systemployee")
public class SystemEmployeeController {
	private SystemEmployeeService systemEmployeeService;
	 
	 @Autowired
	 public SystemEmployeeController(SystemEmployeeService systemEmployeeService) {
	    super();
	    this.systemEmployeeService= systemEmployeeService;
	     }
	 
	     @GetMapping("/getall")
	    public List<SystemEmployee> getAll() {
	        return this.systemEmployeeService.getAll();
	    }

	    @PostMapping("/add")
	    public Result add(@RequestBody SystemEmployee systemEmployee) {
	        return this.systemEmployeeService.add(systemEmployee);
	    }
}
