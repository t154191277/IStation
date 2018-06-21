package bistu.wmlove.istation.service;

import org.springframework.beans.factory.annotation.Autowired;

import bistu.wmlove.istation.entity.User;

public interface IUserService {
	  	
	public User login(String phone);
	
	public Integer create(User user);

}
