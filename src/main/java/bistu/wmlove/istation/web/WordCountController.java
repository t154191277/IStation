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
 * @date 2018Äê3ÔÂ11ÈÕ
 *
 */

@RestController
@RequestMapping(path="/wordcount")
public class WordCountController {

	@Autowired
	private IWordCountService wordCountService;
	
	@RequestMapping(path="/list",method=RequestMethod.GET)
	public Response showWordCount(Integer offset,Integer limit){
		offset = offset == null ? 0 : offset;
		limit = limit == null ? 20 : limit;
		List<WordAndCount> waclist = wordCountService.getWordAndCount(offset,limit);
		Response response = new Response();
		if(waclist != null){
			response.success(waclist);
			return response;
		}
		response.success();
		return response;
	}
}
