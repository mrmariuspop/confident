package utcn.ds.carshop.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {


    @Autowired
    public HelloWorldController() {
    }

    @GetMapping
    public String printHello() {
        return "Hello World";
    }

}