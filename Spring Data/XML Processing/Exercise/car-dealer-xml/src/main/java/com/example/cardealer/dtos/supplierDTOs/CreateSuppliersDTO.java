package com.example.cardealer.dtos.supplierDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateSuppliersDTO {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "is-importer")
    private Boolean isImporter;

    public String getName() {
        return name;
    }

    public Boolean getImporter() {
        return isImporter;
    }

    public void setImporter(Boolean isImporter) {
        isImporter = isImporter;
    }
}
