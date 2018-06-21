package bistu.wmlove.istation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bistu.wmlove.istation.entity.Response;
import bistu.wmlove.istation.entity.User;
import bistu.wmlove.istation.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserControllerNew {
	
	@Autowired
    IUserService userService;

    @RequestMapping(path= "/login", method = RequestMethod.GET)
    public Response login(@RequestParam(name = "phoneID", required = true) String phone) {
    	Response response = new Response();
    	if(phone != null && "".equals(phone))
    	{
    		User user = userService.login(phone);
    		if(user != null){
    			response.success(user);
    			return response;
    		}
    	}
    	response.failure(404);
        return response;
    }
}
