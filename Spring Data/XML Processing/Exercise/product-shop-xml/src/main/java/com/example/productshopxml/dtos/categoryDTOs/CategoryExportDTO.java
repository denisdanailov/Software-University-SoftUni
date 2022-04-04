package com.example.productshopxml.dtos.categoryDTOs;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryExportDTO {
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "products-count")
    private long count;
    @XmlElement(name = "average-price")
    private double avgPrice;
    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;

    public CategoryExportDTO() {
    }

    public CategoryExportDTO(String name, long count, double avgPrice, BigDecimal totalRevenue) {
        this.name = name;
        this.count = count;
        this.avgPrice = avgPrice;
        this.totalRevenue = totalRevenue;
    }
}
