package com.psi.project_psi.controller;


import com.psi.project_psi.models.Project;
import com.psi.project_psi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/project")
    public Project create(@RequestBody Project project){
        return projectService.create(project);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<?> getById (@PathVariable("id") Long id){
        Optional<Project> project = projectService.getById(id);
        if (!project.isPresent()) return new ResponseEntity<>("Ce projet n'existe pas", HttpStatus.OK);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping("/projects")
    public Iterable<Project> getAll (){
        Iterable<Project> projects = projectService.getAll();
        return projects;
    }

    @DeleteMapping("/project/{id}")
    public void delete(@PathVariable("id") Long id){
        projectService.deleteById(id);
    }
}
