package softuni.exam.service.impl;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.enums.Rating;
import softuni.exam.models.Seller;
import softuni.exam.models.dtos.sellerDTOs.CreateSellerDTO;
import softuni.exam.models.dtos.sellerDTOs.SellerFactoryDTO;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepo;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private ModelMapper modelMapper;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepo, XmlParser xmlParser, ValidationUtil validationUtil,
                             @Qualifier("mapperStringToRatingConv")ModelMapper modelMapper) {
        this.sellerRepo = sellerRepo;

        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepo.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLERS_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        File sellersFile = new File(SELLERS_FILE_PATH);

        SellerFactoryDTO sellerFactoryDTOs = xmlParser.parse(sellersFile, SellerFactoryDTO.class);

        List<CreateSellerDTO> createSellerDTOs = sellerFactoryDTOs.getSellers();

        Set<Seller> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreateSellerDTO dto : createSellerDTOs) {
            if (!validationUtil.isValid(dto)) {
                sb.append("Invalid seller").append(System.lineSeparator());
                continue;
            }

            Optional<Seller> optSeller = this.sellerRepo.findByEmail(dto.getEmail());
            if (optSeller.isPresent()) {
                sb.append("Invalid seller").append(System.lineSeparator());
                continue;
            }

            try {
                Rating.valueOf(dto.getRating());
            } catch (IllegalArgumentException exception) {
                sb.append("Invalid seller").append(System.lineSeparator());
                continue;
            }

            Seller seller = modelMapper.map(dto, Seller.class);

            toImport.add(seller);

            sb.append(String.format("Successfully imported seller - %s - %s", seller.getLastName(), seller.getEmail()))
                    .append(System.lineSeparator());
        }

        this.sellerRepo.saveAll(toImport);

        return sb.toString();
    }
}
