package softuni.exam.instagraphlite.models.dtos.pictureDTOs;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CreatePictureDTO implements Serializable {

    @NotNull
    @Expose
    private String path;

    @Min(value = 500)
    @Max(value = 60000)
    @Expose
    private double size;

    public String getPath() {
        return path;
    }

    public double getSize() {
        return size;
    }
}
