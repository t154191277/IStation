package bistu.wmlove.istation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bistu.wmlove.istation.entity.Cart;
import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.entity.Goods;
import bistu.wmlove.istation.impl.ICartServiceImpl.Pair;

public interface IShopDao {
	
	public int create(@Param("id")String id,@Param("shopName") String shopName);
}
