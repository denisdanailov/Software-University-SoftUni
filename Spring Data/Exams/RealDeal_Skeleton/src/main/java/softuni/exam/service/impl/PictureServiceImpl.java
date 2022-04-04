package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.Car;
import softuni.exam.models.Picture;
import softuni.exam.models.dtos.pictureDTOs.CreatePictureDTO;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepo;
    private final CarRepository carRepo;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepo, CarRepository carRepo, Gson gson,
                              ValidationUtil validationUtil, @Qualifier("mapperStringToLocalDateTimeConv")ModelMapper modelMapper) {
        this.pictureRepo = pictureRepo;
        this.carRepo = carRepo;

        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepo.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        FileReader picturesReader = new FileReader(new File(PICTURES_FILE_PATH));

        CreatePictureDTO[] createPictureDTOs = gson.fromJson(picturesReader, CreatePictureDTO[].class);

        Set<Picture> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreatePictureDTO dto : createPictureDTOs) {
            if (!validationUtil.isValid(dto)) {
                sb.append("Invalid picture").append(System.lineSeparator());
                continue;
            }

            Optional<Picture> optPicture = this.pictureRepo.findByName(dto.getName());
            if (optPicture.isPresent()) {
                sb.append("Invalid picture").append(System.lineSeparator());
                continue;
            }

            Optional<Car> optCar = this.carRepo.findById((long) dto.getCar());
            if (optCar.isEmpty()) {
                sb.append("Invalid picture").append(System.lineSeparator());
                continue;
            }

            Picture picture = modelMapper.map(dto, Picture.class);

            picture.setCar(optCar.get());

            toImport.add(picture);

            sb.append(String.format("Successfully imported picture - %s", picture.getName())).append(System.lineSeparator());
        }

        this.pictureRepo.saveAll(toImport);

        return sb.toString();
    }
}
