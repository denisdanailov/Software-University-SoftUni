package com.example.gamestore.entities.dto;

import com.example.gamestore.validations.GameValidation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddGameDTO {
    private String title;
    private BigDecimal price;
    private float size;
    private String trailer;
    private String thumbnail;
    private String description;
    private LocalDate releaseDate;

    public AddGameDTO(String title, BigDecimal price, float size, String trailer, String thumbnail, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnail = thumbnail;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public float getSize() {
        return size;
    }

    public String getTrailer() {
        return trailer;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void validation(){

        GameValidation.validateTitle(title);

        GameValidation.validatePrice(price);

        GameValidation.validateSize(size);

        GameValidation.validateTrailer(trailer);

        GameValidation.validateThumbnail(thumbnail);

        GameValidation.validateDescription(description);
    }
}
