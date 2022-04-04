package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Town;
import softuni.exam.models.dtos.townDTOs.CreateTownDTO;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepo;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepo, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepo = townRepo;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return townRepo.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws FileNotFoundException {
        FileReader townsReader = new FileReader(new File(TOWNS_FILE_PATH));

        CreateTownDTO[] createTownDTOs = gson.fromJson(townsReader, CreateTownDTO[].class);

        Set<Town> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreateTownDTO dto : createTownDTOs) {

            if (!validationUtil.isValid(dto)) {
                sb.append("Invalid Town").append(System.lineSeparator());
                continue;
            }

            Optional<Town> townOpt = this.townRepo.findByName(dto.getName());
            if (townOpt.isPresent()) {
                sb.append("Invalid Town").append(System.lineSeparator());
                continue;
            }

            Town town = modelMapper.map(dto, Town.class);

            toImport.add(town);

            sb.append(String.format("Successfully imported Town %s - %d", town.getName(), town.getPopulation()))
                    .append(System.lineSeparator());
        }

        this.townRepo.saveAll(toImport);

        return sb.toString();
    }
}
