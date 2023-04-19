package com.bah.demo.service;

import java.util.List;

import com.bah.demo.domain.Reviews;


public interface ReviewsService {
    public List<Reviews> getAll();

    public Reviews getById(String id);
    
    public Reviews createReview(Reviews review);
}
