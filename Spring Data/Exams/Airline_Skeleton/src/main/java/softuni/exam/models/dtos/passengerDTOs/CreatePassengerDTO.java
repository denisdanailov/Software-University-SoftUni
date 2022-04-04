package softuni.exam.models.dtos.passengerDTOs;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CreatePassengerDTO implements Serializable {

    @Size(min = 2)
    @Expose
    private String firstName;

    @Size(min = 2)
    @Expose
    private String lastName;

    @Positive
    @Expose
    private int age;

    @Expose
    private String phoneNumber;

    @Email
    @Expose
    private String email;

    @Expose
    private String town;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getTown() {
        return town;
    }
}
