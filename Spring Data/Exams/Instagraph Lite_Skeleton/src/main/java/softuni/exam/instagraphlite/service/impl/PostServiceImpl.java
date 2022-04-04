package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dtos.postsDTOs.CreatePostDTO;
import softuni.exam.instagraphlite.models.dtos.postsDTOs.PostsFactoryDTO;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepo;
    private final PictureRepository pictureRepo;
    private final UserRepository userRepo;
    private final Validator validator;
    private final ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepo, PictureRepository pictureRepo, UserRepository userRepo, Validator validator, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.pictureRepo = pictureRepo;
        this.userRepo = userRepo;

        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.postRepo.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        File postsFile = new File(POSTS_FILE_PATH);

        JAXBContext jaxbContext = JAXBContext.newInstance(PostsFactoryDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        PostsFactoryDTO postsFactoryDTO = (PostsFactoryDTO)unmarshaller.unmarshal(postsFile);

        List<CreatePostDTO> postDTOs = postsFactoryDTO.getPosts();

        Set<Post> toImport = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (CreatePostDTO dto : postDTOs) {
            Set<ConstraintViolation<CreatePostDTO>> errorSet = validator.validate(dto);
            if (!errorSet.isEmpty()) {
                sb.append("Invalid Post").append(System.lineSeparator());
                continue;
            }

            Optional<Picture> picOpt = this.pictureRepo.findByPath(dto.getPicture().getPath());
            Optional<User> userOpt = this.userRepo.findByUsername(dto.getUser().getUsername());
            if (picOpt.isEmpty() || userOpt.isEmpty()) {
                sb.append("Invalid Post").append(System.lineSeparator());
                continue;
            }

            Optional<Post> postOpt = this.postRepo.findByUserAndPicture(userOpt.get(), picOpt.get());
            if (postOpt.isPresent()) {
                sb.append("Invalid Post").append(System.lineSeparator());
                continue;
            }

            Post post = modelMapper.map(dto, Post.class);

            post.setPicture(picOpt.get());
            post.setUser(userOpt.get());

            toImport.add(post);

            sb.append(String.format("Successfully imported Post, made by %s", post.getUser().getUsername()))
                    .append(System.lineSeparator());

        }

        this.postRepo.saveAll(toImport);

        return sb.toString();
    }
}
