package softuni.exam.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface OfferService {
    String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    boolean areImported();

    String readOffersFileContent() throws IOException;
	
	String importOffers() throws IOException, JAXBException;
}
