package softuni.exam.models.dtos.ticketDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketsFactoryDTO implements Serializable {

    @XmlElement(name = "ticket")
    private List<CreateTicketDTO> tickets;

    public List<CreateTicketDTO> getTickets() {
        return tickets;
    }
}
