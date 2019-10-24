package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;



/**
 * @author Dinesh.Rajput
 *
 */
public class RemoteUserRepository implements ClientUserService {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemoteUserRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	@Override
	public String login(User user) {
		User user2 =  restTemplate.getForObject(serviceUrl + "/user/" + user.getUsername() + "/get",User.class, user);
		//System.out.println(user2.getUsername());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		//System.out.println(user2.getPassword());
		if (user2 != null && user.getUsername().equals(user2.getUsername()) && user.getPassword().equals(user2.getPassword())) {
			return "Login Successfull"; 
		} else {
			return "Invalid Credentials";
		}
	}
	public String register() {
		return serviceUrl;
		}
	}
