package com.bank;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dinesh.Rajput
 *
 */
public class RemoteAccountRepository implements ClientAccountService {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl1;
	public Account account;
	
	public RemoteAccountRepository(String serviceUrl) {
		this.serviceUrl1 = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl1;
	}

	@Override
	public String addAccount(Account accounts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAccount(int accountnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(int accountnum) {
		Account acc =  restTemplate.getForObject(serviceUrl1 + "/account/" + "/get" + account.getAccountnum() ,Account.class, accountnum);
		return null;
	}

	@Override
	public List<Account> getAll() {
//	List<Accounts> user2 =  restTemplate.getForObject(serviceUrl1 + "/account/"  + "/getAll",User.class, );
		return null;
	}
}
