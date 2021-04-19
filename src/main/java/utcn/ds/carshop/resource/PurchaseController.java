package utcn.ds.carshop.resource;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utcn.ds.carshop.service.CarService;

@RestController
@RequestMapping("buy")
public class PurchaseController {

    private final CarService carService;

    public PurchaseController(CarService carService) {
        this.carService = carService;
    }

    @PutMapping
    public String buyCar(@RequestParam(name = "useranme") String username,
                         @RequestParam(name = "carId") long carId) {
        carService.buyCar(username, carId);
        return "Masina cu id-ul " + carId + " a fost vanduta catre persoana " + username;
    }
}
