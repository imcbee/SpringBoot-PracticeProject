package com.bah.demo.controller;

import static org.mockito.Mockito.when;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
import com.bah.demo.dto.Mapper;
import com.bah.demo.exception.UserNotFoundException;
import com.bah.demo.service.UsersService;

@WebMvcTest(UsersController.class)
public class UsersControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Mapper mapper;

    @MockBean
    private UsersService usersService;

    @Test
    public void whenGetAllUsers_thenGetAllUsers() throws Exception {
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
        usersList.add(
            new Users(
                "abc11d4e-63c6-4d90-983c-5c9f1e79e123",
                "cooleruser123", 
                "Jane", 
                "Baker", 
                LocalDate.of(2001, Month.MARCH, 21), 
                "password1", 
                LocalDate.of(2023, Month.MARCH, 28), 
                null
            )
        );

        when(usersService.getAll()).thenReturn(usersList);

        mockMvc.perform(get("/users"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(2));
    }    
        
    @Test
    public void whenGetUserById_thenGetUser() throws Exception {
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
        usersList.add(
            new Users(
                "abc11d4e-63c6-4d90-983c-5c9f1e79e123",
                "cooleruser123", 
                "Jane", 
                "Baker", 
                LocalDate.of(2001, Month.MARCH, 21), 
                "password1", 
                LocalDate.of(2023, Month.MARCH, 28), 
                null
            )
        );

        when(usersService.getById("dee11d4e-63c6-4d90-983c-5c9f1e79e96c")).thenReturn(usersList.get(0));

        mockMvc.perform(get("/users/dee11d4e-63c6-4d90-983c-5c9f1e79e96c"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value("dee11d4e-63c6-4d90-983c-5c9f1e79e96c"))
            .andExpect(jsonPath("$.firstName").value("John"))
            .andExpect(jsonPath("$.lastName").value("Smith"));
    }

    @Test
    public void whenGetUserWithBadId_thenGetNotFound() throws Exception {
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

        when(usersService.getById("nonexistent-id")).thenThrow(new UserNotFoundException("nonexistent-id"));

        mockMvc.perform(get("/users/nonexistent-id"))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

}
