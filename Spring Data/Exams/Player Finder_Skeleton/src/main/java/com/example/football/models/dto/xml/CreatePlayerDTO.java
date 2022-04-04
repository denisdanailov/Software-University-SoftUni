package com.example.football.models.dto.xml;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreatePlayerDTO {
    @XmlElement(name = "first-name")
    @Size(min = 3)
    private String firstName;
    @XmlElement(name = "last-name")
    @Size(min = 3)
    private String lastName;
    @Email
    private String email;
    @XmlElement(name = "birth-date")
    private String birthDate;
    private String position;
    private NestedTownDTO town;
    private NestedTeamDTO team;
    private NestedStatDTO stat;

    public CreatePlayerDTO() {
    }

//    public boolean validate() {
//        if(firstName.length() < 2 || lastName.length() < 2 || !email.contains("@") || !email.contains(".") ||
//            email.indexOf("@") > email.lastIndexOf(".")) {
//            return false;
//        }
//
//        return true;
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPosition() {
        return position;
    }

    public NestedTownDTO getTown() {
        return town;
    }

    public NestedTeamDTO getTeam() {
        return team;
    }

    public NestedStatDTO getStat() {
        return stat;
    }
}
