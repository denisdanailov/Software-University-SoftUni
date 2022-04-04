package softuni.exam.service.impl;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.Car;
import softuni.exam.models.Offer;
import softuni.exam.models.Seller;
import softuni.exam.models.dtos.offerDTOs.CreateOfferDTO;
import softuni.exam.models.dtos.offerDTOs.OffersFactoryDTO;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final CarRepository carRepo;
    private final ModelMapper modelMapper;
    private final SellerRepository sellerRepo;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, CarRepository carRepo, @Qualifier("mapperStringToLocalDateTimeConv")ModelMapper modelMapper,
                            SellerRepository sellerRepo, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.offerRepository = offerRepository;
        this.carRepo = carRepo;
        this.sellerRepo = sellerRepo;

        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        File offersFile = new File(OFFERS_FILE_PATH);

        OffersFactoryDTO offersFactoryDTO = xmlParser.parse(offersFile, OffersFactoryDTO.class);

        List<CreateOfferDTO> createOfferDTOs = offersFactoryDTO.getOffers();

        Set<Offer> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreateOfferDTO dto : createOfferDTOs) {
            if (!validationUtil.isValid(dto)) {
                sb.append("Invalid offer").append(System.lineSeparator());
                continue;
            }

            Optional<Offer> optOffer = this.offerRepository.findByDescriptionAndAddedOn(dto.getDescription(),
                    LocalDateTime.parse(dto.getAddedOn(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            if (optOffer.isPresent()) {
                sb.append("Invalid offer").append(System.lineSeparator());
                continue;
            }

            Optional<Seller> optSeller = this.sellerRepo.findById((long) dto.getSeller().getId());
            Optional<Car> optCar = this.carRepo.findById((long) dto.getCar().getId());
            if (optCar.isEmpty() || optSeller.isEmpty()) {
                sb.append("Invalid offer").append(System.lineSeparator());
                continue;
            }

            Offer offer = modelMapper.map(dto, Offer.class);

            offer.setCar(optCar.get());
            offer.setSeller(optSeller.get());

            toImport.add(offer);

            sb.append(String.format("Successfully imported offer - %s - %s",offer.getAddedOn().toString(), offer.getHasGoldStatus().toString()))
                    .append(System.lineSeparator());
        }

        this.offerRepository.saveAll(toImport);

        return sb.toString();
    }
}
