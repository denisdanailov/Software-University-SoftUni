package com.example.gamestore.entities.dto.views;

import java.math.BigDecimal;

public class AllGamesView {
    private String title;
    private BigDecimal price;

    public AllGamesView(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", title, price);
    }
}
