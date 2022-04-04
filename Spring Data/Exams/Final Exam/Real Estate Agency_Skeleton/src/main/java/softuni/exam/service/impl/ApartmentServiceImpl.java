package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.apartmentDTOs.ApartmentsFactoryDTO;
import softuni.exam.models.dto.apartmentDTOs.CreateApartmentDTO;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepo;
    private final TownRepository townRepo;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final FileUtil fileUtil;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepo, XmlParser xmlParser, ValidationUtil validationUtil,
                                TownRepository townRepo, ModelMapper modelMapper, FileUtil fileUtil) {
        this.apartmentRepo = apartmentRepo;
        this.townRepo = townRepo;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.fileUtil = fileUtil;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepo.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return fileUtil.readFile(APARTMENTS_FILE_PATH);
    }

    @Override
    public String importApartments() throws IOException, JAXBException {

        File apartmentsFile = fileUtil.createFile(APARTMENTS_FILE_PATH);

        ApartmentsFactoryDTO apartmentsFactoryDTO = xmlParser.parseXml(ApartmentsFactoryDTO.class, apartmentsFile);

        List<CreateApartmentDTO> createApartmentDTOs = apartmentsFactoryDTO.getApartmentDTOs();

        StringBuilder sb = new StringBuilder();

        for (CreateApartmentDTO dto : createApartmentDTOs) {
            if (!this.validationUtil.isValid(dto)) {
                sb.append("Invalid apartment").append(System.lineSeparator());
                continue;
            }

            Optional<Apartment> optApartment = this.apartmentRepo.findByTownTownNameAndArea(dto.getTown(), dto.getArea());
            if (optApartment.isPresent()) {
                sb.append("Invalid apartment").append(System.lineSeparator());
                continue;
            }

            Optional<Town> optTown = this.townRepo.findByTownName(dto.getTown());
            if (optTown.isEmpty()) {
                sb.append("Invalid apartment").append(System.lineSeparator());
                continue;
            }

            Apartment apartment = this.modelMapper.map(dto, Apartment.class);

            apartment.setTown(optTown.get());

            this.apartmentRepo.save(apartment);

            sb.append(String.format("Successfully imported apartment %s - %.2f", apartment.getApartmentType().toString(), apartment.getArea()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
