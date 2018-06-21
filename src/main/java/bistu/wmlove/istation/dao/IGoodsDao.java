package bistu.wmlove.istation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.entity.Goods;

public interface IGoodsDao {
	
	public Goods getGoods(@Param("id") String id
			,@Param("order")String order,@Param("by")String by);

	public List<Goods> select(@Param("category") String category
			,@Param("offset") int offset,@Param("limit") int limit
			,@Param("order")String order,@Param("by")String by);
	
	public List<Goods> selectName(@Param("name") String name
			, @Param("offset") int offset,@Param("limit") int limit
			,@Param("order")String order,@Param("by")String by);
	
	public List<Goods> selectShop(@Param("shopId") String shopId
			, @Param("offset") int offset,@Param("limit") int limit
			,@Param("order")String order,@Param("by")String by);
	
	public List<Goods> recommend(@Param("phone") String phone
			, @Param("offset") int offset,@Param("limit") int limit
			,@Param("order")String order,@Param("by")String by);
	
	public int create(@Param("id")String id,@Param("catg1") String catg1,@Param("catg2") String catg2
			,@Param("shopId") String shopId,@Param("goodName")String goodName,@Param("num") int num
			,@Param("goodDesc") String goodDesc,@Param("price") String price,@Param("select") String select);
}
