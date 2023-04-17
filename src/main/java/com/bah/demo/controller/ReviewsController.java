package com.bah.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.demo.domain.Reviews;
import com.bah.demo.domain.ReviewsDto;
import com.bah.demo.dto.Mapper;
import com.bah.demo.service.ReviewsService;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

	@Autowired
	ReviewsService reviewsService;

	@Autowired
	Mapper mapper;

	@GetMapping
    public List<Reviews> getAll() {
		
        return reviewsService.getAll();   

    }

	@GetMapping("/{id}")
	public ResponseEntity<Reviews> getById(@PathVariable String id) {
		Reviews review = reviewsService.getById(id);

		return new ResponseEntity<>(review, HttpStatus.OK);
	}

	@GetMapping("/dto/{id}")
	public ResponseEntity<ReviewsDto> getDtoById(@PathVariable String id) {
		Reviews review = reviewsService.getById(id);

		ReviewsDto reviewsDto = mapper.toDto(review);

		return new ResponseEntity<>(reviewsDto, HttpStatus.OK);
	}

	@GetMapping("/dto")
	public ResponseEntity<List<ReviewsDto>> getAllDto() {
		List<Reviews> reviews = reviewsService.getAll();

		List<ReviewsDto> reviewsDtos = reviews.stream().map(mapper::toDto).toList();

		return new ResponseEntity<>(reviewsDtos, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Reviews> createReviews(@RequestBody Reviews review, UriComponentsBuilder uri) {

		review = reviewsService.createReview(review);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(review.getId())
				.toUri();
		/* Create the response entity with the 201 created status and a location header */
		ResponseEntity<Reviews> response = ResponseEntity.created(location).build();
		/* return http response */
		return response;
	}

}
