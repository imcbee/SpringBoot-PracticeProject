package com.bah.demo.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.bah.demo.domain.Users;
import com.bah.demo.repository.UsersRepository;

public class UsersServiceImpl implements UsersService {
    
    @Autowired
    UsersRepository userRepo;

    //! --------------------------- getAll ---------------------------
    public List<Users> getAll() {
        return userRepo.findAll();
    }

    //! --------------------------- getAll ---------------------------
}
