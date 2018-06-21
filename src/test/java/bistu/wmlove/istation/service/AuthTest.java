package bistu.wmlove.istation.service;

import org.springframework.util.Base64Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class AuthTest {

	public static void main(String[] args) {
		String path = "de1acb72e08f67c92dc29adb32dc5e31.jpg";
		String [] arr = path.split("\\.");
		System.out.println(arr[0]);
	}
}
