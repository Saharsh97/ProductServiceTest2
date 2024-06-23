package com.scaler.productservicetest.dtos;


import com.scaler.productservicetest.dtos.enums.ResponseStatus;
import com.scaler.productservicetest.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Long productId;
    private String productName;
    private String productDescription;
    private Double productPrice;

    private String message;
    private ResponseStatus responseStatus;

    public void setProductDetailsOfDTO(Product product){
        productId = product.getId();
        productName = product.getTitle();
        productDescription = product.getDescription();
        productPrice = product.getPrice();
    }
}
