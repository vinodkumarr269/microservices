package com.hcl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  {
	
@Autowired
UserRepository userRep;
	
	public User getUser(String name) {
     
		return userRep.getUserByusername(name);
	}

}
