package com.mortgage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ClientController {
	int ID;
	int loanid;

	@Autowired
	ClientUserService clientUserService;
	@Autowired
	ClientAccountService clientAccountService;

	@RequestMapping("/home")
	public ModelAndView home(ModelAndView model) {
		model.addObject("user", new User());
		model.setViewName("login");
		return model;
	}

	@RequestMapping("/Authenticate")
	public ModelAndView loginAuthrntication(HttpServletRequest request) {
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		int result = clientUserService.login(user);
		ID = result;
		System.out.println(result);
		ModelAndView modelAndView = new ModelAndView();
		if (result != 0) {
			PersonalDetails personalDetails = clientUserService.getdetails(ID);
			if (personalDetails != null) {
			List<Loan> loans = clientAccountService.getloans(ID);
			if (loans.size() == 0) {
				modelAndView.addObject("customer", "New Customer");
			}
			for (Loan loan : loans) {
				if (loan.getStatus().equals("Approved")) {
					if (loan.getLoanamount() > 1000000) {
						modelAndView.addObject("customer", "Existing Premium");
					}

					if (loan.getLoanamount() < 1000000) {
						modelAndView.addObject("customer", "Existing Customer");
					}
				}
			}
			modelAndView.setViewName("dashboard");
			} else {
				PersonalDetails personalDetails2 = new PersonalDetails();
				personalDetails2.setId(ID);
				modelAndView.addObject("personalDetails", personalDetails2);
				modelAndView.setViewName("registerdetails");
			}
		} else {
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@RequestMapping("/registeruserdetails")
	public ModelAndView viewAccounts(@ModelAttribute PersonalDetails personalDetails) {
		ModelAndView model = new ModelAndView();
//		System.out.println(personalDetails.getId());
//		System.out.println("hai");
		ResponseEntity<String> result = clientUserService.registeruserdetails(personalDetails);
		String res = result.getBody();
		if (res.equals("User Details Registered")) {
			model.addObject("user", new User());
			model.setViewName("login");
		} else {
			model.setViewName("registerdetails");
		}
		return model;
	}

	@RequestMapping("/registeruser")
	public ModelAndView register() {
		ModelAndView model = new ModelAndView();
		model.addObject("register", new User());
		model.setViewName("register");
		return model;
	}

	@RequestMapping(value = "/adduserdetails", method = RequestMethod.POST)
	public ModelAndView adduserdetails(HttpServletRequest request) {
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		ResponseEntity<Integer> res = clientUserService.adduserdetails(user);
		int id = res.getBody();
//		System.out.println(id);
		ModelAndView model = new ModelAndView();
		if (id != 0) {
			PersonalDetails personalDetails = new PersonalDetails();
			personalDetails.setId(id);
//			System.out.println(personalDetails.getId());
			model.addObject("personalDetails", personalDetails);
			model.setViewName("registerdetails");
		}
		if (id == 0) {
			model.setViewName("register");
		}

		return model;

	}

	@RequestMapping("/loan")
	public ModelAndView newLoan() {
		ModelAndView modelAndView = new ModelAndView();
		Loan loan = new Loan();
		loan.setId(ID);
		modelAndView.addObject("loan", loan);
		modelAndView.setViewName("loanform");
		return modelAndView;
	}

	@RequestMapping("/applyloan")
	public ModelAndView applyloan(@ModelAttribute Loan loan) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("controller" + loan);
		String id = clientAccountService.applyloan(loan);
		if (id.equals("Loan Applied")) {
			modelAndView.setViewName("dashboard");
		} else {
			Loan loan2 = new Loan();
			loan2.setId(ID);
			modelAndView.addObject("result", id);
			modelAndView.addObject("loan", loan2);
			modelAndView.setViewName("loanform");
		}
		return modelAndView;
	}

	@RequestMapping("/existingloans")
	public ModelAndView getloans() {
		ModelAndView modelAndView = new ModelAndView();
		List<Loan> loans = clientAccountService.getloans(ID);
		modelAndView.addObject("loans", loans);
		modelAndView.setViewName("loans");
		return modelAndView;
	}

	@RequestMapping("/loanamount/{id}")
	public ModelAndView loanAmount(@PathVariable("id") int id) {
		loanid = id;
		int loanamount = clientAccountService.loanamount(id);
		System.out.println(loanamount);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loanamount", loanamount);
		modelAndView.setViewName("loanamount");
		return modelAndView;
	}

	@RequestMapping("/approveloan")
	public ModelAndView approveloan(HttpServletRequest request) {
		System.out.println("fbdsfbdksfd");
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(request.getParameter("requiredamount"));
		System.out.println(request.getParameter("loanamount"));
		int money = Integer.parseInt(request.getParameter("requiredamount"));
		int loanamount = Integer.parseInt(request.getParameter("loanamount"));
		if (loanamount - money >= 0) {
			Loan loan = new Loan();
			loan.setLoanid(loanid);
			loan.setLoanamount(money);
			boolean res = clientAccountService.approveloan(loan);
			if (res == true) {
				modelAndView.setViewName("dashboard");
			}
		} else {
			modelAndView.addObject("result", "Required Amount cannot be Greater than Provided loan Amount");
			modelAndView.addObject("loanamount", loanamount);
			modelAndView.setViewName("loanamount");
		}
		return modelAndView;
	}

}
