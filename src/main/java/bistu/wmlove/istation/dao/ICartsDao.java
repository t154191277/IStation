package bistu.wmlove.istation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bistu.wmlove.istation.entity.Cart;
import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.entity.Goods;
import bistu.wmlove.istation.impl.ICartServiceImpl.Pair;

public interface ICartsDao {
	
	public List<Cart> getCarts(@Param("phone") String id);

	public int create(@Param("phoneid")String phoneid,@Param("goodid") String goodid);

	public int update(@Param("phoneid")String phoneid,@Param("list") List<Pair> pairList, @Param("goodIDArr") String[] goodid);

	public int delete(@Param("phoneid")String phoneid,@Param("goodIDArr") String[] goodid);

}
