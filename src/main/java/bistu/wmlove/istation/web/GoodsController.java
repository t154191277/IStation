package bistu.wmlove.istation.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.entity.Goods;
import bistu.wmlove.istation.entity.Response;
import bistu.wmlove.istation.entity.WordAndCount;
import bistu.wmlove.istation.service.ICategoryService;
import bistu.wmlove.istation.service.IGoodsService;
import bistu.wmlove.istation.service.IWordCountService;
/**
 * 
 * @author wmlove
 * @date 2018Äê4ÔÂ17ÈÕ
 *
 */
@RestController
@RequestMapping(value = "/api")
public class GoodsController extends BaseController{

	@Autowired
	private IGoodsService goodsService;
	
	@RequestMapping(path="/goods", method=RequestMethod.GET)
	public Response select(@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "category", required = false) String category,
			@RequestParam(name = "offset", required = false) Integer offset,
			@RequestParam(name = "limit", required = false) Integer limit,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "order", required = false) String order,
			@RequestParam(name = "by", required = false) String by,
			@RequestParam(name = "recommend", required = false) boolean recommend,
			@RequestParam(name = "shopId", required = false) Integer shopId){
		
		order = order == null ? "asc" : order;
		by = by == null ? "item_id" : by;
		
		Response response = new Response();
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String phoneId = (String) req.getAttribute("phoneId");
		
		if(!StringUtils.isEmpty(id))
		{
			mLogger.warn(String.format("%s,%s,%d,%s", phoneId, id, 1, System.currentTimeMillis()));
			
			Goods good = goodsService.getGoods(id, order, by);
			if(good != null){
				return response.success(good);
			}
			return response.success();
		}
		
		offset = offset == null ? 0 : (offset > 0 ? offset : 0);
		limit = limit == null ? 20 : (limit > 0 && limit <= 50 ? limit : 20);
		
		if(!StringUtils.isEmpty(category))
		{
			List<Goods> list = goodsService.select(category, offset, limit, order, by);
			if(list != null){
				return response.success(list);
			}
			return response.success();
		}
		
		if(!StringUtils.isEmpty(name))
		{
			List<Goods> list = goodsService.selectName(name, offset, limit, order, by);
			if(list != null){
				return response.success(list);
			}
			return response.success();
		}
		
		if(recommend){
			List<Goods> list = goodsService.recommend(phoneId, offset, limit, order, by);
			if(list != null){
				return response.success(list);
			}
			return response.success();
		}
		
		if(!StringUtils.isEmpty(shopId)){
			List<Goods> list = goodsService.selectShop(shopId + "", offset, limit, order, by);
			if(list != null){
				return response.success(list);
			}
			return response.success();
		}
		return response.success();
	}
	
}
