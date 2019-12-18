package com.gestion.controller;

import com.gestion.exception.FilmNotFoundException;
import com.gestion.modele.Categorie;
import com.gestion.modele.CategorieSequences;
import com.gestion.service.CategorieService;
import com.gestion.utiles.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {

    @Autowired
    private final CategorieService categorieService;
    @Autowired
    private NextSequenceService<CategorieSequences> nextSequenceService;

    CategorieController(CategorieService service) {
        this.categorieService = service;
    }

    @GetMapping("cinema/categories")
    public List<Categorie> getCategories() {
         return categorieService.findAll();

    }

    @PostMapping("/cinema/categorie")
    public void newCategorie(@RequestBody Categorie categorie) {
        nextSequenceService.setTypeOfT(CategorieSequences.class);
        categorie.setId(nextSequenceService.getNextSequence("categorieSequences")); ;
        categorieService.save(categorie);
    }

    @PutMapping("cinema/categorie/{id}")
    public Categorie update(@RequestBody Categorie newCategorie, @PathVariable Long id) {
      return  categorieService.findById(id).map(
                categorie -> {
                    categorie.setType(newCategorie.getType());
                    return categorieService.save(categorie);
                }
        ).orElseGet(
                () -> {
                    newCategorie.setId(id);
                    return categorieService.save(newCategorie);
                }
        );
    }

    @GetMapping("cinema/categorie/{id}")
    public Categorie findOne(@PathVariable Long id) throws FilmNotFoundException {
        return categorieService.findById(id).orElseThrow(() -> new FilmNotFoundException(id));
    }


}