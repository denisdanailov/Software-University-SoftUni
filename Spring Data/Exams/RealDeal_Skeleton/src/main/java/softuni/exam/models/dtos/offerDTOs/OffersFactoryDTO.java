package softuni.exam.models.dtos.offerDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "offers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OffersFactoryDTO implements Serializable {

    @XmlElement(name = "offer")
    private List<CreateOfferDTO> offers;

    public List<CreateOfferDTO> getOffers() {
        return offers;
    }
}
