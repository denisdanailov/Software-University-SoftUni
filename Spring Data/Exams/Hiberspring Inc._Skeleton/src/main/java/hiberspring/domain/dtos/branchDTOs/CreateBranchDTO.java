package hiberspring.domain.dtos.branchDTOs;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CreateBranchDTO implements Serializable {

    @NotNull
    @Expose
    private String name;

    @NotNull
    @Expose
    private String town;

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }
}
