package matteo.springframework.sfgdi.config;

import matteo.springframework.pets.PetService;
import matteo.springframework.pets.PetServiceFactory;
import matteo.springframework.sfgdi.datasource.FakeDataSource;
import matteo.springframework.sfgdi.repositories.EnglishGreetingRepository;
import matteo.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import matteo.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/*@PropertySource("classpath:datasource.properties")*/
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${matteo.username}") String username,
                                  @Value("${matteo.password}")String password,
                                  @Value("${matteo.jdbcUrl}")String jdbcUrl) {

        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"cat", "default"})
    @Bean/*("petService")*/
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }


    @Profile("dog")
    @Bean/*("petService")*/
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }


    @Profile("ES")
    @Bean("i18nService")
    I18nSpanishGreetingService i18NSpanishService() {
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    /*@Bean*/
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyGreetingService propertyGreetingService() {
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() {
        return new SetterGreetingService();
    }
}
