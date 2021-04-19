package utcn.ds.carshop.service;

import org.springframework.stereotype.Service;
import utcn.ds.carshop.dto.NewUserDTO;
import utcn.ds.carshop.dto.UpdateUserDTO;
import utcn.ds.carshop.model.User;
import utcn.ds.carshop.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User registerUser(NewUserDTO newUserDTO) {
        User userToBeSaved = new User();
        userToBeSaved.setUsername(newUserDTO.getUsername());
        userToBeSaved.setPassword(newUserDTO.getPassword());
        userToBeSaved.setLastName(newUserDTO.getLastName());
        userToBeSaved.setFirstName(newUserDTO.getFirstName());
        userToBeSaved.setWalletAmount(0);
       return userRepository.save(userToBeSaved);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User updateUser(UpdateUserDTO updateUserDTO) {
        User oldUser = userRepository.findById(updateUserDTO.getId());
        oldUser.setPassword(updateUserDTO.getPassword());
        oldUser.setFirstName(updateUserDTO.getFirstName());
        oldUser.setLastName(updateUserDTO.getLastName());
        oldUser.setWalletAmount(updateUserDTO.getWalletAmmount());
        return userRepository.save(oldUser);
    }

    public User findById(long id) {
        return userRepository.findById(id);
    }

    public User deleteByUsername(String username) {
        User userToBeDeleted = userRepository.findByUsername(username);
        userRepository.delete(userToBeDeleted);
        return userToBeDeleted;
    }
}
