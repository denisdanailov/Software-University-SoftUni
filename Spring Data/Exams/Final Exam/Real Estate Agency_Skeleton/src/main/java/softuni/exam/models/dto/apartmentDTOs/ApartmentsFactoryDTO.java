package softuni.exam.models.dto.apartmentDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentsFactoryDTO implements Serializable {

    @XmlElement(name = "apartment")
    private List<CreateApartmentDTO> apartmentDTOs;

    public List<CreateApartmentDTO> getApartmentDTOs() {
        return apartmentDTOs;
    }
}
