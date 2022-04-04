package com.example.productshopxml.dtos.userDTOs;

import com.example.productshopxml.dtos.productDTOs.ExportedProductDTO;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSuccessfulSaleDTO {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private List<ExportedProductDTO> sellingItems;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSellingItems(List<ExportedProductDTO> sellingItems) {
        this.sellingItems = sellingItems;
    }
}
