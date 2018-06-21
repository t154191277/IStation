package bistu.wmlove.istation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bistu.wmlove.istation.dao.IUserDao;
import bistu.wmlove.istation.entity.User;
import bistu.wmlove.istation.service.IUserService;

@Service("userService")
public class IUserServiceImpl implements IUserService{

	@Autowired
	private IUserDao udao;
	
	public Integer create(User user) {
		return udao.insert(user);
	}

	public User login(String phone) {
		User user = udao.selectById(phone);
		if (user != null)
		{
			return user;
		}
		user = new User();
		user.setId(Integer.valueOf(phone));
		udao.insert(user);
		return user;
	}

}
