package hiberspring.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface ProductService {
    String PRODUCTS_FILE_PATH = "src/main/resources/files/products.xml";

    Boolean productsAreImported();

    String readProductsXmlFile() throws IOException;

    String importProducts() throws JAXBException;
}
