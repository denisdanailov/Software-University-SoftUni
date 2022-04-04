package com.example.productshopxml.dtos.productDTOs;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductFactoryDTO {

    @XmlAttribute
    private int count;

    @XmlElement(name = "product")
    private List<ProductNameAndPriceDTO> sellingItems;

    public ProductFactoryDTO() {
    }

    public ProductFactoryDTO(List<ProductNameAndPriceDTO> sellingItems) {
        this.sellingItems = sellingItems;
        this.count = this.sellingItems.size();
    }
}
