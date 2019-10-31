package com.gestion.service;

import com.gestion.modele.Programme;

import java.util.List;
import java.util.Optional;

public interface ProgrammeService {

    Programme findProgrammeById(Long id);
    List<Programme> findAll();
    Programme save(Programme programme);
    void delete(Programme programme);
    Optional<Programme> findById(Long id);
    List<Programme> findProgrammeByCategories(String categorie);



}
