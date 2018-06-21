package bistu.wmlove.istation.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseController {
	
	public Logger mLogger = Logger.getLogger(BaseController.class.getName());
	
	public String phoneId;

	public BaseController() {
		BasicConfigurator.configure();
//		PropertyConfigurator.configure("C:/Users/Administrator/Desktop/istation/src/main/java/log4j.properties");
		PropertyConfigurator.configure("/app/www/IStation/log4j.properties");
	}
	
	

}
