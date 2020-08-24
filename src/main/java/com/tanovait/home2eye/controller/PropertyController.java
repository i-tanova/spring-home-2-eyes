package com.tanovait.home2eye.controller;

import com.tanovait.home2eye.model.Property;
import com.tanovait.home2eye.repository.PropertyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private PropertyRepository propertyRepository;

    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @GetMapping
    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

}
