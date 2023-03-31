package com.bah.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bah.demo.domain.Users;


public interface UsersRepository extends MongoRepository <Users, Long> {
	
}
