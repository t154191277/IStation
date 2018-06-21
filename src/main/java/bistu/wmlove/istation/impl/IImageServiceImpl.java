package bistu.wmlove.istation.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bistu.wmlove.istation.dao.ICartsDao;
import bistu.wmlove.istation.dao.ICategoryDao;
import bistu.wmlove.istation.dao.IGoodsImageDao;
import bistu.wmlove.istation.dao.IShopDao;
import bistu.wmlove.istation.dao.IUserDao;
import bistu.wmlove.istation.entity.Cart;
import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.service.ICartService;
import bistu.wmlove.istation.service.ICategoryService;
import bistu.wmlove.istation.service.IImageService;
import bistu.wmlove.istation.service.IShopService;

@Service("imageService")
public class IImageServiceImpl implements IImageService {

	@Autowired
	private IGoodsImageDao idao;

	@Override
	public int create(String id, String type, String path) {
		// TODO Auto-generated method stub
		return idao.create(id, type, path);
	}

}
