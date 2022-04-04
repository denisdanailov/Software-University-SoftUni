package softuni.exam.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface PlaneService {
    String PLANES_FILE_PATH = "src/main/resources/files/xml/planes.xml";

    boolean areImported();

    String readPlanesFileContent() throws IOException;
	
	String importPlanes() throws JAXBException;

}
