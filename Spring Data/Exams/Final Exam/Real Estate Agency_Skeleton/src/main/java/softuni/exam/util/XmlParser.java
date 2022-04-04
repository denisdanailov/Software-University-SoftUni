package softuni.exam.util;

import javax.xml.bind.JAXBException;
import java.io.File;

public interface XmlParser {

    <E> E parseXml(Class<E> objectClass, File file) throws JAXBException;
}
