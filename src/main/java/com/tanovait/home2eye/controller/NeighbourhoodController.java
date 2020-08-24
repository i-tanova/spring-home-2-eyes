package com.tanovait.home2eye.controller;

import com.tanovait.home2eye.model.Neighbourhood;
import com.tanovait.home2eye.model.Property;
import com.tanovait.home2eye.repository.NeighbourhoodRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/neighbourhood")
public class NeighbourhoodController {

    private NeighbourhoodRepository neighbourhoodRepository;

    public NeighbourhoodController(NeighbourhoodRepository neighbourhoodRepository) {
        this.neighbourhoodRepository = neighbourhoodRepository;
    }

    @GetMapping
    public List<Neighbourhood> getAll() {
        return neighbourhoodRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Neighbourhood> add(UriComponentsBuilder ucBuilder, @RequestBody Neighbourhood neighbourhood) {
        Neighbourhood newNeighbourhood = neighbourhoodRepository.save(neighbourhood);
        return ResponseEntity.created(ucBuilder.path("/neighbourhood/{cityId}").buildAndExpand(newNeighbourhood.getId()).toUri()).build();
    }
}
