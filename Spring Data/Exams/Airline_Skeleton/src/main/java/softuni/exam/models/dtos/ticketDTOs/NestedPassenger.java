package softuni.exam.models.dtos.ticketDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NestedPassenger implements Serializable {

    private String email;

    public String getEmail() {
        return email;
    }
}
