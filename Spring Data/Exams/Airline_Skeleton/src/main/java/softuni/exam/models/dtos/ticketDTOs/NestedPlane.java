package softuni.exam.models.dtos.ticketDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NestedPlane implements Serializable {

    @XmlElement(name = "register-number")
    private String registerNumber;

    public String getRegisterNumber() {
        return registerNumber;
    }
}
