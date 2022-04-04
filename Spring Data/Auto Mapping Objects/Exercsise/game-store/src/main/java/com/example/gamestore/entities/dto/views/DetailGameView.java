package com.example.gamestore.entities.dto.views;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetailGameView {
    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public DetailGameView(String title, BigDecimal price, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return String.format("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s%n",
                this.title,
                this.price,
                this.description,
                this.releaseDate.toString());
    }
}
