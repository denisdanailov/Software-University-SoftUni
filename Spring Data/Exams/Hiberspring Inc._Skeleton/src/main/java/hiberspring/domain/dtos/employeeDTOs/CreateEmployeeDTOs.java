package hiberspring.domain.dtos.employeeDTOs;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateEmployeeDTOs implements Serializable {

    @NotNull
    @XmlAttribute(name = "first-name")
    private String firstName;

    @NotNull
    @XmlAttribute(name = "last-name")
    private String lastName;

    @NotNull
    @XmlAttribute
    private String position;

    @NotNull
    @XmlElement
    private String card;

    @NotNull
    @XmlElement
    private String branch;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getCard() {
        return card;
    }

    public String getBranch() {
        return branch;
    }
}
