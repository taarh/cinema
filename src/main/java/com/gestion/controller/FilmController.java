package com.gestion.controller;

import com.gestion.exception.FilmNotFoundException;
import com.gestion.modele.CategorieSequences;
import com.gestion.modele.Film;
import com.gestion.modele.FilmSequences;
import com.gestion.repository.FilmRepository;
import com.gestion.service.FilmService;
import com.gestion.utiles.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FilmController {

    @Autowired
    private final FilmService filmService;
    @Autowired
    private NextSequenceService<FilmSequences> nextSequenceService;

    FilmController(FilmService service) {
        this.filmService = service;
    }

    @GetMapping("/cinema/films")
    public List<Film> getFilms() {
         return filmService.findAll();

    }

    @PostMapping("/cinema/film")
    public void newFilm(@RequestBody Film film) {
        nextSequenceService.setTypeOfT(FilmSequences.class);
        film.setId(nextSequenceService.getNextSequence("filmSequences")); ;
        filmService.save(film);
    }

    @PutMapping("/cinema/film/{id}")
    public Film update(@RequestBody Film newFilm, @PathVariable Long id) {
      return  filmService.findById(id).map(
                film -> {
                    film.setAuteur(newFilm.getAuteur());
                    film.setDuree(newFilm.getDuree());
                    film.setTitre(newFilm.getTitre());
                    return filmService.save(film);
                }
        ).orElseGet(
                () -> {
                    newFilm.setId(id);
                    return filmService.save(newFilm);
                }
        );
    }

    @GetMapping("cinema/film/{id}")
    public Film findOne(@PathVariable Long id) throws FilmNotFoundException {
        return filmService.findById(id).orElseThrow(() -> new FilmNotFoundException(id));
    }


}