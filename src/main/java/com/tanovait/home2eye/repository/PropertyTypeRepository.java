package com.tanovait.home2eye.repository;

import com.tanovait.home2eye.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {

    Optional<PropertyType> findByName(String name);
}
