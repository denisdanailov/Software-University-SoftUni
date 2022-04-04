package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.dtos.pictureDTOs.CreatePictureDTO;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepo;
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepo, Gson gson, Validator validator, ModelMapper modelMapper) {
        this.pictureRepo = pictureRepo;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepo.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        FileReader picturesReader = new FileReader(new File(PICTURES_FILE_PATH));

        CreatePictureDTO[] createPictureDTOs = gson.fromJson(picturesReader, CreatePictureDTO[].class);

        Set<Picture> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreatePictureDTO dto : createPictureDTOs) {
            Set<ConstraintViolation<CreatePictureDTO>> errorSet = validator.validate(dto);
            if (!errorSet.isEmpty()) {
                sb.append("Invalid Picture").append(System.lineSeparator());
                continue;
            }

            Optional<Picture> pathOpt = this.pictureRepo.findByPath(dto.getPath());
            if (pathOpt.isPresent()) {
                sb.append("Invalid Picture").append(System.lineSeparator());
                continue;
            }

            Picture picture = modelMapper.map(dto, Picture.class);

            toImport.add(picture);

            sb.append(String.format("Successfully imported Picture, with size %.2f", picture.getSize()))
                    .append(System.lineSeparator());

        }

        this.pictureRepo.saveAll(toImport);

        return sb.toString();
    }

    @Override
    public String exportPictures() {

        List<Picture> picturesOfSize = this.pictureRepo.findAllBySizeGreaterThanOrderBySize(30000);

        StringBuilder sb = new StringBuilder();

        picturesOfSize
                .forEach(pic -> sb.append(String.format("%.2f - %s", pic.getSize(), pic.getPath().trim()))
                                        .append(System.lineSeparator()));

        return sb.toString();
    }
}
