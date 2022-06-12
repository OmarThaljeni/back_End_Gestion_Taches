package Application.Repository;

import Application.Models.Projet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChefProjetRepository extends MongoRepository<Projet, String> {

}
