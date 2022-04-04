package hiberspring;

import hiberspring.service.*;
import hiberspring.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    String TOWNS_FILE_PATH = "src/main/resources/files/towns.json";
    String BRANCHES_FILE_PATH = "src/main/resources/files/branches.json";
    String EMPLOYEE_CARDS_FILE_PATH = "src/main/resources/files/employee-cards.json";


    private final FileUtil fileUtil;
    private final TownService townService;
    private final BranchService branchService;
    private final EmployeeCardService employeeCardService;
    private final ProductService productService;
    private final EmployeeService employeeService;

    @Autowired
    public ConsoleRunner(FileUtil fileUtil, TownService townService, BranchService branchService, EmployeeCardService employeeCardService,
                         ProductService productService, EmployeeService employeeService) {
        this.fileUtil = fileUtil;
        this.townService = townService;
        this.branchService = branchService;
        this.employeeCardService = employeeCardService;
        this.productService = productService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.townService.importTowns(fileUtil.readFile(TOWNS_FILE_PATH));
//        this.branchService.importBranches(fileUtil.readFile(BRANCHES_FILE_PATH));
//        this.employeeCardService.importEmployeeCards(fileUtil.readFile(EMPLOYEE_CARDS_FILE_PATH));
//        this.productService.importProducts();
//        this.employeeService.importEmployees();

//        this.employeeService.exportProductiveEmployees();
    }
}
