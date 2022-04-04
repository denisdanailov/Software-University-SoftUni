package softuni.exam.models.dto.agentDTOs;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CreateAgentDTO implements Serializable {

    @Size(min = 2)
    @Expose
    private String firstName;

    @Size(min = 2)
    @Expose
    private String lastName;

    @Expose
    private String town;

    @Email
    @Expose
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTown() {
        return town;
    }

    public String getEmail() {
        return email;
    }
}
