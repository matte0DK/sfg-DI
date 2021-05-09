package matteo.springframework.sfgdi.services;

public class PrimaryGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "YELLOO -- from the Primary bean!";
    }
}
