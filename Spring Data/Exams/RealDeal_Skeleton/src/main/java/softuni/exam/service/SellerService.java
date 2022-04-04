package softuni.exam.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface SellerService {
    String SELLERS_FILE_PATH = "src/main/resources/files/xml/sellers.xml";

    boolean areImported();

    String readSellersFromFile() throws IOException;

    String importSellers() throws IOException, JAXBException;

}
