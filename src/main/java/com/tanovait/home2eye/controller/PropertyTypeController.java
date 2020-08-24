package com.tanovait.home2eye.controller;

import com.tanovait.home2eye.model.PropertyType;
import com.tanovait.home2eye.repository.PropertyTypeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/property_type")
public class PropertyTypeController {

    private PropertyTypeRepository propertyTypeRepository;

    public PropertyTypeController(PropertyTypeRepository propertyTypeRepository) {
        this.propertyTypeRepository = propertyTypeRepository;
    }

    @GetMapping
    public List<PropertyType> getAll() {
        return propertyTypeRepository.findAll();
    }
}
