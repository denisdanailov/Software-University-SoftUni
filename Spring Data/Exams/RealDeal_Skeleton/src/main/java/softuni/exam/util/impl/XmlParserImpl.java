package softuni.exam.util.impl;

import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlParserImpl implements XmlParser {

    @Override
    @SuppressWarnings("unchecked")
    public <E> E parse(File file, Class<E> declareClass) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(declareClass);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (E) unmarshaller.unmarshal(file);
    }
}
