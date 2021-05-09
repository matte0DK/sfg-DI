package matteo.springframework.sfgdi.services;

public class SetterGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "YELLOO __ Setter";
    }
}
