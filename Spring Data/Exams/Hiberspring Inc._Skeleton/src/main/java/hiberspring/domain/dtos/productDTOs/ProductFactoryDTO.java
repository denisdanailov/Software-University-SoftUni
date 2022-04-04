package hiberspring.domain.dtos.productDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductFactoryDTO implements Serializable {

    @XmlElement(name = "product")
    private List<CreateProductDTO> productDTOs;

    public List<CreateProductDTO> getProductDTOs() {
        return productDTOs;
    }
}
