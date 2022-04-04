package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dtos.uеrsDTOs.CreateUserDTO;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;

import javax.transaction.Transactional;
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
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final PictureRepository pictureRepo;
    private final Gson gson;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, PictureRepository pictureRepo, Gson gson, Validator validator, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.pictureRepo = pictureRepo;

        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.userRepo.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        FileReader usersReader = new FileReader(new File(USERS_FILE_PATH));

        CreateUserDTO[] createUserDTOs = gson.fromJson(usersReader, CreateUserDTO[].class);

        Set<User> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreateUserDTO dto : createUserDTOs) {
            Set<ConstraintViolation<CreateUserDTO>> errorSet = validator.validate(dto);
            if (!errorSet.isEmpty()) {
                sb.append("Invalid User").append(System.lineSeparator());
                continue;
            }

            Optional<User> userOpt = this.userRepo.findByUsername(dto.getUsername());
            if (userOpt.isPresent()) {
                sb.append("Invalid User").append(System.lineSeparator());
                continue;
            }

            User user = modelMapper.map(dto, User.class);

            Optional<Picture> picOpt = this.pictureRepo.findByPath(dto.getProfilePicture());
            if (picOpt.isEmpty()) {
                sb.append("Invalid User").append(System.lineSeparator());
                continue;
            }

            user.setProfilePicture(picOpt.get());

            toImport.add(user);

            sb.append(String.format("Successfully imported User: %s", user.getUsername()))
                    .append(System.lineSeparator());

        }

        this.userRepo.saveAll(toImport);

        return sb.toString();
    }

    @Override
    @Transactional
    public String exportUsersWithTheirPosts() {

        List<User> usersWithPosts = this.userRepo.findAllByOrderByPostsSizeDescIdDesc();
        StringBuilder sb = new StringBuilder();

        for (User user : usersWithPosts) {
            sb.append("User: ").append(user.getUsername()).append(System.lineSeparator());
            sb.append("Post count: ").append(user.getPosts().size()).append(System.lineSeparator());

            user.getPosts()
                    .stream()
                    .sorted((a, b) -> Double.compare(a.getPicture().getSize(), b.getPicture().getSize()))
                    .forEach(post -> {
                        sb.append("==Post Details:").append(System.lineSeparator());
                        sb.append(String.format(
                                "----Caption: %s\n" +
                                        "----Picture Size: %.2f",
                                post.getCaption().trim(), post.getPicture().getSize()))
                                .append(System.lineSeparator());
                    });
        }

        return sb.toString();
    }
}
