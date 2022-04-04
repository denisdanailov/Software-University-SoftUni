package softuni.exam.models.dto.offerDTOs;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateOfferDTO implements Serializable {

    @Positive
    private BigDecimal price;

    private NestedAgentDTO agent;

    private NestedApartmentDTO apartment;

    private String publishedOn;

    public BigDecimal getPrice() {
        return price;
    }

    public NestedAgentDTO getAgent() {
        return agent;
    }

    public NestedApartmentDTO getApartment() {
        return apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }
}
