package com.learning.rest.webservice.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthenticationController {
	
	
	//hello-world-bean
	@GetMapping("/basicauth")
	public AuthenticationBean authenticationBean() {
		return new AuthenticationBean("You are authenticated!!");
	}
	
	
	

}
