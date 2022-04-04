package com.example.cardealer.dtos.carDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateCarFactory {

    @XmlElement(name = "car")
    private List<CreateCarDTO> cars;

    public CreateCarFactory() {
    }

    public CreateCarFactory(List<CreateCarDTO> cars) {
        this.cars = cars;
    }

    public List<CreateCarDTO> getCars() {
        return cars;
    }
}
