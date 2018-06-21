package bistu.wmlove.istation.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.entity.WordAndCount;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml"})
public class IWordCountServiceTest {

	@Autowired
	public IWordCountService wordCountService;
	
//	@Test
	public void getWordCountByTextTest(){
	 
		WordAndCount wordAndCount = wordCountService.getWordAndCount("ÖÐ¹ú");
		System.out.println(wordAndCount.toString());
	}
	
	@Autowired
	public ICategoryService cateService;
	
	@Test
	public void getCategoryTest(){
	 
//		Category c = cateService.getCategory();
//		System.out.println(c.toString());
	}
	
}
