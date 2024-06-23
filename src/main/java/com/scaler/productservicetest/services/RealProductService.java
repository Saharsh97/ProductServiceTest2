package com.scaler.productservicetest.services;

import com.scaler.productservicetest.models.Product;

import java.util.List;

public class RealProductService implements ProductService{
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
