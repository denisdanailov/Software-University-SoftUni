package hiberspring.domain.dtos.productDTOs;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateProductDTO implements Serializable {

    @NotNull
    @XmlAttribute
    private String name;

    @NotNull
    @XmlAttribute
    private Integer clients;

    @NotNull
    @XmlElement
    private String branch;

    public String getName() {
        return name;
    }

    public Integer getClients() {
        return clients;
    }

    public String getBranch() {
        return branch;
    }
}
