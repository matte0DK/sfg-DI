package matteo.springframework.sfgdi.controllers;

import matteo.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectionController {
    @Autowired
    public @Qualifier("propertyGreetingService")
    GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
