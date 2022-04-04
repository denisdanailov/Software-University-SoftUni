package softuni.exam.models.dto.townDTOs;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CreateTownDTO implements Serializable {

    @Size(min = 2)
    @Expose
    private String townName;

    @Positive
    @Expose
    private int population;

    public String getTownName() {
        return townName;
    }

    public int getPopulation() {
        return population;
    }
}
