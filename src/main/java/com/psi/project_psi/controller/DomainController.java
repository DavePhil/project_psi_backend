package com.psi.project_psi.controller;

import com.psi.project_psi.models.Domain;
import com.psi.project_psi.models.Module;
import com.psi.project_psi.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DomainController {

    @Autowired
    DomainService domainService;

    @PostMapping("/domain")
    public Domain create(@RequestBody Domain domain){
        return domainService.create(domain);
    }

    @GetMapping("/domain/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        Optional<Domain> domain = domainService.getById(id);
        if (!domain.isPresent()) return new ResponseEntity<>("Ce module n'est pas présent", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(domain, HttpStatus.OK);
    }

    @GetMapping("/domains")
    public Iterable<Domain> getAll(){
        return domainService.getAll();
    }

    @DeleteMapping("/domain/{id}")
    public void delete(@PathVariable("id") Long id){
        domainService.deleteById(id);
    }
}
