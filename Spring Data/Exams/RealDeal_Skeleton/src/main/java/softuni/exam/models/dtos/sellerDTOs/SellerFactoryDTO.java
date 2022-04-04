package softuni.exam.models.dtos.sellerDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "sellers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerFactoryDTO implements Serializable {

    @XmlElement(name = "seller")
    private List<CreateSellerDTO> sellers;

    public List<CreateSellerDTO> getSellers() {
        return sellers;
    }
}
