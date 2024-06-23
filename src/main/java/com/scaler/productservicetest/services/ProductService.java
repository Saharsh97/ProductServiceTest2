package com.scaler.productservicetest.services;

import com.scaler.productservicetest.models.Product;

import java.util.List;

// whichever ProductService I will use, I only care about the 3 methods.
// In the perspective of the controller, does it care who handles the real logic.
// controller should just send the request to Service, and let the service handle the work.

// Restaurant example.
// I went the extra mile, to create this.
// create a separate project.
// also explain IoC using chef example.

// today you have a local chef.
// tomorrow you have Gordon Ramsay.
// the waiter really cares that whoever is the chef, they should know how to cook kadhai paneer or butter chicken.
// so we have an interface chef.
// methods, cook kadhaiPaneer, mixVeg, manchurian
// implementations are, DhabaChef   -> his own way of cooking
// implementation, SuperChef        -> his own way of cooking
// implementation, GordonRamsay     -> his own way of cooking

// for the chef, he just needs to Pass the request to a CHEF.



public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(Long id);
    Product createProduct(Product product);
}
