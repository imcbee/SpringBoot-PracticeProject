package com.bah.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.bah.demo.service.ProductsService;

@WebMvcTest
public class ProductsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // @MockBean
    // private 

    @MockBean
    private ProductsService productsService;

    @Test
    public void whenGetAllProducts_thenGetAllUsers() throws Exception {
        
    }
}
