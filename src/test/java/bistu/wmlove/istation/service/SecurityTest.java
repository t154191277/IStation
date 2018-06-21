package bistu.wmlove.istation.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import bistu.wmlove.istation.impl.HelloMessageService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({ "classpath:applicationContext.xml", "classpath:spring-mvc.xml"})
public class SecurityTest {

	@Autowired
	private MessageService messageService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(messageService).build();
	}
	
	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void getMessageUnauthenticated() throws Exception {
		ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/api/category"));
		System.out.println(messageService.getMessage());
	}
}
