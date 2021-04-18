package utcn.ds.carshop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utcn.ds.carshop.model.Car;
import utcn.ds.carshop.service.CarService;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<Car> getAllBooks() {
        return carService.getAllBooks();
    }

    @PostMapping("/car")
    public Car insertBook(@RequestBody Car carToBeSaved) {
        return carService.createBook(carToBeSaved);
    }
}