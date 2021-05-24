package nLayeredDemo.core;

import nLayeredDemo.jLogger.JLoggerManager;

public class JLoggerManagerAdapter implements LoggerService {

	@Override
	public void logToSystem(String Message) {
		JLoggerManager jLoggerManager =new JLoggerManager();
		jLoggerManager.log(Message);
		
	}
	
	
}
