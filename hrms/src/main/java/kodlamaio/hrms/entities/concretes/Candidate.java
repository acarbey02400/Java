package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates")
public class Candidate {
	  @Column(name = "first_name")
	    private String firstName;

	    @Column(name = "last_name")
	    private String lastName;

	    @Column(name = "identity_number")
	    private String identityNumber;

	    @Column(name = "birth_year")
	    private int birthYear;
	    
	    @Column(name = "email")
	    private int eMail;
	   
	    @Column(name = "password")
	    private int password;
}
