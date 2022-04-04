package softuni.exam.models.dtos.sellerDTOs;

import softuni.exam.enums.Rating;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateSellerDTO implements Serializable {

    @Size(min = 2, max = 19)
    @XmlElement(name = "first-name")
    private String firstName;

    @Size(min = 2, max = 19)
    @XmlElement(name = "last-name")
    private String lastName;

    @Email
    private String email;

    private String rating;

    private String town;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRating() {
        return rating;
    }

    public String getTown() {
        return town;
    }
}
