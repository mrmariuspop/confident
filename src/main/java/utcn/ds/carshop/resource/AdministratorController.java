package utcn.ds.carshop.resource;

import org.springframework.web.bind.annotation.*;
import utcn.ds.carshop.dto.NewUserDTO;
import utcn.ds.carshop.dto.UpdateUserDTO;
import utcn.ds.carshop.model.User;
import utcn.ds.carshop.service.UserService;

import java.util.List;

@RestController
@RequestMapping("administration")
public class AdministratorController {

    private final UserService userService;

    public AdministratorController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/user")
    public User findById(@RequestParam(name = "id") long id){
        return userService.findById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody NewUserDTO newUserDTO) {
        return userService.registerUser(newUserDTO);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody UpdateUserDTO user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/user")
    public User deleteUserByUsername(@RequestParam("username") String username) {
        return userService.deleteByUsername(username);
    }

}
