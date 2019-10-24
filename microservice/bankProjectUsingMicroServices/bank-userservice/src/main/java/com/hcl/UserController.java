package com.hcl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserServiceImpl userService;
	@RequestMapping(value="/{name}/get")
	public User getUserByusername(@PathVariable("name") String name) {
		return userService.getUser(name);
	}

}
