package com.example.product.shop.dtos.query2;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class SuccessfullySoldProductDTO {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String sellerFirstName;
    @Expose
    private String sellerLastName;

    public SuccessfullySoldProductDTO() {
    }

    public SuccessfullySoldProductDTO(String name, BigDecimal price, String sellerFirstName, String sellerLastName) {
        this.name = name;
        this.price = price;
        this.sellerFirstName= sellerFirstName;
        this.sellerLastName = sellerLastName;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSellerFirstName() {
        return sellerFirstName;
    }

    public void setSellerFirstName(String sellerFirstName) {
        this.sellerFirstName = sellerFirstName;
    }

    public String getSellerLastName() {
        return sellerLastName;
    }

    public void setSellerLastName(String sellerLastName) {
        this.sellerLastName = sellerLastName;
    }
}
