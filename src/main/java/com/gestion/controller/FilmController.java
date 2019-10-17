package com.gestion.controller;

import com.gestion.exception.FilmNotFoundException;
import com.gestion.modele.Film;
import com.gestion.repository.FilmRepository;
import com.gestion.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class FilmController {

    @Autowired
    private final FilmService filmService;

    FilmController(FilmService service) {
        this.filmService = service;
    }

    @GetMapping("/cinema/Films")
    public List<Film> getFilms() {
         return filmService.findAll();

    }

    @PostMapping("cinema/film")
    public void newFilm(@RequestBody Film film) {
         filmService.save(film);
    }

    @PutMapping("cinema/film/{id}")
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