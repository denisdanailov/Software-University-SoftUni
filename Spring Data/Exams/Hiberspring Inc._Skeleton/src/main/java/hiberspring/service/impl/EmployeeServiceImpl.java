package hiberspring.service.impl;

import hiberspring.domain.dtos.employeeDTOs.CreateEmployeeDTOs;
import hiberspring.domain.dtos.employeeDTOs.CreateEmployeesFactory;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.EmployeeService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final EmployeeCardRepository employeeCardRepo;
    private final BranchRepository branchRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo, EmployeeCardRepository employeeCardRepo, BranchRepository branchRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.employeeCardRepo = employeeCardRepo;
        this.branchRepository = branchRepository;

        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepo.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return Files.readString(Path.of(EMPLOYEES_FILE_PATH));
    }

    @Override
    public String importEmployees() throws JAXBException {

        CreateEmployeesFactory createEmployeesFactory = this.xmlParser.parseXml(CreateEmployeesFactory.class, EMPLOYEES_FILE_PATH);

        List<CreateEmployeeDTOs> createEmployeeDTOs = createEmployeesFactory.getEmployeeDTOs();

        return createEmployeeDTOs
                .stream()
                .map(this::validateAndImport)
                .collect(Collectors.joining("\n"));
    }

    private String validateAndImport(CreateEmployeeDTOs dto) {
        if (!this.validationUtil.isValid(dto)) {
            return "Error: Invalid data.";
        }

        Optional<EmployeeCard> optCard = this.employeeCardRepo.findByNumber(dto.getCard());
        if(optCard.isEmpty()) {
            return "Error: Invalid data.";
        }

        Optional<Branch> optBranch = this.branchRepository.findByName(dto.getBranch());
        if (optBranch.isEmpty()) {
            return "Error: Invalid data.";
        }

        Optional<Employee> optEmp = this.employeeRepo.findByCard(optCard.get());
        if (optEmp.isPresent()) {
            return "Error: Invalid data.";
        }

        Employee employee = this.modelMapper.map(dto, Employee.class);

        employee.setCard(optCard.get());
        employee.setBranch(optBranch.get());

        this.employeeRepo.save(employee);

        return String.format("Successfully imported Employee %s %s", employee.getFirstName(), employee.getLastName());
    }

    @Override
    @Transactional
    public String exportProductiveEmployees() {

        List<Employee> productiveEmployees = this.employeeRepo.findAllProductiveEmployees();

        StringBuilder sb = new StringBuilder();

        productiveEmployees
                .forEach(emp -> sb.append(String.format(
                        "Name: %s %s\n" +
                        "Position: %s\n" +
                        "Card Number: %s\n" +
                        "-------------------------\n",
                        emp.getFirstName(), emp.getLastName(), emp.getPosition(), emp.getCard().getNumber())));

        return sb.toString();
    }
}
