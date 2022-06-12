package Application.DataAccessObject;

import Application.Models.Competence;
import Application.Models.Module;
import Application.Models.Projet;
import Application.Models.User;
import Application.Repository.ChefProjetRepository;
import Application.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Component
public class GestionProjetDAO {

    @Autowired
    private ChefProjetRepository chefProjetRepository;

    @Autowired
    private UserRepository userRepository;

    public Collection<Projet> RecuperListeProjet() {
        return chefProjetRepository.findAll();
    }


    public ResponseEntity<?> AjouterProjet(@Valid @RequestBody Projet projet) {
        Projet p = new Projet(projet.getTitre(),projet.getDateDebut(),projet.getDateFin(),projet.getDescription(),projet.getUser(),projet.getModuleList());
        List<Module> moduleList = new ArrayList<>();
        p.setModuleList(moduleList);
        chefProjetRepository.save(p);
        return new ResponseEntity<>(chefProjetRepository.save(p), HttpStatus.OK);
    }





    public ResponseEntity<?> ModifierProjet(@PathVariable("id") String id, @RequestBody Projet projet) {
        Optional<Projet> projetOptional = chefProjetRepository.findById(id);
        if (projetOptional.isPresent()) {
            Projet p = projetOptional.get();
            p.setTitre(projet.getTitre());
            p.setDateDebut(projet.getDateDebut());
            p.setDateFin(projet.getDateFin());
            p.setDescription(projet.getDescription());
            p.setUser(projet.getUser());
            List<Module> moduleList = new ArrayList<>();
            p.setModuleList(moduleList);
            return new ResponseEntity<>(chefProjetRepository.save(p), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    public ResponseEntity<?> SupprimerProjet(@PathVariable("id") String id) {
        try {
            chefProjetRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
