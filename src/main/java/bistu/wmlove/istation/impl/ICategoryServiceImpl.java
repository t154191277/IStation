package bistu.wmlove.istation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bistu.wmlove.istation.dao.ICategoryDao;
import bistu.wmlove.istation.dao.IUserDao;
import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.service.ICategoryService;

@Service("categryService")
public class ICategoryServiceImpl implements ICategoryService{

	@Autowired
	private ICategoryDao cdao;
	
	public List<Category> getCategory() {
		return cdao.getCategory();
	}
	
	public List<Category> getCategoryNew() {
		return cdao.getCategoryNew("2", "desc", "category1");
	}

}
