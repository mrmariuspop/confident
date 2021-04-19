package utcn.ds.carshop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class TestController {


    @Autowired
    public TestController() {
    }

    @GetMapping
    public String printHello() {
        return "Hello World";
    }

}