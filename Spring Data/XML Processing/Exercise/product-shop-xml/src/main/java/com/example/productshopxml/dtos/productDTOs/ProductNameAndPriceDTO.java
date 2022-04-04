package com.example.productshopxml.dtos.productDTOs;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
public class ProductNameAndPriceDTO {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private BigDecimal price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
