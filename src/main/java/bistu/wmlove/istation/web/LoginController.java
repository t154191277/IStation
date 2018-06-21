package bistu.wmlove.istation.web;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bistu.wmlove.istation.dao.IUserDao;
import bistu.wmlove.istation.entity.Response;
import bistu.wmlove.istation.entity.User;
import bistu.wmlove.istation.jwt.JWTUserDetails;
import bistu.wmlove.istation.jwt.JWTUtils;

/**
 * 
 * @author wmlove
 * @date 2018Äê3ÔÂ11ÈÕ
 *
 */

@RestController
@RequestMapping(path = "/account")
public class LoginController {
	
    private static Long access_token_expiration =  24 * 60 * 1000L;
    
    @Resource
    private JWTUtils jwt;
	
	@Autowired
	private IUserDao udao;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestParam(name = "phoneid", required = false) String phone , @RequestParam(name = "logout", required = false) String logout) {
    	Response response = new Response();
        if (logout != null) {
            return null;
        }
        if (phone != null) {
        	String token = jwt.generateAccessToken(phone);
        	
        	Map<String, Object> keyMap = new HashMap<String, Object>();
        	keyMap.put("user_id", phone);
        	keyMap.put("expires_in", access_token_expiration);
        	keyMap.put("access_token", token);
        	
            return response.success(keyMap);
        }
        return response.failure(400, "token error");
    }
}
