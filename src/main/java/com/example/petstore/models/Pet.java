package com.example.petstore.models;

import com.example.petstore.models.enums.PetStatus;
import com.example.petstore.models.seedwork.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_PET")
public class Pet extends AbstractEntity{

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pet")
    private Set<Order> orders = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "photo_url")
    private String photoUrl;

    @RestResource(exported = false)
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Column(name = "status")
    private PetStatus status;

    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @JsonIgnore
    public Tag getTag() {
        return tag;
    }
    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public PetStatus getStatus() {
        return status;
    }
    public void setStatus(PetStatus status) {
        this.status = status;
    }

}