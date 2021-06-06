package kodlamaio.hrms.core.utilities.adapters;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.MernisTest.MernisVerification;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class MernisServiceAdapter {
	public boolean verify(User user)
	{
		MernisVerification adapter = new MernisVerification();
		return adapter.verify(user);
	}

}
