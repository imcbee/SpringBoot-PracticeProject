package com.bah.demo.service;

import java.util.List;

import com.bah.demo.domain.Users;

public interface UsersService {

    public List<Users> getAll();

    public Users getById(String id);
    
    public Users createUser(Users user);

    public Users updateUser(Users user);

    public void deleteById(String id);
}
