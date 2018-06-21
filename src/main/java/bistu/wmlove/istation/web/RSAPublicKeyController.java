package bistu.wmlove.istation.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bistu.wmlove.istation.entity.Response;
import bistu.wmlove.istation.entity.WordAndCount;
import bistu.wmlove.istation.service.IRSAService;

@RestController
@RequestMapping(path = "/api")
public class RSAPublicKeyController {
	
	@Autowired
	private IRSAService rsaService;
	
	@RequestMapping(path="/rsaPubkey",method=RequestMethod.GET)
	public String showWordCount(){
		return rsaService.getPublicKey();
	}
}
