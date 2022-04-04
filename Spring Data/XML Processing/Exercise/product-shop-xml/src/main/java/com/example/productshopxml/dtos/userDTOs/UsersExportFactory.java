package com.example.productshopxml.dtos.userDTOs;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersExportFactory {

    @XmlAttribute
    private int count;

    @XmlElement(name = "user")
    private List<UserExportDTO> users;

    public UsersExportFactory() {
    }

    public UsersExportFactory(List<UserExportDTO> users) {
        this.users = users;
        this.count = this.users.size();
    }
}
