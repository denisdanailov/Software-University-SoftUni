package hiberspring.domain.dtos.employeeCardDTOs;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CreateEmployeeCardDTO implements Serializable {

    @NotNull
    @Expose
    private String number;

    public String getNumber() {
        return number;
    }
}
