package softuni.exam.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface TicketService {
    String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";

    boolean areImported();

    String readTicketsFileContent() throws IOException;
	
	String importTickets() throws JAXBException;

}
