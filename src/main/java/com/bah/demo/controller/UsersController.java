package com.bah.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.demo.domain.Users;
import com.bah.demo.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    @Autowired
    UsersService usersService;

    @GetMapping
    public List<Users> getAll() {
        return usersService.getAll();
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user, UriComponentsBuilder uri) {
        // get user from request (json is mapped by spring to our domain class)
        // call the service method to save our user to the mongo db
        user = usersService.createUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        // create the response entity with the 201 created status and a location header
        ResponseEntity<Users> response = ResponseEntity.created(location).build();
        // return http response
        return response;
    }

}
