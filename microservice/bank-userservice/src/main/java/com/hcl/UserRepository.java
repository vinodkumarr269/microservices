package com.hcl;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
public User getUserByusername(String Name);
}
