package softuni.exam.models.dtos.planeDTOs;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreatePlaneDTO implements Serializable {

    @Size(min = 5)
    @XmlElement(name = "register-number")
    private String registerNumber;

    @Positive
    @XmlElement
    private int capacity;

    @Size(min = 2)
    @XmlElement
    private String airline;

    public String getRegisterNumber() {
        return registerNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getAirline() {
        return airline;
    }
}
