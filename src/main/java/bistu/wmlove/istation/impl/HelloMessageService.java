package bistu.wmlove.istation.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import bistu.wmlove.istation.service.MessageService;

@Service("messageService")
public class HelloMessageService implements MessageService{

	@PreAuthorize("authenticated")
	@Override
	public String getMessage() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		return "Hello " + authentication;
	}
	
}
