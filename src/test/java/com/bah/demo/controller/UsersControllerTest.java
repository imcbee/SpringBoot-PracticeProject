package com.bah.demo.controller;

import static org.mockito.Mockito.when;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.bah.demo.domain.Users;
import com.bah.demo.service.UsersService;

@WebMvcTest(UsersController.class)
public class UsersControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsersService usersService;

    @Test
    public void whenGetAllUsers_thenGetAllUsersFromMongo() throws Exception {
        List<Users> usersList = new ArrayList<>();
        usersList.add(
            new Users(
                "dee11d4e-63c6-4d90-983c-5c9f1e79e96c",
                "cooluser123", 
                "John", 
                "Smith", 
                LocalDate.of(1999, Month.JUNE, 15), 
                "password", 
                LocalDate.of(2023, Month.MARCH, 25), 
                null
            )
        );

        when(usersService.getAll()).thenReturn(usersList);

        mockMvc.perform(get("/users"))
            .andDo(print())
            .andExpect(status().isOk());
    }

}
