package utcn.ds.carshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utcn.ds.carshop.dto.NewCarDTO;
import utcn.ds.carshop.dto.UpdateCarDTO;
import utcn.ds.carshop.model.Car;
import utcn.ds.carshop.model.User;
import utcn.ds.carshop.repository.CarRepository;
import utcn.ds.carshop.repository.UserRepository;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final UserRepository userRepository;

    @Autowired
    public CarService(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car createCar(NewCarDTO newCarDTO) {
        Car carToBeSaved = new Car();
        carToBeSaved.setType(newCarDTO.getType());
        carToBeSaved.setModel(newCarDTO.getModel());
        carToBeSaved.setPrice(newCarDTO.getPrice());
        carToBeSaved.setYear(newCarDTO.getYear());
        carToBeSaved.setDetails(newCarDTO.getDetails());
        carToBeSaved.setImage(newCarDTO.getImage());
        carToBeSaved.setStatus("ACTIVE");
        return carRepository.save(carToBeSaved);
    }

    public Car updateCar(UpdateCarDTO updateCarDTO) {
        Car oldCar = carRepository.findById(updateCarDTO.getId());
        oldCar.setPrice(updateCarDTO.getPrice());
        oldCar.setDetails(updateCarDTO.getDetails());
        oldCar.setStatus(updateCarDTO.getStatus());
        carRepository.save(oldCar);
        return oldCar;
    }

    public Car deleteById(long id) {
        Car carToBeDeleted = carRepository.findById(id);
        carRepository.delete(carToBeDeleted);
        return carToBeDeleted;
    }

    public List<Car> findByDetails(String titleContaining) {
        try {
            Long.parseLong(titleContaining);
            return carRepository.findByYear(Long.parseLong(titleContaining));
        } catch (NumberFormatException e) {
            return carRepository.findByTypeContainingIgnoreCase(titleContaining);
        } finally {
            //do nothing for now
        }
    }

    public List<Car> findByStatus(String status) {
        return carRepository.findByStatus(status);
    }

    public void buyCar(String username, long carId) {
        Car byId = carRepository.findById(carId);
        if (byId.getStatus().equals("SOLD")) {
            throw new RuntimeException("Can not sell a car which is already sold");
        }
        byId.setStatus("SOLD");

        User byUsername = userRepository.findByUsername(username);
        if (byUsername.getWalletAmount() - byId.getPrice() < 0) {
            throw new RuntimeException("User doesn`t have enough money to buy this car");
        }
        byUsername.setWalletAmount(byUsername.getWalletAmount() - byId.getPrice());
        carRepository.save(byId);
        userRepository.save(byUsername);
    }

}
