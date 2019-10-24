package com.bank;

import java.util.List;

public interface ClientAccountService {
	public List<Account> getAll();
	
	public String addAccount(Account accounts);
	
	public String deleteAccount(int accountnum);
	
	public Account getAccount(int accountnum);
}
