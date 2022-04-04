package softuni.exam.instagraphlite.models.dtos.uеrsDTOs;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CreateUserDTO implements Serializable {

    @Size(min = 2, max = 18)
    @NotNull
    @Expose
    private String username;

    @Size(min = 4)
    @NotNull
    @Expose
    private String password;

    @NotNull
    @Expose
    private String profilePicture;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }
}
