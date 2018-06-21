package bistu.wmlove.istation.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bistu.wmlove.istation.dao.IUserDao;
import bistu.wmlove.istation.entity.User;
import bistu.wmlove.istation.jwt.JWTUserDetails;

/**
 * 提供认证所需的用户信息
 * 
 * @author wmlove
 * @since 2018-3-11
 *
 */

public class UserDetailsServiceCustom implements UserDetailsService{
	
	@Autowired
	private IUserDao userDao;

	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {
		User user = userDao.queryUserByName(name);
		
		if (user == null){
			throw new UsernameNotFoundException("找不到该用户");
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority(user.getRole()));
//		
//		UserDetails userDetails = new JWTUserDetails(user.getId(), user.getUserName(), 
//				user.getPassword(), authorities);
		
//		return userDetails;
		return null;
	}
	
}
