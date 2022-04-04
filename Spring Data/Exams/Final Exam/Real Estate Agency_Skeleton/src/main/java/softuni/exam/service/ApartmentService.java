package softuni.exam.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface ApartmentService {
    String APARTMENTS_FILE_PATH = "src/main/resources/files/xml/apartments.xml";

    boolean areImported();

    String readApartmentsFromFile() throws IOException;

    String importApartments() throws IOException, JAXBException;
}
