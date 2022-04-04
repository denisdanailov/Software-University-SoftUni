package hiberspring.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface EmployeeService {
   String EMPLOYEES_FILE_PATH = "src/main/resources/files/employees.xml";

   Boolean employeesAreImported();

   String readEmployeesXmlFile() throws IOException;

   String importEmployees() throws JAXBException;

   String exportProductiveEmployees();
}
