package com.gestion.service.impl;

import com.gestion.modele.Programme;
import com.gestion.repository.ProgrammeRepository;
import com.gestion.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammeServiceImpl implements ProgrammeService {
    @Autowired
    private ProgrammeRepository programmeRepository;

    @Override
    public Programme findProgrammeById(Long id) {
        return null;
    }

    @Override
    public List<Programme> findAll() {
        return programmeRepository.findAll();
    }

    @Override
    public Programme save(Programme programme) {
        return programmeRepository.save(programme);
    }

    @Override
    public void delete(Programme programme) {
        programmeRepository.delete(programme);
    }

    @Override
    public Optional<Programme> findById(Long id) {
        return programmeRepository.findById(id);
    }

}
