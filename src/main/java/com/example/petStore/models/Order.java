package com.example.petStore.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_ORDER")
public class Order {

    @Column(name = "orderId")
    private Integer orderId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "shipDate")
    private Timestamp shipDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    private Pet pet;

    @Column(name = "complete")
    private boolean compelte;

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Set<Pet> getPets() {
        return pets;
    }
    public void setPets(Set<Pet> pets) {
        this.pets = pets;
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

    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public boolean isCompelte() {
        return compelte;
    }
    public void setCompelte(boolean compelte) {
        this.compelte = compelte;
    }
}
