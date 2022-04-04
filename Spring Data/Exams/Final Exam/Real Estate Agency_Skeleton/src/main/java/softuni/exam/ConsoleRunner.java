package softuni.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.exam.service.AgentService;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.OfferService;
import softuni.exam.service.TownService;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final TownService townService;
    private final OfferService offerService;
    private final ApartmentService apartmentService;
    private final AgentService agentService;

    @Autowired
    public ConsoleRunner(TownService townService, OfferService offerService, ApartmentService apartmentService, AgentService agentService) {
        this.townService = townService;
        this.offerService = offerService;
        this.apartmentService = apartmentService;
        this.agentService = agentService;
    }

    @Override
    public void run(String... args) throws Exception {

//        this.townService.importTowns();
//        this.agentService.importAgents();
//        this.apartmentService.importApartments();
//        this.offerService.importOffers();

//        this.offerService.exportOffers();
    }
}
