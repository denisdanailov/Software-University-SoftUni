package com.example.product.shop.dtos.query1;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductOutputDTO {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    private String sellerFirstName;
    private String sellerLastName;
    @Expose
    private String seller;

    public ProductOutputDTO(String name, BigDecimal price, String sellerFirstName, String sellerLastName) {
        this.name = name;
        this.price = price;
        this.seller = sellerFirstName == null ? sellerLastName : sellerFirstName + " " + sellerLastName;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSeller() {
        return seller;
    }
}
