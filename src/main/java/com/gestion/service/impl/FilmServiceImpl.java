package com.gestion.service.impl;

import com.gestion.modele.Film;
import com.gestion.repository.FilmRepository;
import com.gestion.service.FilmService;
import com.gestion.utiles.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private NextSequenceService nextSequenceService;

    @Override
    public Film findFilmById(Long id) {
        return null;
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film save(Film film) {
        film.setId(nextSequenceService.getNextSequence("filmSequences"));
        return filmRepository.save(film);
    }

    @Override
    public void delete(Film film) {
        filmRepository.delete(film);
    }

    @Override
    public Optional<Film> findById(Long id) {
        return filmRepository.findById(id);
    }
}
