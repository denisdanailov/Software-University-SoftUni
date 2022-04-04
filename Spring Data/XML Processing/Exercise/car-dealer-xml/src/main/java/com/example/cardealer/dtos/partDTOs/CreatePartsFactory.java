package com.example.cardealer.dtos.partDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreatePartsFactory {

    @XmlElement(name = "part")
    List<CreatePartDTO> parts;

    public CreatePartsFactory() {
    }

    public List<CreatePartDTO> getParts() {
        return parts;
    }
}
