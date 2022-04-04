package com.example.product.shop.dtos.seedingDTOs;

import com.example.product.shop.exceptions.ValidationException;

public class CategoriesInputDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void validate(){
        if (name.length() < 3 || name.length() > 15) {
            throw new ValidationException("Category name should be between 3 and 15 characters long inclusive");
        }
    }
}
