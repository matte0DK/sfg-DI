package matteo.springframework.sfgdi.services;

public class I18nEnglishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello there - EN";
    }
}
