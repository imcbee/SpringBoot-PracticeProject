package com.bah.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.demo.domain.Users;
import com.bah.demo.exception.UserNotFoundException;
import com.bah.demo.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
    
    @Autowired
    UsersRepository userRepo;

    //! --------------------------- getAll ---------------------------
    @Override
    public List<Users> getAll() {
        return userRepo.findAll();
    }

    //! --------------------------- /getAll ---------------------------

    //! --------------------------- getById ---------------------------
    @Override
    public Users getById(String id) throws UserNotFoundException {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
    //! --------------------------- /getById ---------------------------

    //! --------------------------- createUser ---------------------------
    @Override
    public Users createUser(Users user) {
        return userRepo.save(user);
    }
    //! --------------------------- /createUser ---------------------------
}
