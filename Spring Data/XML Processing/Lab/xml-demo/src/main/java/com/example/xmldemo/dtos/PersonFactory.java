package com.example.xmldemo.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "people")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonFactory {

    @XmlElement(name = "person")
    List<OutputPersonDTO> people = new ArrayList<>();

    public PersonFactory() {
    }

    public PersonFactory(List<OutputPersonDTO> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "PersonFactory{" +
                "people=" + people +
                '}';
    }
}
