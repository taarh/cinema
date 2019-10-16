package com.gestion.service.impl;

import com.gestion.modele.Film;
import com.gestion.repository.FilmRepository;
import com.gestion.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class FilmServiceImpl implements FilmService {

    FilmRepository filmRepository;

    @Override
    public Film findFilmById(Long id) {
        return null;
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public void save(Film film) {
        filmRepository.save(film);
    }

    @Override
    public void delete(Film film) {
        filmRepository.delete(film);
    }
}
