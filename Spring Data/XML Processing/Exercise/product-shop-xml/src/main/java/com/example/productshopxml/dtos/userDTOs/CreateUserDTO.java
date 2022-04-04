package com.example.productshopxml.dtos.userDTOs;

import com.example.productshopxml.exceptions.ValidationException;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateUserDTO {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void validate(){
        if (lastName.length() < 3) {
            throw new ValidationException("User's last name should be at least 3 characters long.");
        }
    }
}
