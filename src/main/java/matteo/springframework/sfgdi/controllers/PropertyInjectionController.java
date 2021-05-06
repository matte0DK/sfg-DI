package matteo.springframework.sfgdi.controllers;

import matteo.springframework.sfgdi.services.GreetingService;

public class PropertyInjectionController {
    public GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
