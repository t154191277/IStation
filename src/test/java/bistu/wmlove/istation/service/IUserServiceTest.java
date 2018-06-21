package bistu.wmlove.istation.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bistu.wmlove.istation.entity.User;
import bistu.wmlove.istation.service.IUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml"})
public class IUserServiceTest {

	@Autowired
	public IUserService userService;
	
	@Test
	public void getUserByIdTest(){
	 
//		User user = new User();
//		user.setId(2);
//		user.setUserName("h");
//		user.setPassword("h");
//		user.setRole("ROLE_ADMIN");
//		userService.create(user);
//		System.out.println(user.getUserName());
		
	}
	
}
