package com.tanovait.home2eye.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private Set<Neighbourhood> neighbourhoodsSet = new HashSet<>();

    public void addNeighbourhood(Neighbourhood neighbourhood){
        this.neighbourhoodsSet.add(neighbourhood);
        neighbourhood.setCity(this);
    }

    public void removeNeighbourhood(Neighbourhood neighbourhood){
        this.neighbourhoodsSet.remove(neighbourhood);
        neighbourhood.setCity(null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Neighbourhood> getNeighbourhoodsSet() {
        return neighbourhoodsSet;
    }

    public void setNeighbourhoodsSet(Set<Neighbourhood> neighbourhoodsSet) {
        this.neighbourhoodsSet = neighbourhoodsSet;
    }
}
