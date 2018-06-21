package bistu.wmlove.istation.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bistu.wmlove.istation.entity.User;
import bistu.wmlove.istation.service.IUserService;

public class IUserServiceTest2 {

	
	public static void main(String[] args) {
		ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService uService = (IUserService) application.getBean("userService");
//		User user = uService.getUserById(1);
//		System.out.println(user.getUserName());
	}
}
