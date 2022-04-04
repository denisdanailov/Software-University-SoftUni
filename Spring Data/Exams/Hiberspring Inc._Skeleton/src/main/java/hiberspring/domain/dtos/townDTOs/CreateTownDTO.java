package hiberspring.domain.dtos.townDTOs;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CreateTownDTO implements Serializable {

    @NotNull
    @Expose
    private String name;

    @NotNull
    @Expose
    private Integer population;

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }
}
