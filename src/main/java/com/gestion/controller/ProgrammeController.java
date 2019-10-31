package com.gestion.controller;

import com.gestion.exception.ProgrammeNotFoundException;
import com.gestion.modele.Programme;
import com.gestion.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgrammeController {
    @Autowired
    ProgrammeService programmeService;

    ProgrammeController(ProgrammeService service) {
        this.programmeService = service;
    }

    @GetMapping("/cinema/programmes")
    public List<Programme> getProgrammes() {
        return programmeService.findAll();
    }
    @PostMapping("cinema/programme")
    public void newProgramme(@RequestBody Programme programme) {
        programmeService.save(programme);
    }

    @PutMapping("cinema/programme/{id}")
    public Programme update(@RequestBody Programme newProgramme, @PathVariable Long id) {
        return  programmeService.findById(id).map(
                programme -> {
                    programme.setDateDebut(newProgramme.getDateDebut());
                    programme.setDateFin(newProgramme.getDateFin());
                    programme.setFilm(newProgramme.getFilm());
                    programme.setSalle(newProgramme.getSalle());
                    return programmeService.save(programme);
                }
        ).orElseGet(
                () -> {
                    newProgramme.setId(id);
                    return programmeService.save(newProgramme);
                }
        );
    }
    @GetMapping("cinema/programme/{id}")
    public Programme findOne(@PathVariable Long id) throws ProgrammeNotFoundException {
        return programmeService.findById(id).orElseThrow(() -> new ProgrammeNotFoundException(id));
    }
    @GetMapping("cinema/programme/categories/{categorie}")
    public List<Programme>findProgrammeByCategories( @PathVariable String categorie){
            return  programmeService.findProgrammeByCategories(categorie);
    }




}
