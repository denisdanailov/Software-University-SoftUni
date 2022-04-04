package com.example.productshopxml.dtos.categoryDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesExportFactory {

    @XmlElement(name = "category")
    private List<CategoryExportDTO> categories;

    public CategoriesExportFactory() {
    }

    public CategoriesExportFactory(List<CategoryExportDTO> categories) {
        this.categories = categories;
    }
}
