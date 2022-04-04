package softuni.exam.util;

import javax.xml.bind.JAXBException;
import java.io.File;

public interface XmlParser {

    <E> E parse(File file,Class<E> declareClass) throws JAXBException;
}
