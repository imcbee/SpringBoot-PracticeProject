package com.bah.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bah.demo.domain.Reviews;

public interface ReviewsRepository extends MongoRepository <Reviews, Long> {

}
