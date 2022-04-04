package com.example.football.models.dto.xml;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateStatDTO {
    @XmlElement
    @Positive
    private double passing;
    @XmlElement
    @Positive
    private double shooting;
    @XmlElement
    @Positive
    private double endurance;

//    public boolean validate() {
//        if (passing <= 0 || shooting <= 0 || endurance <= 0) {
//            return false;
//        }
//
//        return true;
//    }


    public double getPassing() {
        return passing;
    }

    public double getShooting() {
        return shooting;
    }

    public double getEndurance() {
        return endurance;
    }
}
