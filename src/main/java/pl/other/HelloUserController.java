package pl.other;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloUserController {

    @RequestMapping(value = "/showForm")
    public String showForm(){
        return "hellouser-form";
    }
}
