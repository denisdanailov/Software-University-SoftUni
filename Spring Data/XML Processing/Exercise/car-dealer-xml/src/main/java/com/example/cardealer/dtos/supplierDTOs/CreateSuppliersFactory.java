package com.example.cardealer.dtos.supplierDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateSuppliersFactory {

    @XmlElement(name = "supplier")
    private List<CreateSuppliersDTO> suppliers;

    public List<CreateSuppliersDTO> getSuppliers() {
        return suppliers;
    }
}
