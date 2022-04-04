package hiberspring.util.impl;

import hiberspring.util.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Path;

public class XmlParserImpl implements XmlParser {

    @Override
    @SuppressWarnings("unchecked")
    public <E> E parseXml(Class<E> objectClass, String filePath) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (E) unmarshaller.unmarshal(new File(filePath));
    }
}
