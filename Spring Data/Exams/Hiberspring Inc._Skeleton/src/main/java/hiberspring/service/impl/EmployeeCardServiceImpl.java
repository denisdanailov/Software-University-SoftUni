package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.dtos.employeeCardDTOs.CreateEmployeeCardDTO;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
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
public class EmployeeCardServiceImpl implements EmployeeCardService {
    String EMPLOYEE_CARDS_FILE_PATH = "src/main/resources/files/employee-cards.json";


    private final EmployeeCardRepository employeeCardRepo;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepo, Gson gson,
                                   ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.employeeCardRepo = employeeCardRepo;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepo.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return Files.readString(Path.of(EMPLOYEE_CARDS_FILE_PATH));
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) {

        CreateEmployeeCardDTO[] createEmployeeCardDTOs = this.gson.fromJson(employeeCardsFileContent, CreateEmployeeCardDTO[].class);

        return Arrays.stream(createEmployeeCardDTOs)
                .map(this::validateAndImport)
                .collect(Collectors.joining("\n"));

    }

    private String validateAndImport(CreateEmployeeCardDTO dto) {
        if (!this.validationUtil.isValid(dto)) {
            return "Error: Invalid data.";
        }

        Optional<EmployeeCard> optEmpCard = this.employeeCardRepo.findByNumber(dto.getNumber());
        if (optEmpCard.isPresent()) {
            return "Error: Invalid data.";
        }

        EmployeeCard empCard = modelMapper.map(dto, EmployeeCard.class);

        this.employeeCardRepo.save(empCard);

        return String.format("Successfully imported Employee Card %s.", empCard.getNumber());
    }
}
