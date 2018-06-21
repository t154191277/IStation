package bistu.wmlove.istation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bistu.wmlove.istation.entity.Category;

public interface ICategoryDao {
	public List<Category> getCategory();
	
	public List<Category> getCategoryNew(@Param("N") String topN
			, @Param("order") String order,@Param("by") String by);
}
