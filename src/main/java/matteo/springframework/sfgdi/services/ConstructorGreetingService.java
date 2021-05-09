package matteo.springframework.sfgdi.services;

public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "YELLOO __ Constructor";
    }
}
