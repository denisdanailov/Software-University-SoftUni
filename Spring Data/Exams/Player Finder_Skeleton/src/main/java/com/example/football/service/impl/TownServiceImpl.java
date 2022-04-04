package com.example.football.service.impl;

import com.example.football.models.dto.json.CreateTownDTO;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepo;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public TownServiceImpl(TownRepository townRepo, @Qualifier(value = "gsonRead")Gson gson, ModelMapper modelMapper, Validator validator) {
        this.townRepo = townRepo;

        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.townRepo.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {

        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws FileNotFoundException {

        FileReader townReader = new FileReader(TOWNS_FILE_PATH);

        CreateTownDTO[] createTownDTOs = gson.fromJson(townReader, CreateTownDTO[].class);

        StringBuilder sb = new StringBuilder();

        List<Town> toImport = new ArrayList<>();

        for (CreateTownDTO townDTO : createTownDTOs) {

//            if (!townDTO.validate()) {
//                sb.append("Invalid Town").append(System.lineSeparator());
//                continue;
//            }

            Set<ConstraintViolation<CreateTownDTO>> errorsSet = validator.validate(townDTO);
            if (!errorsSet.isEmpty()) {
                sb.append("Invalid Town").append(System.lineSeparator());
                continue;
            }

            // Check if town already exists in DB
            Optional<Town> townOpt = this.townRepo.findByName(townDTO.getName());
            if (townOpt.isPresent()) {
                sb.append("Invalid Town").append(System.lineSeparator());
                continue;
            }

            Town town = modelMapper.map(townDTO, Town.class);

            toImport.add(town);

            sb.append("Successfully imported Town ").append(town).append(System.lineSeparator());
        }

        this.townRepo.saveAll(toImport);

        return sb.toString();
    }
}
