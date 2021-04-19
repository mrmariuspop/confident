package utcn.ds.carshop.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utcn.ds.carshop.model.Car;
import utcn.ds.carshop.service.CarService;
import utcn.ds.carshop.utils.Export;

import java.util.List;

@RestController
@RequestMapping("export")
public class ExportController {

    private final CarService carService;

    public ExportController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/status")
    public List<Car> findByStatus(@RequestParam(name = "status") String status,
                                  @RequestParam(name = "pdf/html") String reportType) throws Exception {
        List<Car> byStatus = carService.findByStatus(status);
        if (reportType.equals("pdf")) {
            Export.buildPdf(byStatus);
        }
        else if (reportType.equals("html")) {
            Export.buildHtml(byStatus);
        }
        else throw new RuntimeException("Report type must be pdf or html");
        return byStatus;
    }
}
