package com.hcl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountRepositary extends CrudRepository<Account, Integer> {
		
	public Account getAccountByuserid(int userid);
}
