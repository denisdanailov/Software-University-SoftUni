package com.example.product.shop.dtos.seedingDTOs;

import com.example.product.shop.exceptions.ValidationException;

public class UserInputDTO {

    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void validate(){
        if (lastName.length() < 3) {
            throw new ValidationException("User's last name should be at least 3 characters long.");
        }
    }
}
