package com.hcl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class AccountService {
	@Autowired
	AccountRepositary ar;
	public String addAcount(Account account) {
		Account a=ar.save(account);
		return "Account Saved";
	}
	public List<Account> getAllAccounts(){
		List<Account> lst=(List<Account>) ar.findAll();
		return lst;
	}
	public Account getAccount(int userid) {
		Optional<Account> a=ar.findById(userid);
		return a.get();
	}
	public Account getAccountByUserId(int userid) {
		Account a=ar.getAccountByuserid(userid);
		return a;
	}
	public String deleteAccountByaccountnum(int accountnum) {
		ar.deleteById(accountnum);
		return "account deleted";
	}


}
