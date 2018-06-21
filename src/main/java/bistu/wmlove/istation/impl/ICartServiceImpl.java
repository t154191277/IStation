package bistu.wmlove.istation.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bistu.wmlove.istation.dao.ICartsDao;
import bistu.wmlove.istation.dao.ICategoryDao;
import bistu.wmlove.istation.dao.IUserDao;
import bistu.wmlove.istation.entity.Cart;
import bistu.wmlove.istation.entity.Category;
import bistu.wmlove.istation.service.ICartService;
import bistu.wmlove.istation.service.ICategoryService;

@Service("cartService")
public class ICartServiceImpl implements ICartService {

	@Autowired
	private ICartsDao cdao;

	@Override
	public List<Cart> getCart(String id) {
		return cdao.getCarts(id);
	}

	@Override
	public int create(String phoneid, String goodid) {
		return cdao.create(phoneid, goodid);
	}

	@Override
	public int delete(String phoneid, String[] goodid) {
		return cdao.delete(phoneid, goodid);
	}

	@Override
	public int update(String phoneid, String[] goodIDArr, int[] numIntArr) {
		return cdao.update(phoneid, getPairList(goodIDArr, numIntArr), goodIDArr);
	}

	public class Pair {

		public String goodID;
		public int num;

		public Pair(String goodID, int num) {
			this.goodID = goodID;
			this.num = num;
		}

	}

	public List<Pair> getPairList(String[] goodArr, int[] numIntArr) {
		List<Pair> pairList = new ArrayList<Pair>(goodArr.length);
		for (int i = 0; i < goodArr.length; i++) {
			pairList.add(new Pair(goodArr[i], numIntArr[i]));
		}
		return pairList;
	}

}
