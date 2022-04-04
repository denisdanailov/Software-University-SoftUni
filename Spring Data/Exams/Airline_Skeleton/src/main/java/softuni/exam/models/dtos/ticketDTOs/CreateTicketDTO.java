package softuni.exam.models.dtos.ticketDTOs;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateTicketDTO implements Serializable {

    @Size(min = 2)
    @XmlElement(name = "serial-number")
    private String serialNumber;

    @Positive
    private BigDecimal price;

    @XmlElement(name = "take-off")
    private String takeOff;

    @XmlElement(name = "from-town")
    private NestedTown fromTown;

    @XmlElement(name = "to-town")
    private NestedTown toTown;

    private NestedPassenger passenger;

    private NestedPlane plane;

    public String getSerialNumber() {
        return serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public NestedTown getFromTown() {
        return fromTown;
    }

    public NestedTown getToTown() {
        return toTown;
    }

    public NestedPassenger getPassenger() {
        return passenger;
    }

    public NestedPlane getPlane() {
        return plane;
    }
}
