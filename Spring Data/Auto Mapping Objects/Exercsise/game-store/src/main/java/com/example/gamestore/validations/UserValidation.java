package com.example.gamestore.validations;

import com.example.gamestore.exceptions.ValidationException;

public class UserValidation {

    public static void validateEmail(String email) {
        if (email.lastIndexOf("@") < 0 || email.lastIndexOf(".") < 0 ||
                email.lastIndexOf("@") > email.lastIndexOf(".")) {
            throw new ValidationException("Error: Email should be in format <name>@<org>.<domain>");
        }
    }

    public static void validatePassword(String password) {
        if (password.length() < 6) {
            throw new ValidationException("Error: Password should be at least 6 symbols long");
        }

        validateHasUpperCase(password);
        validateHasLowerCase(password);
        validateHasDigit(password);
    }

    private static void validateHasUpperCase(String charArray) {
        boolean hasUpper = false;
        for (char symbol : charArray.toCharArray()) {
            if (Character.isUpperCase(symbol)) {
                hasUpper = true;
                break;
            }
        }

        if(!hasUpper) {
            throw new ValidationException("Error: Password should contain at least one upper case.");
        }
    }

    private static void validateHasLowerCase(String charArray) {
        boolean hasLower = false;
        for (char symbol : charArray.toCharArray()) {
            if (Character.isLowerCase(symbol)) {
                hasLower = true;
                break;
            }
        }

        if(!hasLower) {
            throw new ValidationException("Error: Password should contain at least one lower case.");
        }
    }

    private static void validateHasDigit(String charArray) {
        boolean hasDigit = false;
        for (char symbol : charArray.toCharArray()) {
            if (Character.isDigit(symbol)) {
                hasDigit = true;
                break;
            }
        }

        if(!hasDigit) {
            throw new ValidationException("Error: Password should contain at least one digit.");
        }
    }

    public static void validateConfirmationPassword(String password, String confirmPass) {
        if (!password.equals(confirmPass)) {
            throw new ValidationException("Error: Passwords don't match.");
        }
    }
}
