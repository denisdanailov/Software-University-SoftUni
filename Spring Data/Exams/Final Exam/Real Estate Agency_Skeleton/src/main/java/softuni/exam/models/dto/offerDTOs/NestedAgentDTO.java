package softuni.exam.models.dto.offerDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NestedAgentDTO implements Serializable {

    private String name;

    public String getName() {
        return name;
    }
}
