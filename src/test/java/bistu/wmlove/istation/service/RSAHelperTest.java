package bistu.wmlove.istation.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Map;

import org.junit.Test;

import bistu.wmlove.istation.security.rsa.RSAHelper;

public class RSAHelperTest {

	
	@Test
	public void testRSAHelper() throws Exception
	{
		Map<String,Object> keymap = RSAHelper.getKeyMap();
		String pubkey = RSAHelper.getPublicKey(keymap);
		String data = new String("{name:hqy}");
		byte[] encryContent = RSAHelper.encryptByPublicKey(data.getBytes(), pubkey);
		System.out.println("rsa data: " + data);
		System.out.println("rsa encodeContent: " + new String(encryContent));
		
		String privateKey = RSAHelper.getPrivateKey(keymap);
		byte[] decryContent = RSAHelper.decryptByPrivateKey(encryContent, privateKey);
		System.out.println("rsa decodeContent: " + decryContent);
		System.out.println("rsa data: " + new String(decryContent));
//		assert (data == new String(decryContent));
		
		Claims claims = Jwts.parser()
                .setSigningKey("secret-key")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInVzZXJfaWQiOjEsInNjb3BlIjpbIlJPTEVfVVNFUiJdLCJub25fZXhwaXJlZCI6dHJ1ZSwiZXhwIjoxNTIxMzQ4NDU4LCJpYXQiOjE1MjEzNDgzOTgsImVuYWJsZWQiOnRydWUsIm5vbl9sb2NrZWQiOnRydWUsImp0aSI6ImQwNmE1MTMxLWVjOTktNGZlMC1iZTMzLTI3MjVlZTIwZjE4ZSJ9.MSchvB5VotaAHii4R-8_A29qKRdgY4IKLUdTCkxFfoY")
                .getBody();
		System.out.println(claims.values());
		System.out.println(claims.getSubject());
		System.out.println(claims.getIssuer());
	}
}
