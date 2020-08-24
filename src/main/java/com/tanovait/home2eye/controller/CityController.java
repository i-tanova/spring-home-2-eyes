package com.tanovait.home2eye.controller;

import com.tanovait.home2eye.model.City;
import com.tanovait.home2eye.model.Neighbourhood;
import com.tanovait.home2eye.repository.CityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/city")
public class CityController {

    private CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<City> getCity(@PathVariable Long cityId) {
        Optional<City> city = cityRepository.findById(cityId);
        return city.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<City> create(UriComponentsBuilder ucBuilder, @RequestBody City city){
        City newCity = cityRepository.save(city);
        return ResponseEntity.
                created(ucBuilder.path("/city/{cityId}").buildAndExpand(newCity.getId()).toUri()).build();
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<City> delete(@PathVariable Long cityId) {
        try {
            cityRepository.deleteById(cityId);
        }finally {
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<City> addNeighbourhood(@PathVariable Long cityId, UriComponentsBuilder ucBuilder, @RequestBody Neighbourhood neighbourhood){
        Optional<City> city = cityRepository.findById(cityId);
        if(city.isPresent()){
            City newCity = city.get();
            newCity.addNeighbourhood(neighbourhood);
            return ResponseEntity.
                    created(ucBuilder.path("/city/{cityId}").buildAndExpand(newCity.getId()).toUri()).build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{cityId}/neighbourhood")
    public ResponseEntity<Set<Neighbourhood>> getNeighbourhood(@PathVariable Long cityId) {
        Optional<City> city = cityRepository.findById(cityId);
        if(city.isPresent()){
            return ResponseEntity.ok(city.get().getNeighbourhoodsSet());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
