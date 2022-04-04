package com.example.football.service.impl;

import com.example.football.models.dto.xml.CreateStatDTO;
import com.example.football.models.dto.xml.CreateStatsFactory;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepo;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public StatServiceImpl(StatRepository statRepo, ModelMapper modelMapper, Validator validator) {
        this.statRepo = statRepo;

        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.statRepo.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        Path statsFileReader = Path.of(STATS_FILE_PATH);
        return Files.readString(statsFileReader);
    }

    @Override
    public String importStats() throws JAXBException {
        File statsFile = new File(STATS_FILE_PATH);

        JAXBContext jaxbContext = JAXBContext.newInstance(CreateStatsFactory.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        CreateStatsFactory createStatsFactory = (CreateStatsFactory)unmarshaller.unmarshal(statsFile);

        List<CreateStatDTO> statsDTO = createStatsFactory.getStats();

        StringBuilder sb = new StringBuilder();
        List<Stat> toImport = new ArrayList<>();

        for (CreateStatDTO statDTO: statsDTO) {

//            if (!statDTO.validate()) {
//                sb.append("Invalid Stat").append(System.lineSeparator());
//                continue;
//            }

            Set<ConstraintViolation<CreateStatDTO>> errorSet = validator.validate(statDTO);
            if (!errorSet.isEmpty()){
                sb.append("Invalid Stat").append(System.lineSeparator());
                continue;
            }

            //ToDo: Fix method query.
            Optional<Stat> statOpt = this.statRepo.findByPassingAndShootingAndEndurance(statDTO.getPassing(), statDTO.getShooting(), statDTO.getEndurance());
            if(statOpt.isPresent()) {
                sb.append("Invalid Stat").append(System.lineSeparator());
                continue;
            }

            Stat stat = modelMapper.map(statDTO, Stat.class);

            toImport.add(stat);

            sb.append("Successfully imported Stat ").append(stat).append(System.lineSeparator());
        }

        this.statRepo.saveAll(toImport);

        return sb.toString();
    }
}
