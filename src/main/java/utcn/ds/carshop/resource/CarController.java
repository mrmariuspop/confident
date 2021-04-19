package utcn.ds.carshop.resource;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import utcn.ds.carshop.dto.NewCarDTO;
import utcn.ds.carshop.dto.UpdateCarDTO;
import utcn.ds.carshop.model.Car;
import utcn.ds.carshop.service.CarService;

import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<Car> findAll() {
        return carService.findAll();
    }

    @PostMapping("/car")
    public Car insertCar(@RequestParam(name = "type") String type,
                         @RequestParam(name = "model") String model,
                         @RequestParam(name = "price") long price,
                         @RequestParam(name = "year") long year,
                         @RequestParam(name = "details") String details,
                         @RequestParam(name = "image") MultipartFile image) {
        NewCarDTO newCarDTO = new NewCarDTO(type, model, price, year, details, Paths.get(image.getOriginalFilename()).toAbsolutePath().toString());
        return carService.createCar(newCarDTO);
    }

    @PutMapping("/car")
    public Car updateCar(@RequestBody UpdateCarDTO updateCarDTO) {
        return carService.updateCar(updateCarDTO);
    }

    @DeleteMapping("/car")
    public Car deleteCarById(@RequestParam(name = "id") long id) {
        return carService.deleteById(id);
    }

    @GetMapping("/containing")
    public List<Car> findByDetails(@RequestParam(name = "titleContaining") String titleContaining) {
        return carService.findByDetails(titleContaining);
    }

    @GetMapping("/status")
    public List<Car> findByStatus(@RequestParam(name = "status") String status) throws Exception {
        List<Car> byStatus = carService.findByStatus(status);
        return byStatus;
    }
}