package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.dtos.townDTOs.CreateTownDTO;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.service.TownService;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepo;
    private final FileUtil fileUtil;
    private final Gson gson;
    private ValidationUtil validationUtil;
    private ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepo, FileUtil fileUtil, Gson gson,
                           ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepo = townRepo;

        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepo.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return fileUtil.readFile(TOWNS_FILE_PATH);
    }

    @Override
    public String importTowns(String townsFileContent) {

        CreateTownDTO[] createTownDTOs = gson.fromJson(townsFileContent, CreateTownDTO[].class);

        return Arrays.stream(createTownDTOs)
                .map(this::validateAndImport)
                .collect(Collectors.joining("\n"));
    }

    private String validateAndImport(CreateTownDTO dto) {
        if (!this.validationUtil.isValid(dto)) {
            return "Error: Invalid data.";
        }

        Town town = this.modelMapper.map(dto, Town.class);

        this.townRepo.save(town);

        return String.format("Successfully imported Town %s.", town.getName());
    }
}
