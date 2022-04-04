package com.example.product.shop.dtos.query3;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class CategoryByProductCountDTO {
    @Expose
    private String name;
    @Expose
    private long countProducts;
    @Expose
    private double avgPrice;
    @Expose
    private BigDecimal totalRevenue;

    public CategoryByProductCountDTO(String name, long countProducts, double avgPrice, BigDecimal totalRevenue) {
        this.name = name;
        this.countProducts = countProducts;
        this.avgPrice = avgPrice;
        this.totalRevenue = totalRevenue;
    }

    public String getName() {
        return name;
    }

    public long getCountProducts() {
        return countProducts;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }
}

