package com.example.cardealer.dtos.carDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateCarDTO {
    @XmlElement
    private String make;

    @XmlElement
    private String model;

    @XmlElement(name = "travelled-distance")
    private long travelledDistance;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getTravelledDistance() {
        return travelledDistance;
    }
}
