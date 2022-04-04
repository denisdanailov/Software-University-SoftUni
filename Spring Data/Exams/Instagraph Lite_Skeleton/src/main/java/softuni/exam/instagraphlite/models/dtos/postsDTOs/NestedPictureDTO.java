package softuni.exam.instagraphlite.models.dtos.postsDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NestedPictureDTO {

    private String path;

    public String getPath() {
        return path;
    }
}
