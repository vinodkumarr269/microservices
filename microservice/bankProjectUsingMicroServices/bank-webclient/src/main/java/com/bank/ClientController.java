package com.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ClientController {

	@Autowired
	ClientUserService clientUserService;
	ClientAccountService cas;
	
	@RequestMapping("/home")
	public ModelAndView home(ModelAndView model) {
		model.addObject("user" , new User());
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping("/Authenticate")
	public ModelAndView loginAuthrntication(@ModelAttribute User user) {
		String result = clientUserService.login(user);
		if (result.equals("Login Successfull")) {
			return new ModelAndView("accounthome");
		}
		if (result.equals("Invalid Credentials")) {
			return new ModelAndView("login");
		} return null;
			
	}
	@RequestMapping("/getAccount/{accountnum}")
	public String accountDetails(@RequestParam("accountnum") int accountnum, Model model) {
		model.addAttribute("account", cas.getAccount(accountnum));
		return "accountDetails";
	}
	@RequestMapping("/register")
	public ModelAndView registerUser (@ModelAttribute User register1) {
		
	
		ModelAndView mv  =  new ModelAndView();
		mv.setViewName("register");
		return mv;
		
	}
	
		
}
