package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.Reviews;

public interface ReviewsRepository extends MongoRepository <Reviews, Long> {

}
