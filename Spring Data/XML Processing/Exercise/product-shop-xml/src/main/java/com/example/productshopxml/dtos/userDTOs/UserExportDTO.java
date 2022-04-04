package com.example.productshopxml.dtos.userDTOs;

import com.example.productshopxml.dtos.productDTOs.ProductFactoryDTO;
import com.example.productshopxml.dtos.productDTOs.ProductNameAndPriceDTO;
import com.example.productshopxml.dtos.productDTOs.ProductNamePriceSellerNameDTO;
import com.example.productshopxml.entities.Product;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserExportDTO {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute
    private Integer age;

    @XmlTransient
    private List<ProductNameAndPriceDTO> sellingItems;

    @XmlElement(name = "sold-products")
    private ProductFactoryDTO productFactoryDTO;

    public void setProductFactoryDTO() {
        this.productFactoryDTO = new ProductFactoryDTO(this.sellingItems);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSellingItems(List<ProductNameAndPriceDTO> sellingItems) {
        this.sellingItems = sellingItems;
    }
}
