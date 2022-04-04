package com.example.gamestore.validations;

import com.example.gamestore.exceptions.ValidationException;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class GameValidation {

    public static void validateTitle(String title){
        if (title.length() < 3 || title.length() > 100 || !Character.isUpperCase(title.toCharArray()[0])) {
            throw new ValidationException("Title must be between 3 and 100 symbols inclusively, " +
                    "and the first letter should be capital letter.");
        }
    }

    public static void validatePrice(BigDecimal price){
        if (price.doubleValue() < 0) {
            throw new ValidationException("Price should be a positive number.");
        }
    }

    public static void validateSize(float size) {
        if (size < 0) {
            throw new ValidationException("Size should be a positive number.");
        }
    }

    public static void validateTrailer(String trailer) {
        if (trailer.length() != 11) {
            throw new ValidationException("Trailer link should only be from Youtube.");
        }
    }

    public static void validateThumbnail(String thumbnail) {
        if (!thumbnail.startsWith("http://") && !thumbnail.startsWith("https://")) {
            throw new ValidationException("Thumbnail should start with http:// or https://");
        }
    }

    public static void validateDescription(String description) {
        if (description.length() < 20) {
            throw new ValidationException("Description should be at least 20 symbols");
        }
    }
}
