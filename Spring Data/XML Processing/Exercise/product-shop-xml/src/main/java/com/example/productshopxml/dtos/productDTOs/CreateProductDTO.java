package com.example.productshopxml.dtos.productDTOs;

import com.example.productshopxml.exceptions.ValidationException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateProductDTO {

    private String name;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void validate(){
        if (name.length() < 3) {
            throw new ValidationException("Product name should be at least 3 characters long.");
        }
    }
}
