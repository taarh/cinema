package com.gestion.service;

import com.gestion.modele.Film;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface FilmService {
     Film findFilmById(Long id);
     List<Film> findAll();
     Film save(Film film);
     void delete(Film film);
     Optional<Film>findById(Long id);
}
