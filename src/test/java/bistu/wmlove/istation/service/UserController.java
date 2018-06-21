package bistu.wmlove.istation.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bistu.wmlove.istation.entity.User;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/showname",method=RequestMethod.GET)
	public String showUserName(@RequestParam("uid") int uid,HttpServletRequest request,Model model){
//		User user = userService.getUserById(uid);
//		if(user != null){
//			request.setAttribute("name", user.getUserName());
//			model.addAttribute("mame", user.getUserName());
//			return "showName";
//		}
//		request.setAttribute("error", "error");
		return "error";
	}
}
