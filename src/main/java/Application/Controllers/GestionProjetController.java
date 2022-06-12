package Application.Controllers;


import Application.Models.Projet;
import Application.Services.GestionProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/GestionProjet")
public class GestionProjetController {
    @Autowired
    private GestionProjetService gestionProjetService;


    @GetMapping("/RecuperListeProjet")
    public Collection<Projet> RecuperListeProjet() {
        return gestionProjetService.RecuperListeProjet();
    }

    @PostMapping("/AjouterProjet")
    public ResponseEntity<?> AjouterProjet(@Valid @RequestBody Projet projet) {
        return gestionProjetService.AjouterProjet(projet);
    }

    @PutMapping("/ModifierProjet/{id}")
    public ResponseEntity<?> ModifierProjet(@PathVariable("id") String id, @RequestBody Projet projet) {
        return gestionProjetService.ModifierProjet(id,projet);
    }

    @DeleteMapping("/SupprimerProjet/{id}")
    public ResponseEntity<?> SupprimerProjet(@PathVariable("id") String id) {
        return gestionProjetService.SupprimerProjet(id);
    }


}
