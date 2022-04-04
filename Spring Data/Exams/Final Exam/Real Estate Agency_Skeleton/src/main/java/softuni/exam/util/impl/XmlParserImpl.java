package softuni.exam.util.impl;

import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlParserImpl implements XmlParser {

    @Override
    @SuppressWarnings("unchecked")
    public <E> E parseXml(Class<E> objectClass, File file) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (E) unmarshaller.unmarshal(file);
    }
}
