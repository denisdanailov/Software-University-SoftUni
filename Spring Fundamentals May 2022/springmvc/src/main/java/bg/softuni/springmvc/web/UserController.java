package bg.softuni.springmvc.web;

import bg.softuni.springmvc.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

  @GetMapping("/newuser")
  public String newUser() {
    return "newuser";
  }


  @PostMapping("/newuser")
  public String regUser(UserDTO userDTO, Model model) {

    model.addAttribute("newUser", userDTO);

    return "usercreated";
  }

  @PostMapping("/usercreated")
  public String createUser(UserDTO userDTO, Model model) {


    model.addAttribute("newUser", userDTO);

    System.out.println("Creating new user... " + userDTO);

    return "user/usercreated";
  }

  @ModelAttribute("newUser")
  public UserDTO userDTO(){
    return new UserDTO();
  }
}
