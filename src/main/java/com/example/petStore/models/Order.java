package com.example.petStore.models;

import com.example.petStore.models.seedwork.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_ORDER")
public class Order extends AbstractEntity {

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order", nullable = false)
    private Set<Pet> pet = new HashSet<>();

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

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
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
