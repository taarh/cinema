package com.gestion.service;

import com.gestion.modele.Categorie;

import java.util.List;
import java.util.Optional;


public interface CategorieService {
     Categorie findCategorieById(Long id);
     List<Categorie> findAll();
     Categorie save(Categorie categorie);
     void delete(Categorie categorie);
     Optional<Categorie>findById(Long id);
}
