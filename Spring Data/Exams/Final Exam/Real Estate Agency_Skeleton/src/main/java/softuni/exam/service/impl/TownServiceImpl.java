package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.townDTOs.CreateTownDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;

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
    private final FileUtil fileUtil;

    @Autowired
    public TownServiceImpl(TownRepository townRepo, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, FileUtil fileUtil) {
        this.townRepo = townRepo;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.fileUtil = fileUtil;
    }

    @Override
    public boolean areImported() {
        return this.townRepo.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return fileUtil.readFile(TOWNS_FILE_PATH);
    }

    @Override
    public String importTowns() throws IOException {

        CreateTownDTO[] createTownDTOs = gson.fromJson(this.readTownsFileContent(), CreateTownDTO[].class);

        Set<Town> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreateTownDTO dto : createTownDTOs) {

            if (!this.validationUtil.isValid(dto)) {
                sb.append("Invalid town").append(System.lineSeparator());
                continue;
            }

            Optional<Town> optTown = this.townRepo.findByTownName(dto.getTownName());
            if (optTown.isPresent()) {
                sb.append("Invalid town").append(System.lineSeparator());
                continue;
            }

            Town town = this.modelMapper.map(dto, Town.class);

            if (toImport.add(town)) {
                sb.append(String.format("Successfully imported town %s - %d", town.getTownName(), town.getPopulation()))
                        .append(System.lineSeparator());
            } else {
                sb.append("Invalid town").append(System.lineSeparator());
            }

        }

        this.townRepo.saveAll(toImport);

        return sb.toString();
    }
}
