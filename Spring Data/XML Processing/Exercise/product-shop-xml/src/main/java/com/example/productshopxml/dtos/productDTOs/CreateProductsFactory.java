package com.example.productshopxml.dtos.productDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateProductsFactory {

    @XmlElement(name = "product")
    private List<CreateProductDTO> products;

    public List<CreateProductDTO> getProducts() {
        return products;
    }
}
