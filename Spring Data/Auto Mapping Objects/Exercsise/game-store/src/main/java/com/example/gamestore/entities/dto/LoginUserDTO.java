package com.example.gamestore.entities.dto;

import com.example.gamestore.validations.UserValidation;

public class LoginUserDTO {
    private String email;
    private String password;

    public LoginUserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void validate() {
        UserValidation.validateEmail(email);

        UserValidation.validatePassword(password);
    }
}
