package com.example.petStore.models;

import com.example.petStore.models.seedwork.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "T_CATEGORY")
public class Category extends AbstractEntity {

    @Column(name = "categoryName")
    public String categoryName;

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
