package com.tanovait.home2eye.repository;

import com.tanovait.home2eye.model.City;
import com.tanovait.home2eye.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
