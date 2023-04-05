package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
