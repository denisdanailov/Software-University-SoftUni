package softuni.exam.models.dtos.offerDTOs;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateOfferDTO implements Serializable {

    @Size(min = 5)
    private String description;

    @Positive
    private BigDecimal price;

    @XmlElement(name = "added-on")
    private String addedOn;

    @XmlElement(name = "has-gold-status")
    private String hasGoldStatus;

    private NestedCarDTO car;

    private NestedSellerDTO seller;

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public String getHasGoldStatus() {
        return hasGoldStatus;
    }

    public NestedCarDTO getCar() {
        return car;
    }

    public NestedSellerDTO getSeller() {
        return seller;
    }
}
