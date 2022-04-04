package com.example.xmldemo;

import com.example.xmldemo.dtos.InputPersonDTO;
import com.example.xmldemo.dtos.OutputPersonDTO;
import com.example.xmldemo.dtos.PersonFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

//        _01_marshaller();

//        _02_unmarshaller();

//        _03_exportMultiplePeople();

//        _04_importMultiplePeople();
    }

    private void _04_importMultiplePeople() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PersonFactory.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        PersonFactory personFactory = (PersonFactory)unmarshaller.unmarshal(new File("src/main/resources/xmlfiles/multiplepeoplecreation.xml"));

        System.out.println(personFactory);
    }

    private void _03_exportMultiplePeople() throws JAXBException {
        OutputPersonDTO opd = new OutputPersonDTO("Pesho", "Peshev", 34);
        OutputPersonDTO opd2 = new OutputPersonDTO("Vanko", "Ivanov", 26);
        OutputPersonDTO opd3 = new OutputPersonDTO("Tisho", "Tishev", 39);
        OutputPersonDTO opd4 = new OutputPersonDTO("Petur", "Popyordanov", 40);

        List<OutputPersonDTO> list = List.of(opd, opd2, opd3, opd4);

        PersonFactory pf = new PersonFactory(list);

        JAXBContext jaxbContext = JAXBContext.newInstance(PersonFactory.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(pf, System.out);
    }

    private void _02_unmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(InputPersonDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        InputPersonDTO createPersonDTO =(InputPersonDTO) unmarshaller.unmarshal(new File("src/main/resources/xmlfiles/createperson.xml"));

        System.out.println(createPersonDTO);
    }

    private void _01_marshaller() throws JAXBException {
        OutputPersonDTO createPersonDTO = new OutputPersonDTO("Pesho", "Peshev", 35);

        JAXBContext jaxbContext = JAXBContext.newInstance(OutputPersonDTO.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(createPersonDTO, System.out);
    }
}
