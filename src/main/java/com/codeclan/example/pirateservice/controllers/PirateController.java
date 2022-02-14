package com.codeclan.example.pirateservice.controllers;
import com.codeclan.example.pirateservice.models.Pirate;
import com.codeclan.example.pirateservice.repositories.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

// File responsible for all routes for pirates
@RestController
public class PirateController {

    // CRUD
    // GET - Return all the pirates, all the list
    @Autowired
    PirateRepository pirateRepository;

    // get requests - set specific route
    @GetMapping(value = "/pirates")
    // Fire when the particular route is hit - will return a list, not an arrayList
    public List<Pirate> getAllPirates() {
        return pirateRepository.findAll();
    }

    // GET one
    @GetMapping(value = "/pirates/{id}")
    // Optional - handle multiple outcomes; Optional<type pirate>; Long match with id
    public Optional<Pirate> getPirate(@PathVariable Long id) {
        return pirateRepository.findById(id);
    }

}
