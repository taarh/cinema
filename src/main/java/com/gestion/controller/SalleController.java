package com.gestion.controller;

import com.gestion.exception.SalleNotFoundException;
import com.gestion.modele.Salle;
import com.gestion.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SalleController {

    @Autowired
    private final SalleService salleService;

    SalleController(SalleService service) {
        this.salleService = service;
    }

    @GetMapping("/cinema/salles")
    public List<Salle> getSalles() {
         return salleService.findAll();

    }

    @PostMapping("cinema/salle")
    public void newSalle(@RequestBody Salle salle) {
         salleService.save(salle);
    }

    @PutMapping("cinema/salle/{id}")
    public Salle update(@RequestBody Salle newSalle, @PathVariable Long id) {
      return  salleService.findById(id).map(
                salle -> {
                    salle.setSale_name(newSalle.getSale_name());
                    salle.setSalle_nbrePieces(newSalle.getSalle_nbrePieces());
                    salle.setSale_adresse(newSalle.getSale_adresse());
                    return salleService.save(salle);
                }
        ).orElseGet(
                () -> {
                    newSalle.setId(id);
                    return salleService.save(newSalle);
                }
        );
    }

    @GetMapping("cinema/salle/{id}")
    public Salle findOne(@PathVariable Long id) throws SalleNotFoundException {
        return salleService.findById(id).orElseThrow(() -> new SalleNotFoundException(id));
    }


}