package softuni.exam.instagraphlite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private PictureService pictureService;
    private UserService userService;
    private PostService postService;

    @Autowired
    public ConsoleRunner(PictureService pictureService, UserService userService, PostService postService) {
        this.pictureService = pictureService;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public void run(String... args) throws Exception {

//        this.userService.exportUsersWithTheirPosts();
//        this.pictureService.exportPictures();
    }
}
