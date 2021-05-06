package matteo.springframework.sfgdi.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String sayHello() {
        System.out.println("YELLOO");
        return "I have no inspiration right now";
    }
}
