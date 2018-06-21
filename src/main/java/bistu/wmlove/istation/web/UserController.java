package bistu.wmlove.istation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bistu.wmlove.istation.entity.User;
import bistu.wmlove.istation.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUsers() {
        return "getUsers";
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})//此方法只允许 ROLE_ADMIN 和ROLE_USER 角色 访问
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody User user) {
        return  userService.create(user);
    }

    @Secured("ROLE_ADMIN")//此方法只允许 ROLE_ADMIN 角色访问
    @RequestMapping(method = RequestMethod.PUT)
    public String update() {
        return "updateUser";
    }

    @Secured("ROLE_ADMIN")//此方法只允许 ROLE_ADMIN 角色访问
    @RequestMapping(method = RequestMethod.DELETE)
    public String delete() {
        return "deleteUser";
    }
}
