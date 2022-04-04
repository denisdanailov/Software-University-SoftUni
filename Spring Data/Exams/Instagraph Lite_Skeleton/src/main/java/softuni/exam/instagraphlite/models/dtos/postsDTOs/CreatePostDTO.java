package softuni.exam.instagraphlite.models.dtos.postsDTOs;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreatePostDTO {

    @Size(min = 21)
    @NotNull
    private String caption;

    @NotNull
    private NestedUserDTO user;

    @NotNull
    private NestedPictureDTO picture;

    public String getCaption() {
        return caption;
    }

    public NestedUserDTO getUser() {
        return user;
    }

    public NestedPictureDTO getPicture() {
        return picture;
    }
}
