package com.scaler.productservicetest.controllers;

import com.scaler.productservicetest.dtos.FakeStoreProductDTO;
import com.scaler.productservicetest.dtos.ProductResponseDTO;
import com.scaler.productservicetest.dtos.enums.ResponseStatus;
import com.scaler.productservicetest.models.Product;
import com.scaler.productservicetest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// without Annotation, that this class is actually the controller?
// that this class has the actual APIs that are supposed to be called?
@RestController
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public ProductResponseDTO createProduct(@RequestBody FakeStoreProductDTO fakeStoreProductDTO){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        try {
            Product product = fakeStoreProductDTO.toProduct();
            Product savedProduct = productService.createProduct(product);

            productResponseDTO.setProductDetailsOfDTO(savedProduct);
            productResponseDTO.setMessage("product saved successfully");
            productResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            productResponseDTO.setMessage("got exception in saving product");
            productResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return productResponseDTO;
    }

    @GetMapping("/products/{productId}")
    public ProductResponseDTO getProduct(@PathVariable("productId") Long productId){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        try {
            Product product = productService.getSingleProduct(productId);

            productResponseDTO.setProductDetailsOfDTO(product);
            productResponseDTO.setMessage("product fetched successfully");
            productResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            productResponseDTO.setMessage("got exception in get single product");
            productResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return productResponseDTO;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        try {
            return productService.getAllProducts();
        } catch (Exception e){
            return new ArrayList<>();
        }
    }
}
