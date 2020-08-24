package com.tanovait.home2eye.repository;

import com.tanovait.home2eye.model.Neighbourhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeighbourhoodRepository extends JpaRepository<Neighbourhood, Long> {
}
