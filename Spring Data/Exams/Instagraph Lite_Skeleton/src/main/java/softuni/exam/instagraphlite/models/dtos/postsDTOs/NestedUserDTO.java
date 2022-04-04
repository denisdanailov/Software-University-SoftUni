package softuni.exam.instagraphlite.models.dtos.postsDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NestedUserDTO {

    private String username;

    public String getUsername() {
        return username;
    }
}
