package softuni.exam.models.dtos.planeDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreatePlanesFactory implements Serializable {

    @XmlElement(name = "plane")
    private List<CreatePlaneDTO> planes;

    public List<CreatePlaneDTO> getPlanes() {
        return planes;
    }
}
