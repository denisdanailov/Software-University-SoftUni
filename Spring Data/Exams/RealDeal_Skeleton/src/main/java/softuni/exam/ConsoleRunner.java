package softuni.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.PictureService;
import softuni.exam.service.SellerService;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final CarService carService;
    private final PictureService pictureService;
    private final SellerService sellerService;
    private final OfferService offerService;

    @Autowired
    public ConsoleRunner(CarService carService, PictureService pictureService, SellerService sellerService, OfferService offerService) {
        this.carService = carService;
        this.pictureService = pictureService;
        this.sellerService = sellerService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.carService.importCars();
//        this.pictureService.importPictures();
//        this.sellerService.importSellers();
//        this.offerService.importOffers();

//        this.carService.getCarsOrderByPicturesCountThenByMake();
    }
}
