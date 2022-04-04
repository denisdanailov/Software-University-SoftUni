package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.Car;
import softuni.exam.models.dtos.carDTOs.CreateCarDTO;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepo;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepo, Gson gson, ValidationUtil validationUtil,
                          @Qualifier("mapperStringToLocalDateConv")ModelMapper modelMapper) {
        this.carRepo = carRepo;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.carRepo.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        FileReader carsReader = new FileReader(new File(CARS_FILE_PATH));

        CreateCarDTO[] createCarDTOs = gson.fromJson(carsReader, CreateCarDTO[].class);

        Set<Car> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreateCarDTO dto : createCarDTOs) {
            if (!validationUtil.isValid(dto)) {
                sb.append("Invalid car").append(System.lineSeparator());
                continue;
            }

            Optional<Car> optCar = this.carRepo.findByMakeAndModelAndKilometers(dto.getMake(), dto.getModel(), dto.getKilometers());
            if(optCar.isPresent()) {
                sb.append("Invalid car").append(System.lineSeparator());
                continue;
            }

            Car car = modelMapper.map(dto, Car.class);

            toImport.add(car);

            sb.append(String.format("Successfully imported car - %s - %s", car.getMake(), car.getModel()))
                    .append(System.lineSeparator());
        }

        this.carRepo.saveAll(toImport);

        return sb.toString();
    }

    @Override
    @Transactional
    public String getCarsOrderByPicturesCountThenByMake() {

        List<Car> orderedCars = this.carRepo.findAllCarsByPicturesCountDescMakeAsc();

        StringBuilder sb = new StringBuilder();

        orderedCars.forEach(car -> sb.append(String.format(
                "Car make - %s, model - %s\n" +
                "\tKilometers - %d\n" +
                "\tRegistered on - %s\n" +
                "\tNumber of pictures - %d\n", car.getMake(), car.getModel(), car.getKilometers(),
                                                car.getRegisteredOn().toString(), car.getPictures().size()))
                .append(System.lineSeparator()));

        return sb.toString();
    }
}
