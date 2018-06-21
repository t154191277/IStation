package bistu.wmlove.istation.service;

import java.util.List;

import bistu.wmlove.istation.entity.Cart;
import bistu.wmlove.istation.entity.Category;

public interface ICartService {

	public List<Cart> getCart(String id);

	public int create(String phoneid, String goodid);
 
	public int delete(String phoneid, String[] goodArr);

	public int update(String phoneid, String[] goodIDArr, int[] numIntArr);
}
