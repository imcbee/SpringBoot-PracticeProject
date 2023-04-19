package com.bah.demo.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.bah.demo.domain.Products;
import com.bah.demo.domain.Users;
import com.bah.demo.repository.ProductsRepository;
import com.bah.demo.repository.UsersRepository;

@Component
public class MongoInit implements ApplicationRunner {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ProductsRepository productsRepository;

    /*
     * Spring Boot will call the run method of ApplicationRunners during startup
     * Used here to initialize a dummy user to test the mongoDB connection
     */

    @Override
    public void run(ApplicationArguments args) {
        // /* comment this section out to always create test user/product
        List<Users> allUsers = usersRepository.findAll();
        if (allUsers != null && allUsers.size() > 0) {
            return;
        }
        // */

        // create a test product
        Products product = new Products(
                null, // "dee11d4e-63c6-4d90-983c-testDBrefprod",
                "Hose",
                "allows water to travel",
                "Outdoor",
                null,
                true,
                10.25,
                null,
                null,
                null,
                null);

        // save the product to the mongodb
        product = productsRepository.save(product);

        // list of test products
        List<Products> productsList = new ArrayList<>();
        productsList.add(product);

        // create a test user
        Users testUser = new Users(
                null, // "dee11d4e-63c6-4d90-983c-testDBrefuser",
                "cooluser123",
                "John",
                "Smith",
                LocalDate.of(1999, Month.JUNE, 15),
                "password",
                LocalDate.of(2023, Month.MARCH, 25),
                productsList // test products
        );

        testUser = usersRepository.save(testUser); // save user to db (and hopefully the associated products)

        System.out.println("Created test User: " + testUser);

        // get all user objects from mongo then
        // print out all user objects that have products
        usersRepository.findAll().stream()
                .filter(user -> user.getProducts() != null)
                .forEach(user -> highlightPrintPojo(user));

    }

    private void highlightPrintPojo(Object pojo) {
        System.out.println("\n===== " + pojo.getClass().getName() + " =====");
        System.out.println(pojo);
        System.out.println("===== /" + pojo.getClass().getName() + " =====\n");
    }

}
