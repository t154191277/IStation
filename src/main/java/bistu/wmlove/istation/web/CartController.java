package bistu.wmlove.istation.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import bistu.wmlove.istation.entity.Cart;
import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.entity.Goods;
import bistu.wmlove.istation.entity.Response;
import bistu.wmlove.istation.entity.User;
import bistu.wmlove.istation.entity.WordAndCount;
import bistu.wmlove.istation.service.ICartService;
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
public class CartController extends BaseController{

	@Autowired
	private ICartService cartService;
	
	@RequestMapping(path="/cart", method=RequestMethod.GET)
	public Response select(@RequestParam(name = "id", required = false) String id){
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		phoneId = (String) req.getAttribute("phoneId");
		
		List<Cart> categories = cartService.getCart(phoneId);
		Response response = new Response();
		if(categories != null){
			response.success(categories);
			return response;
		}
		response.success();
		return response;
	}
	
	@RequestMapping(path="/cart", method = RequestMethod.POST)
    public Response save(@RequestParam(name = "goodid", required = true) String goodid) {
		mLogger.warn(String.format("%s,%s,%d,%s", phoneId, goodid, 3, System.currentTimeMillis()));
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		phoneId = (String) req.getAttribute("phoneId");
		
		Response response = new Response();
		int code = cartService.create(phoneId, goodid);
		if(code == 1){
			response.success();
			return response;
		}
		response.failure(code);
		return response;
    }

    @RequestMapping(path="/cart", method = RequestMethod.PUT)
    public Response update(@RequestParam(name = "goodid", required = true) String goodid
    		,@RequestParam(name = "num", required = true) String num) {
    	Response response = new Response();
    	String[] goodIDArr = goodid.split(",");
    	String[] numStrArr = num.split(",");
    	HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		phoneId = (String) req.getAttribute("phoneId");
    	
    	if(goodIDArr.length != numStrArr.length) return response.failure(-1, "goodArr length is not equal to numStrArr!");
    	
    	int[] numIntArr = new int[numStrArr.length];
    	for(int i=0;i<numStrArr.length;i++)
    	{
    		numIntArr[i] = Integer.valueOf(numStrArr[i]);
    	}
		int code = cartService.update(phoneId, goodIDArr, numIntArr);
		if(code != -1){
			return response.success();
		}
		return response.failure(code);
    }

    @RequestMapping(path="/cart", method = RequestMethod.DELETE)
    public Response delete(@RequestParam(name = "goodid", required = true) String goodid) {
    	Response response = new Response();
    	HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		phoneId = (String) req.getAttribute("phoneId");
    	
    	String[] goodArr = goodid.split(",");
		int code = cartService.delete(phoneId, goodArr);
		if(code == 1){
			response.success();
			return response;
		}
		response.failure(code);
		return response;
    }
    
	
}
