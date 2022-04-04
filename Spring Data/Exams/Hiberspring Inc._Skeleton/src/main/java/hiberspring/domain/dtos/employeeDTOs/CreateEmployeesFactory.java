package hiberspring.domain.dtos.employeeDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateEmployeesFactory implements Serializable {

    @XmlElement(name = "employee")
    private List<CreateEmployeeDTOs> employeeDTOs;

    public List<CreateEmployeeDTOs> getEmployeeDTOs() {
        return employeeDTOs;
    }
}
