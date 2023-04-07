package com.bah.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.demo.domain.Users;
import com.bah.demo.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
    
    @Autowired
    UsersRepository userRepo;

    //! --------------------------- getAll ---------------------------
    public List<Users> getAll() {
        return userRepo.findAll();
    }

    //! --------------------------- getAll ---------------------------

    //! --------------------------- createUser ---------------------------
    public Users createUser(Users user) {
        return userRepo.save(user);
    }
    //! --------------------------- createUser ---------------------------
}
