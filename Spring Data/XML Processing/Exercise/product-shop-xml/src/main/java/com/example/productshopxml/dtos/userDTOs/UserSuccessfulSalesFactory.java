package com.example.productshopxml.dtos.userDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSuccessfulSalesFactory {

    @XmlElement(name = "user")
    private List<UserSuccessfulSaleDTO> users;

    public UserSuccessfulSalesFactory() {
    }

    public UserSuccessfulSalesFactory(List<UserSuccessfulSaleDTO> users) {
        this.users = users;
    }
}
