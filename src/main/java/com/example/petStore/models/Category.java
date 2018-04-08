package com.example.petStore.models;

import com.example.petStore.models.seedwork.AbstractEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_CATEGORY")
public class Category extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "Category")
    private Set<Pet> pets = new HashSet<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
