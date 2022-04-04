package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.offerDTOs.CreateOfferDTO;
import softuni.exam.models.dto.offerDTOs.OffersFactoryDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepo;
    private final ApartmentRepository apartmentRepo;
    private final AgentRepository agentRepos;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final FileUtil fileUtil;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepo, ApartmentRepository apartmentRepo, AgentRepository agentRepos, XmlParser xmlParser,
                            ValidationUtil validationUtil, ModelMapper modelMapper, FileUtil fileUtil) {
        this.offerRepo = offerRepo;
        this.apartmentRepo = apartmentRepo;
        this.agentRepos = agentRepos;

        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.fileUtil = fileUtil;
    }
    @Override
    public boolean areImported() {
        return this.offerRepo.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return fileUtil.readFile(OFFERS_FILE_PATH);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        File offersFile = fileUtil.createFile(OFFERS_FILE_PATH);
        OffersFactoryDTO offersFactoryDTO = xmlParser.parseXml(OffersFactoryDTO.class, offersFile);

        List<CreateOfferDTO> offerDTOs = offersFactoryDTO.getOfferDTOs();

        StringBuilder sb = new StringBuilder();

        for (CreateOfferDTO dto : offerDTOs) {
            if (!this.validationUtil.isValid(dto)) {
                sb.append("Invalid offer").append(System.lineSeparator());
                continue;
            }

            Optional<Apartment> optApartment = this.apartmentRepo.findById((long) dto.getApartment().getId());
            if (optApartment.isEmpty()) {
                sb.append("Invalid offer").append(System.lineSeparator());
                continue;
            }

            Optional<Agent> optAgent = this.agentRepos.findByFirstName(dto.getAgent().getName());
            if (optAgent.isEmpty()) {
                sb.append("Invalid offer").append(System.lineSeparator());
                continue;
            }

            Offer offer = this.modelMapper.map(dto, Offer.class);

            offer.setAgent(optAgent.get());
            offer.setApartment(optApartment.get());

            this.offerRepo.save(offer);

            sb.append(String.format("Successfully imported offer %.2f", offer.getPrice()))
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    @Transactional
    public String exportOffers() {

        List<Offer> bestOffers = this.offerRepo.findBestOffers();

        StringBuilder sb = new StringBuilder();

        bestOffers.forEach(offer -> sb.append(String.format(
                "Agent %s %s with offer №%d:\n" +
                "\t-Apartment area: %.2f\n" +
                "\t--Town: %s\n" +
                "\t---Price: %.2f$\n",
                offer.getAgent().getFirstName(), offer.getAgent().getLastName(), offer.getId(), offer.getApartment().getArea(),
                offer.getApartment().getTown().getTownName(), offer.getPrice())));

        return sb.toString();
    }
}
