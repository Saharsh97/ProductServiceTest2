package com.scaler.productservicetest.services;

import com.scaler.productservicetest.dtos.FakeStoreProductDTO;
import com.scaler.productservicetest.exceptions.ProductNotFoundException;
import com.scaler.productservicetest.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {

        FakeStoreProductDTO fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDTO.class
        );

        if(fakeStoreProductDto == null) {
            return null;
        }

        return fakeStoreProductDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        FakeStoreProductDTO[] res = restTemplate.getForObject(
                "url",
                FakeStoreProductDTO[].class
        );

        for(FakeStoreProductDTO fs: res) {
            products.add(fs.toProduct());
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDTO fs = new FakeStoreProductDTO();
        fs.setId(product.getId());
        fs.setTitle(product.getTitle());
        fs.setCategory(product.getCategory().getTitle());
        fs.setImage(product.getImageUrl());
        fs.setDescription(product.getDescription());
        fs.setPrice(product.getPrice());

        FakeStoreProductDTO response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fs,
                FakeStoreProductDTO.class
        );

        return response.toProduct();
    }
}
