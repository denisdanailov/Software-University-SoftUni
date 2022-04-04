package hiberspring.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {

    <E> E parseXml(Class<E> objectClass, String filePath) throws JAXBException;
}
