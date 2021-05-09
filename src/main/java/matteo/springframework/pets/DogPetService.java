package matteo.springframework.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dog")
@Service("petService")
public class DogPetService implements PetService {
    @Override
    public String getPetType() {
        return "Dogs are the second best!";
    }
}
