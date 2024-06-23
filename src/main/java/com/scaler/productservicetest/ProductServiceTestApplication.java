package com.scaler.productservicetest;

import com.scaler.productservicetest.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceTestApplication {

    public static void main(String[] args) {
//        Product p = new Product();
//        p.title;
//  make Product public.
//        p.title works
//  now create getters and setters.
//        p.getTitle();
//        p.setId();
//  It ensures what all you want give permission to change
//  we dont want to change the age, or change the id.
        SpringApplication.run(ProductServiceTestApplication.class, args);
    }

}
