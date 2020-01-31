package com.gestion.service.impl;

import com.gestion.modele.Categorie;
import com.gestion.repository.CategorieRepository;
import com.gestion.service.CategorieService;
import com.gestion.utiles.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private NextSequenceService nextSequenceService;



    @Override
    public Categorie findCategorieById(Long id) {
        return null;
    }

    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie save(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void delete(Categorie categorie) {
        categorieRepository.delete(categorie);
    }

    @Override
    public Optional<Categorie> findById(Long id) {
        return categorieRepository.findById(id);
    }
}
