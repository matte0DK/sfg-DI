package matteo.springframework.sfgdi.services;

public class PropertyGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "YELLOO __ Property";
    }
}
