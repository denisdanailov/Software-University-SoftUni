package com.example.cardealer.dtos.customerDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerFactoryDTO {

    @XmlElement(name = "customer")
    private List<CreateCustomerDTO> customers;

    public List<CreateCustomerDTO> getCustomers() {
        return customers;
    }
}
