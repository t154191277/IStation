package bistu.wmlove.istation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bistu.wmlove.istation.dao.ICategoryDao;
import bistu.wmlove.istation.dao.IGoodsDao;
import bistu.wmlove.istation.dao.IUserDao;
import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.entity.Goods;
import bistu.wmlove.istation.service.ICategoryService;
import bistu.wmlove.istation.service.IGoodsService;

@Service("goodsService")
public class IGoodsServiceImpl implements IGoodsService{

	@Autowired
	private IGoodsDao gdao;
	
	public Goods getGoods(String id, String order, String by) {
		return gdao.getGoods(id, order, by);
	}

	public List<Goods> select(String cagetory, int offset, int limit, String order, String by) {
		return gdao.select(cagetory,offset, limit, order, by);
	}

	public List<Goods> selectName(String name, int offset, int limit, String order, String by) {
		return gdao.selectName(name, offset, limit, order, by);
	}
	
	public List<Goods> selectShop(String shopId, int offset, int limit, String order, String by) {
		return gdao.selectShop(shopId, offset, limit, order, by);
	}

	@Override
	public List<Goods> recommend(String phone, int offset, int limit, String order, String by) {
		return gdao.recommend(phone, offset, limit, order, by);
	}
	
	public int create(String id, String catg1, String catg2, String shopId, String goodName
			, int num, String goodDesc, String price, String select) {
		return gdao.create(id, catg1, catg2, shopId, goodName, num, goodDesc, price, select);
	}

}
