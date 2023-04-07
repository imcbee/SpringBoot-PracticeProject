package com.bah.demo.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.bah.demo.domain.Users;
import com.bah.demo.repository.UsersRepository;

@Component
public class MongoInit implements ApplicationRunner {

    @Autowired
    UsersRepository usersRepository;

    /*
     * Spring Boot will call the run method of ApplicationRunners during startup
     * Used here to initialize a dummy user to test the mongoDB connection
     */

    @Override
    public void run(ApplicationArguments args) {
        List<Users> allUsers = usersRepository.findAll();
        if (allUsers != null && allUsers.size() > 0) {
            return;
        }

        Users testUser = new Users(
            "dee11d4e-63c6-4d90-983c-5c9f1e79e96c",
            "cooluser123", 
            "John", 
            "Smith", 
            LocalDate.of(1999, Month.JUNE, 15), 
            "password", 
            LocalDate.of(2023, Month.MARCH, 25), 
            null
        );
        
        testUser = usersRepository.save(testUser);

        System.out.println("Created test User: " + testUser);
    }
    
}
