package com.poozer.repositories;


import org.springframework.data.repository.CrudRepository;

import com.poozer.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
