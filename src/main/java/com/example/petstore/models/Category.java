package com.example.petstore.models;

import com.example.petstore.models.seedwork.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_CATEGORY")
public class Category extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Pet> pets = new HashSet<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Set<Pet> getPets() {
        return pets;
    }
    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

}
