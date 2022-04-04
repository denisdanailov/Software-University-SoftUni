package softuni.exam.instagraphlite.models.dtos.postsDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostsFactoryDTO implements Serializable {

    @XmlElement(name = "post")
    List<CreatePostDTO> posts;

    public List<CreatePostDTO> getPosts() {
        return posts;
    }
}
