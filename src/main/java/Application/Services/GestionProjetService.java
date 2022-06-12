package Application.Services;


import Application.DataAccessObject.GestionProjetDAO;
import Application.Models.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Collection;

@Service
public class GestionProjetService {

    @Autowired
    private GestionProjetDAO gestionProjetDAO;

    public Collection<Projet> RecuperListeProjet() {
        return gestionProjetDAO.RecuperListeProjet();
    }


    public ResponseEntity<?> AjouterProjet(@Valid @RequestBody Projet projet) {
        return gestionProjetDAO.AjouterProjet(projet);
    }

    public ResponseEntity<?> ModifierProjet(@PathVariable("id") String id, @RequestBody Projet projet) {
        return gestionProjetDAO.ModifierProjet(id,projet);
    }


    public ResponseEntity<?> SupprimerProjet(@PathVariable("id") String id) {
        return gestionProjetDAO.SupprimerProjet(id);
    }


}
