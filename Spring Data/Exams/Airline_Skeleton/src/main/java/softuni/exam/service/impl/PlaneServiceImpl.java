package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Plane;
import softuni.exam.models.dtos.planeDTOs.CreatePlaneDTO;
import softuni.exam.models.dtos.planeDTOs.CreatePlanesFactory;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PlaneServiceImpl implements PlaneService {

    private final PlaneRepository planeRepo;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepo, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.planeRepo = planeRepo;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.planeRepo.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANES_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException {
        File planesFile = new File(PLANES_FILE_PATH);

        CreatePlanesFactory createPlanesFactory = xmlParser.parse(planesFile, CreatePlanesFactory.class);

        List<CreatePlaneDTO> planesDTOs = createPlanesFactory.getPlanes();

        Set<Plane> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreatePlaneDTO dto : planesDTOs) {
            if (!validationUtil.isValid(dto)) {
                sb.append("Invalid Plane").append(System.lineSeparator());
                continue;
            }

            Optional<Plane> optPlane = this.planeRepo.findByRegisterNumber(dto.getRegisterNumber());
            if (optPlane.isPresent()) {
                sb.append("Invalid Plane").append(System.lineSeparator());
                continue;
            }

            Plane plane = modelMapper.map(dto, Plane.class);

            toImport.add(plane);

            sb.append(String.format("Successfully imported Plane %s", plane.getRegisterNumber()))
                    .append(System.lineSeparator());
        }

        this.planeRepo.saveAll(toImport);

        return sb.toString();
    }
}
