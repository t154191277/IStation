package bistu.wmlove.istation.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import bistu.wmlove.istation.security.rsa.RSAHelper;
import bistu.wmlove.istation.service.IRSAService;

@Service("rsaService")
public class IRSAServiceImpl implements IRSAService{
	
	private Map<String,Object> keyMap;
	
	public IRSAServiceImpl() throws Exception {
		keyMap = RSAHelper.getKeyMap();
	}

	public String getPublicKey() {
		try {
			return RSAHelper.getPublicKey(keyMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPrivateKey() {
		try {
			return RSAHelper.getPrivateKey(keyMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
