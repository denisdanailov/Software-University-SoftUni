package softuni.exam.models.dtos.pictureDTOs;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class CreatePictureDTO implements Serializable {

    @Size(min = 2, max = 19)
    @Expose
    private String name;

    @Expose
    private String dateAndTime;

    @Expose
    private int car;

    public String getName() {
        return name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public int getCar() {
        return car;
    }
}
