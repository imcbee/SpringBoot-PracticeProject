package com.bah.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.demo.domain.Reviews;
import com.bah.demo.exception.ReviewNotFoundException;
import com.bah.demo.repository.ReviewsRepository;

@Service
public class ReviewsServiceImp implements ReviewsService {
    @Autowired
    ReviewsRepository reviewRepo;

    /* Get all reviews */
    @Override
    public List<Reviews> getAll() {
        return reviewRepo.findAll();
    }
    
    /* get review by id */
    @Override
    public Reviews getById(String id) throws ReviewNotFoundException {
        return reviewRepo.findById(id).orElseThrow(() -> new ReviewNotFoundException(id));
    }
    
    /* create reviews */
    @Override
    public Reviews createReview(Reviews review) {
        return reviewRepo.save(review);
    }
}
