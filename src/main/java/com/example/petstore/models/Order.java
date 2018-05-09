package com.example.petstore.models;

import com.example.petstore.models.enums.OrderStatus;
import com.example.petstore.models.seedwork.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_ORDER")
public class Order extends AbstractEntity {

    @RestResource(exported = false)
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "ship_date")
    private Timestamp shipDate;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    @Column(name = "complete")
    private boolean complete;

    @JsonIgnore
    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
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

    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

}