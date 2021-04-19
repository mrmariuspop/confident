package utcn.ds.carshop.resource;

import org.springframework.web.bind.annotation.*;
import utcn.ds.carshop.dto.NewUserDTO;
import utcn.ds.carshop.model.User;
import utcn.ds.carshop.service.UserService;

import java.util.List;

@RestController
@RequestMapping("authorization")
public class AuthorizationController {

    private final UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/login")
    public User findByUsername(@RequestParam(name = "username") String username) {
        return userService.findByUsername(username);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody NewUserDTO newUserDTO) {
        return userService.registerUser(newUserDTO);
    }
}
