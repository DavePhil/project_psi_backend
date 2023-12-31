package com.psi.project_psi.controller;

import com.psi.project_psi.models.Competences;
import com.psi.project_psi.models.Module;
import com.psi.project_psi.service.CompetencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CompetencesController {

    @Autowired
    private CompetencesService competencesService;

    @PostMapping("/competence")
    public Competences create(@RequestBody Competences competence){
        return competencesService.create(competence);
    }

    @GetMapping("/competence/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        Optional<Competences> competences = competencesService.getById(id);
        if (!competences.isPresent()) return new ResponseEntity<>("Cette compétence n'est pas présente", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(competences, HttpStatus.OK);
    }

    @GetMapping("/competences")
    public Iterable<Competences> getAll(){
        return competencesService.getAll();
    }

    @DeleteMapping("/competence/{id}")
    public void delete(@PathVariable("id") Long id){
        competencesService.deleteById(id);
    }
}
