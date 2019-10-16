package com.gestion.service;

import com.gestion.modele.Film;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmService {
     Film findFilmById(Long id);
     List<Film> findAll();
     void save(Film film);
     void delete(Film film);
}
