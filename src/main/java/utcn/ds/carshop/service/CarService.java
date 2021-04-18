package utcn.ds.carshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utcn.ds.carshop.model.Car;
import utcn.ds.carshop.repository.CarRepository;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllBooks() {
        return carRepository.findAll();
    }

    public Car createBook(Car carToBeSaved) {
        return carRepository.save(carToBeSaved);
    }
}
