package bistu.wmlove.istation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.entity.Goods;

public interface IGoodsImageDao {
	public Goods getGoods(String id);
	public int create(@Param("itemId")String id,@Param("type") String type, @Param("path") String path);
}
