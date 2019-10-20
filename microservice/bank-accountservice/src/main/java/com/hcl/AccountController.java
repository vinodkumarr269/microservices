package com.hcl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value="/account")

public class AccountController {
@Autowired
AccountService as;
@PostMapping(value="/add")
public String addAccount(@RequestBody Account account ) {
	return as.addAcount(account);
}
@RequestMapping(value="/getAll")
public List<Account> getAllAccounts(){
	return as.getAllAccounts();
}
@RequestMapping(value="get/{userid}")
public Account getAccountByUser(@PathVariable int userid) {
	return as.getAccountByUserId(userid);
}
@DeleteMapping(value="delete/{accountnum}")
public String deleteAccountByaccountnum(@PathVariable int accountnum) {
	return as.deleteAccountByaccountnum(accountnum);
}
}
