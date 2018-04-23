package com.example.petstore.models;

import com.example.petstore.models.seedwork.AbstractEntity;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_ORDER")
public class Order extends AbstractEntity {

<<<<<<< HEAD
    @RestResource(exported = false)
    @ManyToOne
    @JoinColumn(name = "petId")
    private Pet pet;
=======
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<Pet> pet = new HashSet<>();
>>>>>>> parent of 575d10b... 21.04.2018 20:00

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "shipDate")
    private Timestamp shipDate;

    private enum OrderStatus{
        placed,
        approved,
        delivered
    }

    @Column(name = "complete")
    private boolean complete;

<<<<<<< HEAD
    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
=======
    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
>>>>>>> parent of 575d10b... 21.04.2018 20:00
        this.pet = pet;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Timestamp getShipDate() {
        return shipDate;
    }
    public void setShipDate(Timestamp shipDate) {
        this.shipDate = shipDate;
    }

    public boolean isComplete() {
        return complete;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

}
