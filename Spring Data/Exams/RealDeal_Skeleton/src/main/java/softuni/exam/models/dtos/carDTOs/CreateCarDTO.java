package softuni.exam.models.dtos.carDTOs;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CreateCarDTO  implements Serializable {

    @Size(min = 2, max = 19)
    @Expose
    private String make;

    @Size(min = 2, max = 19)
    @Expose
    private String model;

    @Positive
    @Expose
    private int kilometers;

    @Expose
    private String registeredOn;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getKilometers() {
        return kilometers;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }
}
