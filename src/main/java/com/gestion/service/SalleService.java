package com.gestion.service;

import com.gestion.modele.Salle;

import java.util.List;
import java.util.Optional;

public interface SalleService {

    Salle findSalleById(Long id);
    List<Salle> findAll();
    Salle save(Salle salle);
    void delete(Salle salle);
    Optional<Salle> findById(Long id);
}
