package com.gestion.service.impl;

import com.gestion.modele.Salle;
import com.gestion.repository.SalleRepository;
import com.gestion.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleServiceImpl implements SalleService {
    @Autowired
    private SalleRepository salleRepository;

    @Override
    public Salle findSalleById(Long id) {
        return null;
    }

    @Override
    public List<Salle> findAll() {
        return salleRepository.findAll();
    }

    @Override
    public Salle save(Salle salle) {
        return salleRepository.save(salle);
    }

    @Override
    public void delete(Salle salle) {
        salleRepository.delete(salle);
    }

    @Override
    public Optional<Salle> findById(Long id) {
        return salleRepository.findById(id);
    }
}
