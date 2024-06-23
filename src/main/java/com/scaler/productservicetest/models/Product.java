package com.scaler.productservicetest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// command + n, getter and setter.
// this is tedious to read, and these are very very basic functions.
// lets make the file clean,
// and tell Spring to create all the Getter and Setters for all attributes.
@Getter
@Setter
// now go to main, and try the getter setter methods.


// if we dont create a constructor by ourself,
// then we have default constructor.
// but if we create anyone single constructor, then the default is gone.
// show on main class.
// create both types of constructor.
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private Double price;
    private Category category;
}
