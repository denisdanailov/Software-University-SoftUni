package com.example.productshopxml.dtos.productDTOs;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductNamePriceSellerNameDTO {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private BigDecimal price;

    @XmlAttribute(name = "seller")
    private String sellerName;

    @XmlTransient
    private String sellerFirstName;

    @XmlTransient
    private String sellerLastName;

    public ProductNamePriceSellerNameDTO() {
    }

    public ProductNamePriceSellerNameDTO(String name, BigDecimal price, String sellerFirstName, String sellerLastName) {
        this.name = name;
        this.price = price;
        this.sellerName = sellerFirstName == null ? sellerLastName : sellerFirstName + " " + sellerLastName;
    }
}
