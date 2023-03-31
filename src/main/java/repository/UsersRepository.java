package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.Users;


public interface UsersRepository extends MongoRepository <Users, Long> {
	
}
