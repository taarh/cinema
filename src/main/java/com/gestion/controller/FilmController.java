package com.gestion.controller;

import com.gestion.exception.FilmNotFoundException;
import com.gestion.modele.Film;
import com.gestion.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class FilmController {

    private final FilmRepository filmRepository;

    FilmController(FilmRepository repository) {
        this.filmRepository = repository;
    }

    @GetMapping("/cinema/Films")
    public List<Film> getFilms() {
         return filmRepository.findAll();

    }

    @PostMapping("cinema/film")
    public Film newFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }

    @PutMapping("cinema/film/{id}")
    public Film update(@RequestBody Film newFilm, @PathVariable Long id) {
      return  filmRepository.findById(id).map(
                film -> {
                    film.setAuteur(newFilm.getAuteur());
                    film.setDuree(newFilm.getDuree());
                    film.setTitre(newFilm.getTitre());
                    return filmRepository.save(film);
                }
        ).orElseGet(
                () -> {
                    newFilm.setId(id);
                    return filmRepository.save(newFilm);
                }
        );
    }

    @GetMapping("cinema/film/{id}")
    public Film findOne(@PathVariable Long id) throws FilmNotFoundException {
        return filmRepository.findById(id).orElseThrow(() -> new FilmNotFoundException(id));
    }


}