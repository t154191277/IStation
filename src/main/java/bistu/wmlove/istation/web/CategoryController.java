package bistu.wmlove.istation.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.entity.Response;
import bistu.wmlove.istation.entity.WordAndCount;
import bistu.wmlove.istation.service.ICategoryService;
import bistu.wmlove.istation.service.IWordCountService;

/**
 * 
 * @author wmlove
 * @date 2018Äê4ÔÂ16ÈÕ
 *
 */
@RestController
@RequestMapping(value = "/api")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(path="/category", method=RequestMethod.GET)
	public Response getCategory(){
		List<Category> categories = categoryService.getCategoryNew();
		Response response = new Response();
		if(categories != null){
			response.success(categories);
			return response;
		}
		response.success();
		return response;
	}
	
}
