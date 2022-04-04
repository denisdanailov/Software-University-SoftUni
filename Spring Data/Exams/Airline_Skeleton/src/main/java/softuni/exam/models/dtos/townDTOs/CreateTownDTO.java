package softuni.exam.models.dtos.townDTOs;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CreateTownDTO implements Serializable {

    @Size(min = 2)
    @Expose
    private String name;

    @Positive
    @Expose
    private int population;

    @Expose
    private String guide;

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getGuide() {
        return guide;
    }
}
