package lab_exercises.services;

import lab_exercises.models.User;
import lab_exercises.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public void registerUser(User user) {

        User result = userRepo.getByUsername(user.getUsername());

        if(result == null) {
            userRepo.save(user);
        }
    }
}
