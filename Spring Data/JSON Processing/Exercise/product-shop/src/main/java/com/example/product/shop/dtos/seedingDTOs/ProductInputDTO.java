package com.example.product.shop.dtos.seedingDTOs;

import com.example.product.shop.exceptions.ValidationException;

import java.math.BigDecimal;

public class ProductInputDTO {
    private String name;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void validate(){
        if (name.length() < 3) {
            throw new ValidationException("Product name should be at least 3 characters long.");
        }
    }
}
