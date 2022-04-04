package com.example.productshopxml.dtos.categoryDTOs;

import org.springframework.data.jpa.repository.Query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateCategoriesFactory {

    @XmlElement(name = "category")
    private List<CreateCategoriesDTO> listCategories;

    public List<CreateCategoriesDTO> getListCategories() {
        return listCategories;
    }
}
