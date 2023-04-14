package com.bah.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.demo.domain.Users;
import com.bah.demo.dto.Mapper;
import com.bah.demo.dto.UsersDto;
import com.bah.demo.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    @Autowired
    UsersService usersService;

    @Autowired
    Mapper mapper;

    @GetMapping
    public ResponseEntity<List<Users>> getAll() {
        return new ResponseEntity<>(usersService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getById(@PathVariable String id) {
        Users user = usersService.getById(id);
        
        return new ResponseEntity<>(user, HttpStatus.OK);
    }    

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody Users user, UriComponentsBuilder uri) {
        // get user from request (json is mapped by spring to our domain class)
        // call the service method to save our user to the mongo db
        user = usersService.createUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getId())
            .toUri();
        // create the response entity with the 201 created status and a location header
        ResponseEntity<Void> response = ResponseEntity.created(location).build();
        // return http response
        return response;
    }    
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable String id, @RequestBody Users user, UriComponentsBuilder uri) {
        user.setId(id);
        user = usersService.updateUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        ResponseEntity<Void> response = ResponseEntity
            .ok()
            .header("location", location.toString())
            .build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        usersService.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
    //! --------------------------- DTO Experimenting ---------------------------    
    @GetMapping("/dto/{id}")
    public ResponseEntity<UsersDto> getDtoById(@PathVariable String id) {
        Users user = usersService.getById(id);
        
        UsersDto usersDto = mapper.toDto(user);

        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<UsersDto>> getAllDto() {
        List<Users> users = usersService.getAll();

        List<UsersDto> userDtos = users.stream()
            .map(mapper::toDto)
            .toList();
        
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }
    //! --------------------------- DTO Experimenting ---------------------------

}
