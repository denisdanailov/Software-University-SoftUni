package com.example.productshopxml.dtos.categoryDTOs;


import com.example.productshopxml.exceptions.ValidationException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateCategoriesDTO {

    @XmlElement(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void validate(){
        if (name.length() < 3 || name.length() > 15) {
            throw new ValidationException("Category name should be between 3 and 15 characters long inclusive");
        }
    }
}
