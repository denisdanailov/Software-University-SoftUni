package com.example.gamestore.entities.dto;

import com.example.gamestore.validations.UserValidation;

public class RegisterUserDTO {
    private String email;
    private String password;
    private String confirmPass;
    private String fullName;

    public RegisterUserDTO(String fullName, String email, String password, String confirmPass) {
        this.email = email;
        this.password = password;
        this.confirmPass = confirmPass;
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public String getFullName() {
        return fullName;
    }

    //Todo
    public void validate() {

        UserValidation.validateEmail(email);

        UserValidation.validatePassword(password);

        UserValidation.validateConfirmationPassword(password, confirmPass);
    }


}
