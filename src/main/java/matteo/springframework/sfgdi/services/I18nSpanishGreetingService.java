package matteo.springframework.sfgdi.services;

public class I18nSpanishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Buenos dias! - ES";
    }
}
