package bistu.wmlove.istation.service;

import java.util.List;

import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.entity.Goods;

public interface IGoodsService {

	public Goods getGoods(String id, String order, String by);
	
	public List<Goods> select(String cagetory, int offset, int limit, String order, String by);
	
	public List<Goods> selectName(String name, int offset, int limit, String order, String by);
	
	public List<Goods> selectShop(String shopId, int offset, int limit, String order, String by);
	
	public List<Goods> recommend(String phone, int offset, int limit, String order, String by);

	public int create(String goodId, String catg1, String catg2, String shopId,
			String goodName, int i, String goodDesc, String goodPrice,
			String goodSelect);
	
}
