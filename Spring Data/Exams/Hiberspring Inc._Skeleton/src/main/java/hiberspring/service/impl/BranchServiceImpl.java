package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.dtos.branchDTOs.CreateBranchDTO;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.TownRepository;
import hiberspring.service.BranchService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepo;
    private final TownRepository townRepo;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepo, TownRepository townRepo, Gson gson,
                             ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.branchRepo = branchRepo;
        this.townRepo = townRepo;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepo.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return Files.readString(Path.of(BRANCHES_FILE_PATH));
    }

    @Override
    public String importBranches(String branchesFileContent) {

        CreateBranchDTO[] createBranchDTOs = this.gson.fromJson(branchesFileContent, CreateBranchDTO[].class);

        return Arrays.stream(createBranchDTOs)
                .map(this::validateAndImport)
                .collect(Collectors.joining("\n"));
    }

    private String validateAndImport(CreateBranchDTO dto) {

        if (!this.validationUtil.isValid(dto)) {
            return "Error: Invalid data.";
        }

        Optional<Town> optTown = this.townRepo.findByName(dto.getTown());
        if (optTown.isEmpty()) {
            return "Error: Invalid data.";
        }

        Branch branch = modelMapper.map(dto, Branch.class);

        branch.setTown(optTown.get());

        this.branchRepo.save(branch);

        return String.format("Successfully imported Branch %s.", branch.getName());
    }
}
