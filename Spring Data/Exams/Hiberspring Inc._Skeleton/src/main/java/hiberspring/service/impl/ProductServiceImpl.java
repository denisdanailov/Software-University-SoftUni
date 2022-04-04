package hiberspring.service.impl;

import hiberspring.domain.dtos.productDTOs.CreateProductDTO;
import hiberspring.domain.dtos.productDTOs.ProductFactoryDTO;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.ProductRepository;
import hiberspring.service.ProductService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    private final BranchRepository branchRepo;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepo, BranchRepository branchRepo, XmlParser xmlParser, ValidationUtil validationUtil,
                              ModelMapper modelMapper) {
        this.productRepo = productRepo;
        this.branchRepo = branchRepo;

        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean productsAreImported() {
        return this.productRepo.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return Files.readString(Path.of(PRODUCTS_FILE_PATH));
    }

    @Override
    public String importProducts() throws JAXBException {

        ProductFactoryDTO productFactoryDTO = this.xmlParser.parseXml(ProductFactoryDTO.class, PRODUCTS_FILE_PATH);

        List<CreateProductDTO> createProductDTOs = productFactoryDTO.getProductDTOs();

        return createProductDTOs
                .stream()
                .map(this::validateAndImport)
                .collect(Collectors.joining("\n"));
    }

    private String validateAndImport(CreateProductDTO dto) {
        if (!this.validationUtil.isValid(dto)) {
            return "Error: Invalid data.";
        }

        Optional<Branch> optBranch = this.branchRepo.findByName(dto.getBranch());
        if (optBranch.isEmpty()) {
            return "Error: Invalid data.";
        }

        Product product = this.modelMapper.map(dto, Product.class);

        product.setBranch(optBranch.get());

        this.productRepo.save(product);

        return String.format("Successfully imported Product %s.", product.getName());
    }
}
