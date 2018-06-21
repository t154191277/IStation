package bistu.wmlove.istation.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bistu.wmlove.istation.entity.Response;
import bistu.wmlove.istation.entity.WordAndCount;
import bistu.wmlove.istation.service.IWordCountService;

/**
 * 
 * @author wmlove
 * @date 2018年3月11日
 *
 */

@RestController
public class ErrorController {

	@Autowired
	private IWordCountService wordCountService;
	
	@RequestMapping(path="/error_404")
	public Response error(){
		Response response = new Response();
		response.failure(404, "没有找到资源！");
		return response;
	}
}
