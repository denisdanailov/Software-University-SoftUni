package com.example.cardealer.dtos.customerDTOs;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateCustomerDTO {

    @XmlAttribute
    private String name;

    @XmlElement(name = "birth-date")
    private String dateOfBirth;

    @XmlElement(name = "is-young-driver")
    private Boolean isYoungDriver;

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Boolean getYoungDriver() {
        return isYoungDriver;
    }
}
