package bistu.wmlove.istation.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import bistu.wmlove.istation.entity.WordAndCount;
import bistu.wmlove.istation.web.WordCountController;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml", "classpath:spring-mvc.xml"})
public class WordCountControllerTest {

	@Autowired
	public WordCountController wordCountController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(wordCountController).build();
	}
	
	@Test
	public void getWordCountByTextTest() throws Exception{
		ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/showwordcount").param("text", "ÖÐ¹ú"));
		MvcResult mvcResult = actions.andReturn();
		System.out.println("url = " + mvcResult.getResponse().getForwardedUrl());
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("result = " + result);
		System.out.println(mvcResult.getResponse().getStatus());
	}
	
}
